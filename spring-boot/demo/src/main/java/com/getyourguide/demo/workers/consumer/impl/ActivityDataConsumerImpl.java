package com.getyourguide.demo.workers.consumer.impl;

import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.service.ActivityService;
import com.getyourguide.demo.workers.consumer.ActivityDataConsumer;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * An implementation of ActivityDataConsumer abstraction.
 * */
@Service
public class ActivityDataConsumerImpl implements ActivityDataConsumer {
    private ActivityService activityService;
    ActivityDataConsumerImpl(ActivityService activityService) {
        this.activityService = activityService;
    }
    @Override
    public boolean processActivities(List<Activity> activities) {
        for (Activity activity: activities) {
            try {
                this.activityService.create(activity);
            } catch (Exception e) {
                // TODO: make exception more granular
                e.printStackTrace();
            }
            return false;
        }

        return true;
    }
}
