package com.ecommerce.repository;

import com.ecommerce.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByStoreId(long id);
}
