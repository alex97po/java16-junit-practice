package com.pogorelov.junitpractice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Good {

    private String name;

    private BigDecimal singleCost;

    private Integer promoCount;

    private BigDecimal promoCost;
}
