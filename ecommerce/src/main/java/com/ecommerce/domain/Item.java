package com.ecommerce.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JoinColumn(name = "store_id")
    @ManyToOne
    private Store store;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Item(String name, Store store, ItemStatus itemStatus) {
        this.name = name;
        this.store = store;
        this.itemStatus = itemStatus;
    }
}
