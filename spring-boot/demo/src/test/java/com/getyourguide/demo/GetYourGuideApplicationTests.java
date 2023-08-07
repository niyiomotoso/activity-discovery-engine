package com.getyourguide.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GetYourGuideApplicationTests {
    public static void main (String...args){

        SpringApplication.run(GetYourGuideApplicationTests.class, args);

    }

    @Test
    public void contextLoads(){

    }
}
