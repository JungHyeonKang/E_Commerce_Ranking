package com.ecommerce.service;

import com.ecommerce.domain.Item;
import com.ecommerce.domain.ItemStatus;
import com.ecommerce.domain.Store;
import com.ecommerce.dto.ItemSaveRequest;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void save(ItemSaveRequest itemSaveRequest) {
        Store store = storeRepository.findById(itemSaveRequest.getStoreId()).orElseThrow();

        Item item = new Item(itemSaveRequest.getName(),store, ItemStatus.CREATED);

        itemRepository.save(item);
    }

}
