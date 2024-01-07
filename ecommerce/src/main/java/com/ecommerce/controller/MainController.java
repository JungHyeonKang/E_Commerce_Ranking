package com.ecommerce.controller;


import com.ecommerce.dto.StoreListResponse;
import com.ecommerce.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final StoreService storeService;
    
    // 스토어 조회 api (랭킹)
    @GetMapping("")
    public String getList(Model model) {

        List<StoreListResponse> storeList = storeService.getStoreList();

        model.addAttribute("data", storeList);

        return "store/storeList";
    }
}
