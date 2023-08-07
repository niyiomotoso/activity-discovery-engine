package com.getyourguide.demo;

import com.getyourguide.demo.workers.publisher.DataPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class GetYourGuideApplication {

    @Autowired
    DataPublisher dataPublisher;
	public static void main(String[] args) {
		SpringApplication.run(GetYourGuideApplication.class, args);
	}

    // trigger DB Data population on app start
    @Scheduled(initialDelay = 1, fixedDelay=Long.MAX_VALUE)
    public void triggerDataPopulation() {
        dataPublisher.parseActivities();
        dataPublisher.parseSuppliers();
    }
}
