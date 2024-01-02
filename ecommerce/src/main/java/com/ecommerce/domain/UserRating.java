package com.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class UserRating {

    @GeneratedValue
    @Id
    private Long id;

    @JoinColumn(name = "store_id")
    @ManyToOne
    private Store store;

    private double rating;
}
