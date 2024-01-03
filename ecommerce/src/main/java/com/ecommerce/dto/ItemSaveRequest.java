package com.ecommerce.dto;

import lombok.Data;

@Data
public class ItemSaveRequest {

    private String name;
    private Long storeId;
}
