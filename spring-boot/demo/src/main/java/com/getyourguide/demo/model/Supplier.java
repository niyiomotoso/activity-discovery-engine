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
@Table(name = "suppliers")
@EntityListeners(AuditingEntityListener.class)
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @Column(name="name", unique = true)
    private String name;
    private String address;
    private String zip;
    private String city;
    private String country;
}
