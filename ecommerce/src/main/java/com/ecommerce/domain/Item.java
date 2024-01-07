package com.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JoinColumn(name = "store_id")
    @ManyToOne
    private Store store;

    @OneToMany(mappedBy = "item")
    private List<OrderList> orderLists = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public Item(String name, Store store, ItemStatus itemStatus) {
        this.name = name;
        this.store = store;
        this.itemStatus = itemStatus;
    }
    public void itemSold(){
        this.itemStatus = ItemStatus.SOLD;
    }
}
