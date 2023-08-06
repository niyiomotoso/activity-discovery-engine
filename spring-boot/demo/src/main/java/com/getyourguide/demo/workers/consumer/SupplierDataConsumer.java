package com.getyourguide.demo.workers.consumer;

import com.getyourguide.demo.model.Supplier;

import java.util.List;

public interface SupplierDataConsumer {
    public boolean processSuppliers(List<Supplier> suppliers);
}
