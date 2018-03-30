package com.kodilla.rps;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class InputData {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int numberOfRounds;

    public void input() {
        System.out.println("Hello. Please enter your name:");
        name = scanner.nextLine();
        System.out.println("\n" + name + ", how many rounds is required to win the game?");
        numberOfRounds = scanner.nextInt();
    }

    public String getMove(String movePlayerCode, Map<String, String> functionKeys) throws WrongFunctionKeyException {
        String movePlayer = functionKeys.get(movePlayerCode);
        if(movePlayer!=null) {
            return movePlayer;
        }
        throw new WrongFunctionKeyException("The key \"" + movePlayerCode + "\" is not a valid function key. Please try again.");
    }


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
