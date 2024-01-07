package com.ecommerce.repository;

import com.ecommerce.domain.*;
import com.ecommerce.dto.StoreInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import static com.ecommerce.domain.QStore.store;
@Slf4j
public class StoreRepositoryImpl implements StoreRepositoryCustom{

    private JPAQueryFactory queryFactory;

    public StoreRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<StoreInfo> getStoreList() {
        List<StoreInfo> result = queryFactory
                .select(
                        store,
                        QReview.review.countDistinct(),
                        QUserRating.userRating.rating.avg().coalesce(0.0),
                        QOrderList.orderList.countDistinct())
                .from(store)
                .leftJoin(store.reviewList, QReview.review)
                .leftJoin(store.userRatingList, QUserRating.userRating)
                .leftJoin(store.itemList,QItem.item)
                .leftJoin(QItem.item.orderLists,QOrderList.orderList)
                .groupBy(store)
                .fetch()
                .stream()
                .map(tuple -> new StoreInfo(
                        tuple.get(store),
                        tuple.get(QUserRating.userRating.rating.avg().coalesce(0.0)),
                        tuple.get(QReview.review.countDistinct()),
                        tuple.get(QOrderList.orderList.countDistinct())
                ))
                .collect(Collectors.toList());
        return result;
    }














    //    @Override
//    public List<StoreInfo> getStoreList() {
//        List<StoreInfo> result = queryFactory
//                .select(
//                        Projections.constructor(
//                                StoreInfo.class,
//                                    store,
//                                    QReview.review.countDistinct(),
//                                    QOrderList.orderList.countDistinct(),
//                                    QUserRating.userRating.rating.avg().coalesce(0.0)
//                        )
//                )
//                .from(store)
//                .leftJoin(store.reviewList, QReview.review)
//                .leftJoin(store.itemList,QItem.item)
//                .leftJoin(store.userRatingList, QUserRating.userRating)
//                .leftJoin(QItem.item.orderLists,QOrderList.orderList)
//                .groupBy(store)
//                .fetch();
//
//        for (StoreInfo tuple : result) {
//            Long salesCount = tuple.getSalesCount();
//            Long reviewCount = tuple.getReviewCount();
//            double userRating = tuple.getUserRating();
//
//            log.info("salesCount : {}", salesCount);
//            log.info("reviewCount : {}", reviewCount);
//            log.info("userRating : {}", userRating);
//            log.info("===================================");
//        }
//
//        return result;
//    }
}
