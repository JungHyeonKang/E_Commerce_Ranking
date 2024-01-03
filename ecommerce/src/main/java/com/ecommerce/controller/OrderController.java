package com.ecommerce.controller;

import com.ecommerce.dto.OrderListSaveRequest;
import com.ecommerce.service.OrderListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

    private final OrderListService orderListService;

    @PostMapping("/save")
    public void order(@RequestBody OrderListSaveRequest orderListSaveRequest) {
        orderListService.order(orderListSaveRequest);
    }
}
