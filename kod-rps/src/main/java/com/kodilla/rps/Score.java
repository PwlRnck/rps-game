package com.kodilla.rps;

public class Score {
    private int scorePlayer;
    private int scoreComputer;

    public Score() {
    }

    public Score(int scorePlayer, int scoreComputer) {
        this.scorePlayer = scorePlayer;
        this.scoreComputer = scoreComputer;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public int getScoreComputer() {
        return scoreComputer;
    }

    public void setScoreComputer(int scoreComputer) {
        this.scoreComputer = scoreComputer;
    }


}
