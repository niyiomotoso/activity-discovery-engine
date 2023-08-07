package com.getyourguide.demo.repository;

import com.getyourguide.demo.model.Activity;
import com.getyourguide.demo.projections.ActivityListing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
    // get all activities using the limit and skip values provided
    @Query(value = "SELECT a.id as Id, a.title as title, a.price as price, a.currency as currency, a.rating as rating, a.special_offer as specialOffer, s.name as supplierName from activities a  left join suppliers s on s.id = a.supplier_id LIMIT :limit OFFSET :skip",nativeQuery=true)
    List<ActivityListing> getActivities(@Param("limit") int limit, @Param("skip") int skip);

    // get only matching activities by looking up activity title and supplier name record
    @Query(value = "SELECT a.id as Id, a.title as title, a.price as price, a.currency as currency, a.rating as rating, a.special_offer as specialOffer, s.name as supplierName from activities a  left join suppliers s on s.id = a.supplier_id where a.title LIKE %:keyword% OR s.name LIKE %:keyword% LIMIT :limit OFFSET :skip",nativeQuery=true)
    List<ActivityListing> getActivities(@Param("keyword") String keyword, @Param("limit") int limit, @Param("skip") int skip);
}
