package com.pogorelov.junitpractice;

import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class EngineCLITest {

    private final GoodDetailsService goodDetailsService = Mockito.mock(GoodDetailsService.class);
    private final InteractionProvider interactionProvider = Mockito.mock(InteractionProvider.class);
    private final EngineCLI engineCLI = new EngineCLI(interactionProvider, goodDetailsService);

    @Test
    public void test_shouldReturnCost() {
        String input = "ABCD";
        String expected = "7.25";
        Mockito.when(interactionProvider.ask("Print goods: ")).thenReturn(input);
        Mockito.when(goodDetailsService.calculateTotalCost(input)).thenReturn(BigDecimal.valueOf(7.25));

        engineCLI.interactWithClient();

        Mockito.verify(goodDetailsService).calculateTotalCost(input);
        Mockito.verify(interactionProvider).interact(expected);
    }
}
