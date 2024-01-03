package com.ecommerce.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UserRating {

    @GeneratedValue
    @Id
    private Long id;

    @JoinColumn(name = "store_id")
    @ManyToOne
    private Store store;

    private double rating;

    public UserRating(Store store, double rating) {
        this.store = store;
        this.rating = rating;
    }
}
