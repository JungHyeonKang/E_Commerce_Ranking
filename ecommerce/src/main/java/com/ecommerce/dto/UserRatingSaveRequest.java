package com.ecommerce.dto;

import lombok.Data;

@Data
public class UserRatingSaveRequest {
    private double rating;
    private Long storeId;
}
