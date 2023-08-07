package com.getyourguide.demo.integration;

import com.getyourguide.demo.repository.ActivityRepository;
import com.getyourguide.demo.repository.SupplierRepository;
import com.getyourguide.demo.workers.publisher.DataPublisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivityApiTest {
    @Autowired
    WebApplicationContext wac;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    DataPublisher dataPublisher;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        dataPublisher.parseSuppliers();
        dataPublisher.parseActivities();
    }

    @Test
    public void testUnknownEndpointReturns404() throws Exception{
         this.mockMvc.perform(MockMvcRequestBuilders.get("/unknown").contentType(MediaType.APPLICATION_JSON)
               ).andExpect(status().isNotFound());
    }

    @Test
    public void testActivityEndpointReturns200() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/activities").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void testActivityEndpointReturnsResultBasedOnLimit() throws Exception{
        int REQUEST_LIMIT = 2;

        String requestParam = "?limit=" +REQUEST_LIMIT;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/activities"+requestParam).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(REQUEST_LIMIT)));

    }

    @Test
    public void testActivityEndpointReturnsResultHasAllExpectedKeys() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/activities").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(jsonPath("$[*].currency").exists()).
                andExpect(jsonPath("$[*].specialOffer").exists()).
                andExpect(jsonPath("$[*].supplierName").exists()).
                andExpect(jsonPath("$[*].title").exists()).
                andExpect(jsonPath("$[*].rating").exists()).
                andExpect(jsonPath("$[*].price").exists());

    }

    @Test
    public void testActivityEndpointReturnsResultBasedOnSearchKeyWord() throws Exception{
        String keyword = "berlin";
        String requestParam = "?keyword=" + keyword;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/activities"+requestParam).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(jsonPath("$[*].title", containsInAnyOrder("Skip the Line: Pergamon Museum Berlin Tickets", "Berlin WelcomeCard: Transport, Discounts & Guide Book", "Skip the Line: Berlin TV Tower Ticket")));

    }

    @Test
    public void testActivityEndpointAlsoReturnsResultBasedOnSupplierKeyword() throws Exception{
        String keyword = "John";
        String requestParam = "?keyword=" + keyword;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/activities"+requestParam).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(jsonPath("$[*].supplierName", containsInAnyOrder("John Doe", "John Mark")));

    }

    @AfterEach
    public void tearDown(){
        supplierRepository.deleteAll();
        activityRepository.deleteAll();
    }
}
