package com.ecommerce.service;

import com.ecommerce.domain.Store;
import com.ecommerce.dto.BusinessHourUpdateRequest;
import com.ecommerce.dto.StoreListResponse;
import com.ecommerce.dto.StoreInfo;
import com.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class StoreService {
    private final StoreRepository storeRepository;

    private final ScoreService scoreService;

    // 스토어 랭킹순으로 조회
    public List<StoreListResponse> getStoreList() {

        // 각 스토어 점수 생성 후 점수 높은순으로 정렬
        List<StoreListResponse> result = storeRepository.getStoreList().stream()
                .map(store -> new StoreListResponse(store, scoreService.getScore(store)))
                .sorted(Comparator.comparingDouble(StoreListResponse::getScore).reversed()).collect(Collectors.toList());

        // 랭킹 생성 (공동 순위 x)
        IntStream.range(0, result.size())
                .forEach(index -> result.get(index).setRank(index + 1));

        return result;
    }

    // 영업시간 수정
    @Transactional
    public void updateBusinessHour(BusinessHourUpdateRequest dto) {

        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow();

        store.updateBusinessHour(dto.getStartTime(), dto.getEndTime());
    }
}
