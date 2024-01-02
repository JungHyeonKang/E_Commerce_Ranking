package com.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "store_id")
    @ManyToOne
    private Store store;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;
}
