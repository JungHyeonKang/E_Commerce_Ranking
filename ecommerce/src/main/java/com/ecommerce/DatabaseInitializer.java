package com.ecommerce;

import com.ecommerce.domain.*;
import com.ecommerce.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseInitializer {

    private final StoreRepository storeRepository;
    
    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    private final ReviewRepository reviewRepository;
    private final UserRatingRepository userRatingRepository;
    private final OrderListRepository orderListRepository;

    @PostConstruct
    public void init() {

        // 스토어 생성
        Store store1 = new Store("스토어1",LocalTime.of(9, 0),LocalTime.of(22, 30),80000);
        storeRepository.save(store1);
        Store store2 = new Store("스토어2",LocalTime.of(9, 30),LocalTime.of(19, 30),20000);
        storeRepository.save(store2);
        Store store3 = new Store("스토어3",LocalTime.of(8,0),LocalTime.of(20, 0),30000);
        storeRepository.save(store3);
        Store store4 = new Store("스토어4",LocalTime.of(14, 00),LocalTime.of(23, 0),40000);
        storeRepository.save(store4);
        Store store5 = new Store("스토어5",LocalTime.of(10, 00),LocalTime.of(22, 0),50000);
        storeRepository.save(store5);

        // 유저 생성
        User user1 = new User("테스트유저1");
        userRepository.save(user1);

        itemInit(store1, store2, store3, store4, store5);

        reviewInit(store1, store2, store3, store4, store5);

         userRatingInit(store1, store2, store3, store4, store5);

         orderListInit(user1);


    }

    private void orderListInit(User user1) {
        List<Item> itemList1 = itemRepository.findAllByStoreId(1L);
        List<Item> itemList2 = itemRepository.findAllByStoreId(2L);
        List<Item> itemList3 = itemRepository.findAllByStoreId(3L);
        List<Item> itemList4 = itemRepository.findAllByStoreId(4L);
        List<Item> itemList5 = itemRepository.findAllByStoreId(5L);

        for (int i = 0; i < itemList1.size(); i++) {
            OrderList orderList = new OrderList(user1, itemList1.get(i));
            orderListRepository.save(orderList);
        }
        for (int i = 0; i < itemList2.size(); i++) {
            OrderList orderList = new OrderList(user1, itemList2.get(i));
            orderListRepository.save(orderList);
        }
        for (int i = 0; i < itemList3.size(); i++) {
            OrderList orderList = new OrderList(user1, itemList3.get(i));
            orderListRepository.save(orderList);
        }
        for (int i = 0; i < itemList4.size(); i++) {
            OrderList orderList = new OrderList(user1, itemList4.get(i));
            orderListRepository.save(orderList);
        }
        for (int i = 0; i < itemList5.size(); i++) {
            OrderList orderList = new OrderList(user1, itemList5.get(i));
            orderListRepository.save(orderList);
        }
    }

    private void userRatingInit(Store store1, Store store2, Store store3, Store store4, Store store5) {
        double userRatingCnt1 = 1.0;
        double userRatingCnt2 = 2.0;
        double userRatingCnt3 = 3.0;
        double userRatingCnt4 = 4.0;
        double userRatingCnt5 = 5.0;

        UserRating userRating = new UserRating(store1, userRatingCnt1);
        UserRating userRating11 = new UserRating(store1, userRatingCnt2);

        UserRating userRating2 = new UserRating(store2, userRatingCnt2);
        UserRating userRating22 = new UserRating(store2, 4.0);

        UserRating userRating3 = new UserRating(store3, userRatingCnt3);
        UserRating userRating4 = new UserRating(store4, userRatingCnt4);
        UserRating userRating5 = new UserRating(store5, userRatingCnt5);

        userRatingRepository.save(userRating);
        userRatingRepository.save(userRating11);

        userRatingRepository.save(userRating2);
        userRatingRepository.save(userRating22);

        userRatingRepository.save(userRating3);
        userRatingRepository.save(userRating4);
        userRatingRepository.save(userRating5);
    }

    private void reviewInit(Store store1, Store store2, Store store3, Store store4, Store store5) {
        int reviewCnt1 = 5;
        int reviewCnt2 = 3;
        int reviewCnt3 = 4;
        int reviewCnt4 = 2;
        int reviewCnt5 = 6;
        for (int i = 1; i <= reviewCnt1; i++) {
            Review review = new Review("스토어1테스트리뷰" + i, store1);
            reviewRepository.save(review);
        }
        for (int i = 1; i <= reviewCnt2; i++) {
            Review review = new Review("스토어2테스트리뷰" + i, store2);
            reviewRepository.save(review);
        }
        for (int i = 1; i <= reviewCnt3; i++) {
            Review review = new Review("스토어3테스트리뷰" + i, store3);
            reviewRepository.save(review);
        }
        for (int i = 1; i <= reviewCnt4; i++) {
            Review review = new Review("스토어4테스트리뷰" + i, store4);
            reviewRepository.save(review);
        }
        for (int i = 1; i <= reviewCnt5; i++) {
            Review review = new Review("스토어5테스트리뷰" + i, store5);
            reviewRepository.save(review);
        }
    }

    private void itemInit(Store store1, Store store2, Store store3, Store store4, Store store5) {
        // 상품 생성
        int storeItemCnt1 = 5;
        int storeItemCnt2 = 5;
        int storeItemCnt3 = 5;
        int storeItemCnt4 = 5;
        int storeItemCnt5 = 5;

        for (int i = 1; i <= storeItemCnt1; i++) {
            Item item = new Item("스토어1상품" + i, store1, ItemStatus.CREATED);
            itemRepository.save(item);
        }
        for (int i = 1; i <= storeItemCnt2; i++) {
            Item item = new Item("스토어2상품" + i, store2, ItemStatus.CREATED);
            itemRepository.save(item);
        }
        for (int i = 1; i <= storeItemCnt3; i++) {
            Item item = new Item("스토어3상품" + i, store3, ItemStatus.CREATED);
            itemRepository.save(item);
        }
        for (int i = 1; i <= storeItemCnt4; i++) {
            Item item = new Item("스토어4상품" + i, store4, ItemStatus.CREATED);
            itemRepository.save(item);
        }
        for (int i = 1; i <= storeItemCnt5; i++) {
            Item item = new Item("스토어5상품" + i, store5, ItemStatus.CREATED);
            itemRepository.save(item);
        }
    }
}
