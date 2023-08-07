package com.getyourguide.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@Component
@Entity
@Table(name = "activities")
@EntityListeners(AuditingEntityListener.class)
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @Column(name="title", unique = true)
    private String title;
    private int price;
    private String currency;
    private double rating;
    private boolean specialOffer;
    private Long supplierId;
}
