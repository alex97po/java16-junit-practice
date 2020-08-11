package com.pogorelov.junitpractice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class GoodDetailsService {

    private final DatabaseInitializer initializer;
    private final GoodDAO goodDAO;


    public BigDecimal calculateTotalCost(String details) {
        Map<String, Long> goodCount = details.chars()
                .mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
        log.info("Calculated amount of each good in details: {}", goodCount);
        List<Good> goods = goodDAO.findAllGoods();
        return goods.stream()
                .filter(good -> goodCount.containsKey(good.getName()))
                .map(good -> calculateCostForGood(good, goodCount.get(good.getName())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private BigDecimal calculateCostForGood(Good good, Long count) {
        log.info("Starting calculate cost for good = {}", good.getName());
        BigDecimal totalCost;
        if (Objects.isNull(good.getPromoCount()) || good.getPromoCount() == 0) {
            log.info("Good {} has no promo count", good.getName());
            totalCost= good.getSingleCost().multiply(BigDecimal.valueOf(count));
        } else {
            long promoBlocks = count / good.getPromoCount();
            long notPromo = count % good.getPromoCount();
            totalCost = good.getPromoCost().multiply(BigDecimal.valueOf(promoBlocks))
                    .add(good.getSingleCost().multiply(BigDecimal.valueOf(notPromo)));
        }
        log.info("Calculated total cost for good {} = {}", good.getName(), totalCost);
        return totalCost;
    }
}
