package com.getyourguide.demo.service.impl;

import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.projections.ActivityListing;
import com.getyourguide.demo.repository.ActivityRepository;
import com.getyourguide.demo.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    private ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    @Override
    public List<ActivityListing> getActivities(String keyword, int limit, int skip) {
        // check if a particular keyword is needed in the result and redirect the appropriate method
        if (keyword.equals("")) {
            return this.activityRepository.getActivities(limit, skip);
        } else {
            return this.activityRepository.getActivities(keyword, limit, skip);
        }
    }

    @Override
    public Activity create(Activity activity) {
        return this.activityRepository.save(activity);
    }
}
