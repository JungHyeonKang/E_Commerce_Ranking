package com.ecommerce.dto;


import lombok.Data;

@Data
public class OrderListSaveRequest {
    private Long userId; //회원 아이디
    private Long itemId; // 상품 아이디
}
