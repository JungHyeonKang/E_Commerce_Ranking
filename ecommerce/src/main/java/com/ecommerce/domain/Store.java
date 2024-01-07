package com.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    private String name; // 스토어 이름

    private int view; //조회수

    private LocalTime openingTime; // 오픈시간

    private LocalTime closingTime; // 닫는시간

    @OneToMany(mappedBy = "store")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<UserRating> userRatingList = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Item> itemList = new ArrayList<>();

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, LocalTime openingTime, LocalTime closingTime, int view) {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.view = view;
    }

    // 영업시간 수정
    public void updateBusinessHour(String startTime, String endTime) {
        this.openingTime = parseTime(startTime);
        this.closingTime = parseTime(endTime);
    }

    private LocalTime parseTime(String time) {
        LocalTime parsedTime = LocalTime.parse(time);
        return parsedTime;
    }
}
