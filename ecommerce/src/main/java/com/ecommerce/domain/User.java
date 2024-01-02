package com.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

}
