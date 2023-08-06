package com.getyourguide.demo.repository;

import com.getyourguide.demo.model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository  extends CrudRepository<Supplier, Long> {

}
