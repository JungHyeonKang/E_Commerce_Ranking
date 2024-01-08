package com.ecommerce.dto;

import com.ecommerce.vo.StoreInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class StoreListResponse implements Serializable {

    private int rank; //랭크
    private double score; // 점수
    private String name; // 스토어 이름
    private int viewCount; // 조회수
    private double userRating; // 평점
    private Long businessTime; // 영업시간(분)
    private Long reviewCount; // 리뷰수
    private Long salesCount; // 판매수



    public StoreListResponse(StoreInfo storeInfo, double score) {
        this.score = score;
        this.name = storeInfo.getName();
        this.viewCount = storeInfo.getViewCount();
        this.businessTime = storeInfo.getBusinessTime();
        this.userRating = storeInfo.getUserRating();
        this.reviewCount = storeInfo.getReviewCount();
        this.salesCount = storeInfo.getSalesCount();
    }
}
