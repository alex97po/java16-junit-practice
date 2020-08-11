package com.pogorelov.junitpractice;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class DatabaseInitializer {

    @Getter
    private final List<Good> goods = List.of(
            new Good("A", BigDecimal.valueOf(1.25), 3, BigDecimal.valueOf(3)),
            new Good("B", BigDecimal.valueOf(4.25), null, null),
            new Good("C", BigDecimal.valueOf(1), 6, BigDecimal.valueOf(5)),
            new Good("D", BigDecimal.valueOf(0.75), null, null));


}
