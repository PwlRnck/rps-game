package com.games.rps.domain;

import com.kodilla.rps.InputData;
import com.kodilla.rps.Score;

public class GameDto {
    private Score score;
    private InputData inputData;
    private String movePlayerCode;
    private String moveComputer;
    private String info;

    public GameDto() {
    }

    public GameDto(InputData inputData, Score score) {
        this.inputData = inputData;
        this.score = score;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}