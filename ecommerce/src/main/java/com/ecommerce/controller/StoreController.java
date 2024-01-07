package com.ecommerce.controller;

import com.ecommerce.domain.Store;
import com.ecommerce.dto.BusinessHourUpdateRequest;
import com.ecommerce.dto.ReviewSaveRequest;
import com.ecommerce.dto.UserRatingSaveRequest;
import com.ecommerce.service.ReviewService;
import com.ecommerce.service.StoreService;
import com.ecommerce.service.UserRatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
@Slf4j
public class StoreController {

    private final StoreService storeService;
    private final ReviewService reviewService;
    private final UserRatingService userRatingService;


    // 리뷰 생성
    @PostMapping("/{storeId}/reviews")
    public void leaveReview(@PathVariable(name = "storeId") Long storeId,@RequestBody ReviewSaveRequest reviewSaveRequest) {

        reviewService.save(storeId,reviewSaveRequest);
    }

    // 평점 생성
    @PostMapping("/rating")
    public void rate(@RequestBody UserRatingSaveRequest userRatingSaveRequest) {

        userRatingService.save(userRatingSaveRequest);

    }

    //영업시간 수정
    @PostMapping("/businessHour")
    public void updateBusinessHours(@RequestBody BusinessHourUpdateRequest businessHourUpdateRequest) {

        storeService.updateBusinessHour(businessHourUpdateRequest);

    }

}
