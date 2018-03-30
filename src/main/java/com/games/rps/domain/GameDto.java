package com.games.rps.domain;

import com.kodilla.rps.Dialogue;
import com.kodilla.rps.FunctionKeys;
import com.kodilla.rps.InputData;
import com.kodilla.rps.Score;

import java.util.HashMap;
import java.util.Map;

public class GameDto {
    private Score score;
    private InputData inputData;
    private Dialogue dialogue;
    public Map<String, String> functionKeys = new HashMap<>();
    private String movePlayerCode;
    private String moveComputer;
    private String info;

    public GameDto() {}

    public GameDto(InputData inputData, Score score) {
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
        this.info = "";
    }

    public Score getScore() {
        return score;
    }

    public InputData getInputData() {
        return inputData;
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

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
