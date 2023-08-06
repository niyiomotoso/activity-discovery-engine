package com.getyourguide.demo.projections;

public interface ActivityListing {
    // activity details
    Long getId();
    String getTitle();
    int getPrice();
    String getCurrency();
    double getRating();
    boolean getSpecialOffer();

    // supplier details
    String getSupplierName();
}
