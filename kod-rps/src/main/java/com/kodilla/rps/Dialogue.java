package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Dialogue {

    private static final int GAME_OPTIONS_NUMBER = 3;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private InputData inputData;

    public Dialogue(InputData inputData) {
        this.inputData = inputData;
    }

    public String finalDialogue() {
        System.out.printf("%nWould you like to play another game (%s) or quit the game (%s)?%n",
                FunctionKeys.NEW.key(), FunctionKeys.END.key());
        return scanner.nextLine();
    }

    public String makeAMoveDialogue() {
        System.out.printf("%n%s, please make a move.%n", inputData.getName());
        return scanner.nextLine();
    }

    public String quitDialogue() {
        String name = inputData.getName();

        System.out.printf("%s, do you really want to quit (y/n)?%n", name);
        String movePlayerCode = scanner.nextLine();
        if (movePlayerCode.equals("n")) {
            System.out.printf("%n%s, please make a move.%n", name);
            movePlayerCode = scanner.nextLine();
        } else {
            quit();
        }
        return movePlayerCode;
    }

    public String quitConfirmation(String movePlayerCode) {

        while (movePlayerCode.equals(FunctionKeys.END.key()) || movePlayerCode.equals(FunctionKeys.NEW.key())) {
            if (movePlayerCode.equals(FunctionKeys.END.key()))
                movePlayerCode = quitDialogue();
            else
                movePlayerCode = restartDialogue();
        }
        return movePlayerCode;
    }


    public String restartDialogue() {
        String name = inputData.getName();

        System.out.printf("%s, do you really want to restart the game (y/n)?%n", name);
        String movePlayerCode = scanner.nextLine();
        if (movePlayerCode.equals("n")) {
            System.out.printf("%n%s, please make a move.%n", name);
            movePlayerCode = scanner.nextLine();
        } else {
            RpsRunner.main(null);
        }
        return movePlayerCode;
    }

    public int computerMove(String movePlayerCode) {
        //fair play case
        //int moveComputerCode = random.nextInt(3) + 1;

        //foul play case
        int[] options = foulPlayCodesArray(movePlayerCode);
        return options[random.nextInt(4)];
    }

    private int[] foulPlayCodesArray(String movePlayerCode) {
        int codeAsInteger = Integer.parseInt(movePlayerCode);
        return new int[]{codeAsInteger,
                codeAsInteger + 1 <= GAME_OPTIONS_NUMBER ? codeAsInteger + 1 : 1,
                codeAsInteger + 1 <= GAME_OPTIONS_NUMBER ? codeAsInteger + 1 : 1,
                codeAsInteger + 2 > GAME_OPTIONS_NUMBER ? codeAsInteger - 1 : 1};
    }

    public void quit() {
        System.out.printf("Thank you %s for playing the game.%n", inputData.getName());
        System.exit(0);
    }
}
