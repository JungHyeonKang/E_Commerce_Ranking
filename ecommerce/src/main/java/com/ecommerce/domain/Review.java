package com.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Review {

    @GeneratedValue
    @Id
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Review(String content, Store store) {
        this.content = content;
        this.store = store;
    }
}
