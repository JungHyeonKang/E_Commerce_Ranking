package com.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    private String name;

    private int view;

    LocalDateTime openingTime;

    LocalDateTime closingTime;
}
