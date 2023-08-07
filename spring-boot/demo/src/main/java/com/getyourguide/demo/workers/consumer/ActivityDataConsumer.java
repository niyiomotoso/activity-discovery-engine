package com.getyourguide.demo.workers.consumer;

import com.getyourguide.demo.model.Activity;

import java.util.List;

/*
 * The consumer consumes activities record when called and calls right channel
 *  that will in-turn persist the record.
 * */
public interface ActivityDataConsumer {
    public boolean processActivities(List<Activity> activities);
}
