package com.ecommerce.dto;

import lombok.Data;

@Data
public class ItemSaveRequest {

    private String name; //상품이름
    private Long storeId; // 스토어
}
