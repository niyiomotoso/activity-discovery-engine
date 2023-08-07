package com.getyourguide.demo.workers.consumer;

import com.getyourguide.demo.model.Supplier;

import java.util.List;

/*
 * The consumer consumes suppliers record when called and calls right channel
 *  that will in-turn persist the record.
 * */
public interface SupplierDataConsumer {
    public boolean processSuppliers(List<Supplier> suppliers);
}
