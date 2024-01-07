package com.ecommerce.service;

import com.ecommerce.domain.Store;
import com.ecommerce.domain.UserRating;
import com.ecommerce.dto.UserRatingSaveRequest;
import com.ecommerce.repository.StoreRepository;
import com.ecommerce.repository.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRatingService {
    private final UserRatingRepository userRatingRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void save(UserRatingSaveRequest userRatingSaveRequest) {
        Store store = storeRepository.findById(userRatingSaveRequest.getStoreId()).orElseThrow();

        UserRating userRating = new UserRating(store, userRatingSaveRequest.getRating());

        userRatingRepository.save(userRating);
    }
}
