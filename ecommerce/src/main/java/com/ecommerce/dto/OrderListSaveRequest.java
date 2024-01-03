package com.ecommerce.dto;


import lombok.Data;

@Data
public class OrderListSaveRequest {
    private Long userId;
    private Long itemId;
}
