package com.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class OrderList {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
