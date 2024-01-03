package com.ecommerce.service;

import com.ecommerce.domain.Store;
import com.ecommerce.dto.BusinessHourUpdateRequest;
import com.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {
    private final StoreRepository storeRepository;


    public List<Store> getStoreList() {
        List<Store> result = storeRepository.findAll();
        return result;
    }

    @Transactional
    public void updateBusinessHour(BusinessHourUpdateRequest dto) {
        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow();
        store.updateBusinessHour(dto.getStartTime(), dto.getEndTime());
    }
}
