package com.getyourguide.demo.service;

import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.projections.ActivityListing;

import java.util.List;

public interface ActivityService {
    public List<ActivityListing> getActivities(String keyword, int limit, int skip);
    public Activity create(Activity activity);
}
