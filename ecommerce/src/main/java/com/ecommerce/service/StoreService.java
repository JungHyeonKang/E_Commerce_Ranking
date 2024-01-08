package com.ecommerce.service;

import com.ecommerce.domain.Store;
import com.ecommerce.dto.BusinessHourUpdateRequest;
import com.ecommerce.dto.StoreListResponse;
import com.ecommerce.repository.StoreRepository;
import com.ecommerce.util.RedisUtil;
import com.ecommerce.util.ScoreCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class StoreService {
    private final StoreRepository storeRepository;

    private final RedisUtil redisUtil;

    // 스토어 랭킹순으로 조회
    public List<StoreListResponse> getStoreList() {

        // redis key로 랭킹 조회하고
        // key : "store:rank" 있으면 그대로 리턴
        Object cacheResult = redisUtil.get("store:rank");
        if (cacheResult != null) {
            return (List<StoreListResponse>) cacheResult;
        }
        // 없으면 실제로 데이터 계산
        // 레디스에 set 하고 그 결과를 리턴
        // 각 스토어 점수 생성 후 점수 높은순으로 정렬
        List<StoreListResponse> result = storeRepository.getStoreList().stream()
                .map(store -> new StoreListResponse(store, ScoreCalculator.getScore(store)))
                .sorted(Comparator.comparingDouble(StoreListResponse::getScore).reversed()).collect(Collectors.toList());

        // result를 통째로 레디스에 캐싱
        redisUtil.set("store:rank", result);

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
