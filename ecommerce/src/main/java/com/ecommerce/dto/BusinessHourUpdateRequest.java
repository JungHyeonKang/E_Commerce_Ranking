package com.ecommerce.dto;

import lombok.Data;

@Data
public class BusinessHourUpdateRequest {
    private Long storeId;
    private String startTime;
    private String endTime;
}
