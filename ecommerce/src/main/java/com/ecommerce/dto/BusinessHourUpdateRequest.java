package com.ecommerce.dto;

import lombok.Data;

@Data
public class BusinessHourUpdateRequest {
    private Long storeId; // 스토어 아이디
    private String startTime; // 오픈시간
    private String endTime; // 닫는 시간
}
