package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Score score;
    private InputData inputData;
    private Dialogue dialogue;
    public Map<String, String> functionKeys = new HashMap<>();
    private String movePlayerCode;
    private String moveComputer;
    private String info;

    public Game(InputData inputData, Score score) {
        functionKeys.put(FunctionKeys.STONE.key(), FunctionKeys.STONE.keyFunction());
        functionKeys.put(FunctionKeys.PAPER.key(), FunctionKeys.PAPER.keyFunction());
        functionKeys.put(FunctionKeys.SCISSORS.key(), FunctionKeys.SCISSORS.keyFunction());
        functionKeys.put(FunctionKeys.END.key(), FunctionKeys.END.keyFunction());
        functionKeys.put(FunctionKeys.NEW.key(), FunctionKeys.NEW.keyFunction());
        this.inputData = inputData;
        this.score = score;
        dialogue = new Dialogue(inputData);
        movePlayerCode = "";
        moveComputer = "";
        info = "";
    }

    public Game playARound(Game game) {
        String movePlayer = "";
        Print print = new Print();

        try {
            movePlayer = inputData.getMove(movePlayerCode, functionKeys);
        } catch (WrongFunctionKeyException e) {
            System.out.println(e);
            RpsRunner.play(game);
        }

        int moveComputerCode = dialogue.computerMove(movePlayerCode);
        moveComputer = functionKeys.get(Integer.toString(moveComputerCode));
        info = print.printResult(movePlayer, moveComputer, this);

        return this;
   }

    public void info() {
        System.out.println("\nHere is the list of keys associated with the game's options:");
        functionKeys.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }

    public Score getScore() {
        return score;
    }

    public InputData getInputData() {
        return inputData;
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

    public String getMovePlayerCode() {
        return movePlayerCode;
    }

    public void setMovePlayerCode(String movePlayerCode) {
        this.movePlayerCode = movePlayerCode;
    }

    public String getMoveComputer() {
        return moveComputer;
    }

    public void setMoveComputer(String moveComputer) {
        this.moveComputer = moveComputer;
    }

    public Map<String, String> getFunctionKeys() {
        return functionKeys;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}