package com.getyourguide.demo.controller;

import com.getyourguide.demo.workers.publisher.DataPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobController {
    private DataPublisher dataPublisher;

    JobController(DataPublisher dataPublisher) {
        this.dataPublisher = dataPublisher;
    }

    @GetMapping("/trigger")
    public ResponseEntity<Boolean> activities() {
        this.dataPublisher.parseActivities();
        this.dataPublisher.parseSuppliers();

        return ResponseEntity.ok(true);
    }
}
