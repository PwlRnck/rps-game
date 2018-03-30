package com.games.rps.domain;

public class InputDataDto {
    private String name;
    private int numberOfRounds;

    public String getName() {
        return name;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

}
