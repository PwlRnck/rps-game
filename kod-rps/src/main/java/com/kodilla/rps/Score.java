package com.kodilla.rps;

public class Score {
    private int scorePlayer;
    private int scoreComputer;

    public Score() {}

    public Score(int scorePlayer, int scoreComputer) {
        this.scorePlayer = scorePlayer;
        this.scoreComputer = scoreComputer;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public int getScoreComputer() {
        return scoreComputer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public void setScoreComputer(int scoreComputer) {
        this.scoreComputer = scoreComputer;
    }

    public int evaluate(String resultA, String resultB) {
        if(resultA.equals(FunctionKeys.SCISSORS.keyFunction()) && resultB.equals(FunctionKeys.PAPER.keyFunction()))
            return 1;
        if(resultA.equals(FunctionKeys.PAPER.keyFunction()) && resultB.equals(FunctionKeys.STONE.keyFunction()))
            return 1;
        if(resultA.equals(FunctionKeys.STONE.keyFunction()) && resultB.equals(FunctionKeys.SCISSORS.keyFunction()))
            return 1;
        return 0;
    }

}
