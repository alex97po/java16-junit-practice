package com.pogorelov.junitpractice;

public class Main {

    public static void main(String[] args) {
        InteractionProvider interactionProvider = new InteractionProvider(System.in, System.out);
        GoodDetailsService goodDetailsService = new GoodDetailsService(new DatabaseInitializer(), new GoodDAO());
        EngineCLI engineCLI = new EngineCLI(interactionProvider, goodDetailsService);
        engineCLI.interactWithClient();
    }
}
