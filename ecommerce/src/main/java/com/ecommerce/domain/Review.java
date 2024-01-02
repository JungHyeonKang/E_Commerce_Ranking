package com.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class Review {

    @GeneratedValue
    @Id
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
