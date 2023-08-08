package com.getyourguide.demo.workers.consumer.impl;

import com.getyourguide.demo.model.Supplier;
import com.getyourguide.demo.service.SupplierService;
import com.getyourguide.demo.workers.consumer.SupplierDataConsumer;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * An implementation of SupplierDataConsumer abstraction.
 * */
@Service
public class SupplierDataConsumerImpl implements SupplierDataConsumer {
    private SupplierService supplierService;
    SupplierDataConsumerImpl(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @Override
    public boolean processSuppliers(List<Supplier> suppliers) {
        for (Supplier supplier: suppliers) {
            try {
                this.supplierService.create(supplier);
            } catch (Exception e) {
                // TODO: make exception more granular
                e.printStackTrace();
            }
            return false;
        }

        return true;
    }
}
