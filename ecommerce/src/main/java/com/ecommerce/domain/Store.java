package com.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    private String name;

    private int view;

    private Time openingTime;

    private Time closingTime;

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, Time openingTime, Time closingTime) {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    public void updateBusinessHour(String startTime, String endTime) {
        this.openingTime = parseTime(startTime);
        this.closingTime = parseTime(endTime);
    }

    private Time parseTime(String time) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date parsedDate = null;
        try {
            parsedDate = sdf.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Time parsedTime = new Time(parsedDate.getTime());
        return parsedTime;
    }
}
