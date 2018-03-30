package com.kodilla.rps;

public enum FunctionKeys {

    STONE("1", "stone"),
    PAPER("2", "paper"),
    SCISSORS("3", "scissors"),
    END("x", "end the game"),
    NEW("n", "restart the game");

    private final String key;
    private final String keyFunction;

    FunctionKeys(String key, String keyFunction) {
        this.key = key;
        this.keyFunction = keyFunction;
    }

    public String key() {
        return key;
    }

    public String keyFunction() {
        return keyFunction;
    }


}
