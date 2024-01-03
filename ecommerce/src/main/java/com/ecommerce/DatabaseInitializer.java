package com.ecommerce;

import com.ecommerce.domain.Item;
import com.ecommerce.domain.ItemStatus;
import com.ecommerce.domain.Store;
import com.ecommerce.domain.User;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.StoreRepository;
import com.ecommerce.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        String startTime = "11:00";
        String entTime = "23:00";
        Store store1 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date parsedStart = sdf.parse(startTime);
            Date parsedEnd = sdf.parse(entTime);
            Time parsedStartTime = new Time(parsedStart.getTime());
            Time parsedEndTime = new Time(parsedEnd.getTime());
            store1 = new Store("스토어1", parsedStartTime, parsedEndTime);
            storeRepository.save(store1);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        User user1 = new User("테스트유저1");
        userRepository.save(user1);

        Item item = new Item("피자", store1, ItemStatus.NORMAL);
        itemRepository.save(item);
    }
}
