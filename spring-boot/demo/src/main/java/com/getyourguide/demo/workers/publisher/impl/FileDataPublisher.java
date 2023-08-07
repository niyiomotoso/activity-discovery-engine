package com.getyourguide.demo.workers.publisher.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.model.Supplier;
import com.getyourguide.demo.workers.consumer.ActivityDataConsumer;
import com.getyourguide.demo.workers.consumer.SupplierDataConsumer;
import com.getyourguide.demo.workers.publisher.DataPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * The file publisher implementation of DataPublisher abstraction.
 * */
@Service
public class FileDataPublisher implements DataPublisher {

    private ActivityDataConsumer activityDataConsumer;
    private SupplierDataConsumer supplierDataConsumer;
    @Autowired
    private ResourceLoader resourceLoader;
    public FileDataPublisher(ActivityDataConsumer activityDataConsumer, SupplierDataConsumer supplierDataConsumer) {
        this.activityDataConsumer = activityDataConsumer;
        this.supplierDataConsumer = supplierDataConsumer;

    }
    @Override
    public boolean parseActivities() {
        try {
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //read JSON file and convert to a list of activities
            var file = resourceLoader.getResource("classpath:static/activities.json").getFile();
            var activities = objectMapper.readValue(file, new TypeReference<List<Activity>>() {
            });
            this.activityDataConsumer.processActivities(activities);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean parseSuppliers() {
        try {
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //read JSON file and convert to a list of activities
            var file = resourceLoader.getResource("classpath:static/suppliers.json").getFile();
            var suppliers = objectMapper.readValue(file, new TypeReference<List<Supplier>>() {
            });
            this.supplierDataConsumer.processSuppliers(suppliers);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
