package com.getyourguide.demo.service.impl;

import com.getyourguide.demo.model.Supplier;
import com.getyourguide.demo.repository.SupplierRepository;
import com.getyourguide.demo.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }
}
