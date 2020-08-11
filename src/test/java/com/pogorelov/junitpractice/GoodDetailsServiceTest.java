package com.pogorelov.junitpractice;

import lombok.Getter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoodDetailsServiceTest {

    private DatabaseInitializer initializer;
    private GoodDetailsService goodDetailsService;

    @Before
    public void setUp() {
        initializer = Mockito.mock(DatabaseInitializer.class);
        goodDetailsService = new GoodDetailsService(initializer,  new GoodDAO());
        Mockito.when(initializer.getGoods()).thenReturn(goods);
    }

    @Test
    public void calculateTotalCost_validInput() {
        String details = "ABCDABA";
        BigDecimal result = goodDetailsService.calculateTotalCost(details);
        assertEquals(BigDecimal.valueOf(13.25), result);
    }

    @Test
    public void calculateTotalCost_invalidInput() {
        String details = "EFGH";
        BigDecimal result = goodDetailsService.calculateTotalCost(details);
        assertEquals(BigDecimal.ZERO, result);
    }


    @Test
    public void calculateTotalCost_emptyInput() {
        String details = "";
        BigDecimal result = goodDetailsService.calculateTotalCost(details);
        assertEquals(BigDecimal.ZERO, result);
    }


    private final List<Good> goods = List.of(
            new Good("A", BigDecimal.valueOf(1.25), 3, BigDecimal.valueOf(3)),
            new Good("B", BigDecimal.valueOf(4.25), null, null),
            new Good("C", BigDecimal.valueOf(1), 6, BigDecimal.valueOf(5)),
            new Good("D", BigDecimal.valueOf(0.75), null, null));
}
