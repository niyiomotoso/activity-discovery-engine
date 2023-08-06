package com.getyourguide.demo.workers.consumer.impl;

import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.service.ActivityService;
import com.getyourguide.demo.workers.consumer.ActivityDataConsumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityDataConsumerImpl implements ActivityDataConsumer {
    private ActivityService activityService;
    ActivityDataConsumerImpl(ActivityService activityService) {
        this.activityService = activityService;
    }
    @Override
    public boolean processActivities(List<Activity> activities) {
        for (Activity activity: activities) {
            this.activityService.create(activity);
        }

        return true;
    }
}
