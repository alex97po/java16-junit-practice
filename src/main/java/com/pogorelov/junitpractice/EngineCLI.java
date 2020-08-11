package com.pogorelov.junitpractice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
public class EngineCLI {

    private final InteractionProvider asker;
    private final GoodDetailsService goodDetailsService;

    public void interactWithClient() {
        String input = asker.ask("Print goods: ");
        BigDecimal result = goodDetailsService.calculateTotalCost(input);
        asker.interact(result.toString());
    }

}
