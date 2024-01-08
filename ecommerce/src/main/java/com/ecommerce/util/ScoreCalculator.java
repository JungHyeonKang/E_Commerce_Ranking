package com.ecommerce.util;

import com.ecommerce.vo.StoreInfo;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ScoreCalculator {
    // 가중치
    private static final double WEIGHT_VIEWS = 0.3; // 조회수
    private static final double WEIGHT_SALES = 0.3; // 판매수
    private static final double WEIGHT_RATING = 0.2; // 평점
    private static final double WEIGHT_REVIEWS = 0.1; // 리뷰수
    private static final double WEIGHT_BusinessHour = 0.1; // 영업시간



    // 리뷰 최소 / 최대 값
    private static final double minReviews = 0.0;
    private static final double maxReviews = 100.0;

    // 평점 최소 / 최대 값
    private static final double minRating = 0.0;
    private static final double maxRating = 5.0;

    // 조회수 최소 / 최대 값
    private static final double minViews = 0.0;  // 최소 0개
    private static final double maxViews = 100000.0; // 최대 십만

    // 판매수 최소 / 최대 값
    private static final double minSales = 0.0;
    private static final double maxSales = 100.0;

    // 영업시간 최소 / 최대 값
    private static final double minBusinessHour = 0.0;
    private static final double maxBusinessHour = 1440.0;


    //스코어 생성
    public static double getScore(StoreInfo store){

        double normalizedViews = normalize(store.getViewCount(), minViews, maxViews);
        double normalizedSales = normalize(store.getSalesCount(), minSales, maxSales);
        double normalizedRating = normalize(store.getUserRating(), minRating, maxRating);
        double normalizedReviews = normalize(store.getReviewCount(), minReviews, maxReviews);
        double normalizedBusinessHour = normalize(store.getBusinessTime(), minBusinessHour, maxBusinessHour);


        double result = calculateCompositeScore(normalizedViews, normalizedSales, normalizedRating, normalizedReviews, normalizedBusinessHour);


        return result;
    }

    // 데이터 정규화 -  최소값/ 최대값 대비 value
    // return 최대 1.0
    private static double normalize(double value, double min, double max) {
        if (min == max) {
            return 0.0;
        }
        double result = (value - min) / (max - min);

        return Math.min(result, 1.0);
    }

    // 설정한 가중치와 정규화된 데이터를 이용
    private static double calculateCompositeScore(double normalizedViews, double normalizedSales,
                                                  double normalizedRating, double normalizedReviews, double normalizedBusinessHour) {
        return WEIGHT_VIEWS * normalizedViews +
                WEIGHT_SALES * normalizedSales +
                WEIGHT_RATING * normalizedRating +
                WEIGHT_REVIEWS * normalizedReviews +
                WEIGHT_BusinessHour * normalizedBusinessHour;
    }



}
