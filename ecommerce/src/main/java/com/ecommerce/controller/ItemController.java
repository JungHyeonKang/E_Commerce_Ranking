package com.ecommerce.controller;

import com.ecommerce.dto.ItemSaveRequest;
import com.ecommerce.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    public void saveItem(@RequestBody ItemSaveRequest itemSaveRequest) {
        itemService.save(itemSaveRequest);
    }
}
