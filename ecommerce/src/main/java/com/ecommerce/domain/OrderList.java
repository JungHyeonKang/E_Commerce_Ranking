package com.ecommerce.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class OrderList {//구매목록

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public OrderList(User user, Item item) {
        this.user = user;
        this.item = item;
    }
}
