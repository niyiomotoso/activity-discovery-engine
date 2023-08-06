package com.getyourguide.demo.workers.consumer;

import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.model.Supplier;

import java.util.List;

public interface ActivityDataConsumer {
    public boolean processActivities(List<Activity> activities);
}
