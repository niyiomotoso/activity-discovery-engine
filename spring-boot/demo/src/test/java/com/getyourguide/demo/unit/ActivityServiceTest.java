package com.getyourguide.demo.unit;

import com.getyourguide.demo.projections.ActivityListing;
import com.getyourguide.demo.repository.ActivityRepository;
import com.getyourguide.demo.service.ActivityService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivityServiceTest {
    @Autowired
    ActivityService activityService;

    @MockBean
    ActivityRepository activityRepositoryMock;

    @Test
    public void testGetActivitiesReturnsExpectedResults() {
        int filteredListSize = 4;
        List<ActivityListing> expectedResult = invokeRepositoryMock(filteredListSize);
        // test case search empty keyword
        List<ActivityListing> actualListings = activityService.getActivities("", 10, 0);
        Assert.assertEquals(expectedResult.size(), actualListings.size());

        // test case search non-empty keyword, should return 4
        List<ActivityListing> testListings = activityService.getActivities("test-keyword", 10, 0);
        Assert.assertEquals(filteredListSize, testListings.size());

        // test case search unknown keyword, should return 0 result
        List<ActivityListing> unknownListings = activityService.getActivities("unknown-keyword", 10, 0);
        Assert.assertEquals( 0, unknownListings.size());

    }

    // mock repository
    private List<ActivityListing> invokeRepositoryMock(int filteredListSize) {
        List<ActivityListing>  expectedResult =  new ArrayList<>();
        // mock
        expectedResult.add(new TestActivityListing());
        expectedResult.add(new TestActivityListing());
        expectedResult.add(new TestActivityListing());
        expectedResult.add(new TestActivityListing());
        expectedResult.add(new TestActivityListing());
        expectedResult.add(new TestActivityListing());
        expectedResult.add(new TestActivityListing());

        when(activityRepositoryMock.getActivities(10, 0)).thenReturn(expectedResult);
        when(activityRepositoryMock.getActivities("test-keyword", 10, 0)).thenReturn(expectedResult.subList(0, filteredListSize));
        when(activityRepositoryMock.getActivities("unknown-keyword", 10, 0)).thenReturn(expectedResult.subList(0, 0));


        return expectedResult;
    }
    // mock projection
    class TestActivityListing implements ActivityListing {

        @Override
        public Long getId() {
            return null;
        }

        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public int getPrice() {
            return 0;
        }

        @Override
        public String getCurrency() {
            return null;
        }

        @Override
        public double getRating() {
            return 0;
        }

        @Override
        public boolean getSpecialOffer() {
            return false;
        }

        @Override
        public String getSupplierName() {
            return null;
        }
    }
}
