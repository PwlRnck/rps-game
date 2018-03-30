package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Dialogue {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private InputData inputData;

    public Dialogue(InputData inputData) {
        this.inputData = inputData;
    }

    public String finalDialogue() {
        System.out.println("\nWould you like to play another game (" + FunctionKeys.NEW.key() + ") or quit the game (" + FunctionKeys.END.key() + ")?");
        return scanner.nextLine().toString();
    }

    public String makeAMoveDialogue() {
        System.out.println("\n" + inputData.getName() + ", please make a move.");
        return scanner.nextLine().toString();
    }

    public String quitDialogue() {
        String name = inputData.getName();

        System.out.println(name + ", do you really want to quit (y/n)?");
        String movePlayerCode = scanner.nextLine().toString();
        if (movePlayerCode.equals(FunctionKeys.NEW.key())) {
            System.out.println("\n" + name + ", please make a move.");
            movePlayerCode = scanner.nextLine();
        } else {
            quit();
        }
        return movePlayerCode;
    }

    public String quitConfirmation(String movePlayerCode) {

        while(movePlayerCode.equals(FunctionKeys.END.key()) || movePlayerCode.equals(FunctionKeys.NEW.key())) {
            if (movePlayerCode.equals(FunctionKeys.END.key()))
                movePlayerCode = quitDialogue();
            else
                movePlayerCode = restartDialogue();
        }
        return movePlayerCode;
    }


    public String restartDialogue() {
        String name = inputData.getName();

        System.out.println(name + ", do you really want to restart the game (y/n)?");
        String movePlayerCode = scanner.nextLine().toString();
        if (movePlayerCode.equals(FunctionKeys.NEW.key())) {
            System.out.println("\n" + name + ", please make a move.");
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
        return new int[] {Integer.parseInt(movePlayerCode),
                Integer.parseInt(movePlayerCode) + 1 <= 3 ? Integer.parseInt(movePlayerCode) + 1 : 1,
                Integer.parseInt(movePlayerCode) + 1 <= 3 ? Integer.parseInt(movePlayerCode) + 1 : 1,
                Integer.parseInt(movePlayerCode) + 2 > 3 ? Integer.parseInt(movePlayerCode) - 1 : 1};
    }

    public void quit() {
        System.out.println("Thank you " + inputData.getName() + " for playing the game.");
        System.exit(0);
    }
}
