package com.getyourguide.demo.workers.publisher;

/*
* The publisher publishes activities and suppliers record from the implemented source to a consumer
* interface that will in-turn process it.
* */
public interface DataPublisher {
    public boolean parseActivities();
    public boolean parseSuppliers();
}
