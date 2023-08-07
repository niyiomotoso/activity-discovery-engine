package com.getyourguide.demo.controller;

import com.getyourguide.demo.constants.Constants;
import com.getyourguide.demo.projections.ActivityListing;
import com.getyourguide.demo.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActivityController {
    private ActivityService activityService;

    ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(Constants.WELCOME);
    }

    /* Api endpoint to query the repository depending on the searched Keyword and pagination parameter such as search limit
    and record count to skip
    * */
    @GetMapping("/activities")
    public ResponseEntity<List<ActivityListing>> activities(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int skip, @RequestParam(defaultValue = "12") int limit) {
        var activities = this.activityService.getActivities(keyword, limit, skip);

        return ResponseEntity.ok(activities);
    }
}
