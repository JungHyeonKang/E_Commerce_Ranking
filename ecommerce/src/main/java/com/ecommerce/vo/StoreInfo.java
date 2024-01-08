package com.ecommerce.vo;

import com.ecommerce.domain.Store;
import lombok.Data;

import java.time.temporal.ChronoUnit;

@Data
public class StoreInfo {

    private String name; //이름
    private int viewCount; // 조회수
    private double userRating; // 평점
    private Long businessTime; // 영업시간(분)
    private Long reviewCount; // 리뷰수
    private Long salesCount; // 판매수

    public StoreInfo(Store store, double userRating, Long reviewCount, Long salesCount) {
        this.name = store.getName();
        this.viewCount = store.getView();
        this.businessTime = store.getOpeningTime().until(store.getClosingTime(), ChronoUnit.MINUTES);
        this.userRating = userRating;
        this.reviewCount = reviewCount;
        this.salesCount = salesCount;
    }


}
