package com.ecommerce.service;

import com.ecommerce.domain.Item;
import com.ecommerce.domain.OrderList;
import com.ecommerce.domain.User;
import com.ecommerce.dto.OrderListSaveRequest;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.OrderListRepository;
import com.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderListService {

    private final OrderListRepository orderListRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void order(OrderListSaveRequest orderListSaveRequest) {
        User user = userRepository.findById(orderListSaveRequest.getUserId()).orElseThrow();
        Item item = itemRepository.findById(orderListSaveRequest.getItemId()).orElseThrow();
        OrderList orderList = new OrderList(user, item);
        orderListRepository.save(orderList);
    }
}
