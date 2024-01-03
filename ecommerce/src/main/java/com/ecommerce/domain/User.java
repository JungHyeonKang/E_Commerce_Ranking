package com.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }
}
