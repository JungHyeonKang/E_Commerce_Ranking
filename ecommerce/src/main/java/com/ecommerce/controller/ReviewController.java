package com.ecommerce.controller;

import com.ecommerce.dto.ReviewSaveRequest;
import com.ecommerce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

//    @PostMapping("/save")
//    public void save(@RequestBody ReviewSaveRequest reviewSaveRequest) {
//        reviewService.save(reviewSaveRequest);
//
//    }
}
