package com.ecommerce.service;

import com.ecommerce.domain.Review;
import com.ecommerce.domain.Store;
import com.ecommerce.dto.ReviewSaveRequest;
import com.ecommerce.repository.ReviewRepository;
import com.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void save(Long storeId,ReviewSaveRequest reviewSaveRequest) {

        Store store = storeRepository.findById(storeId).orElseThrow();

        Review review = new Review(reviewSaveRequest.getContent(), store);

        reviewRepository.save(review);
    }
}
