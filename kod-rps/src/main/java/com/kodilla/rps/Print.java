package com.kodilla.rps;

public class Print {

    public String printResult(String movePlayer, String moveComputer, Game game) {

        String info = "\nYour move: " + movePlayer + ". | Computer's move: " + moveComputer + ".";
        info = info + printRoundResult(movePlayer, moveComputer, game);
        info = info + printCurrentResult(game);

        System.out.println(info);
        return info;
    }

    private String printRoundResult(String movePlayer, String moveComputer, Game game) {
        Score score = game.getScore();
        int scorePlayer = score.getScorePlayer();
        int scoreComputer = score.getScoreComputer();
        String name = game.getInputData().getName();
        String info;

        if(score.evaluate(movePlayer,moveComputer) == 1) {
            info = "\n" + name + ", you won this round!";
            score.setScorePlayer(scorePlayer + 1);
        } else if(score.evaluate(moveComputer,movePlayer) == 1) {
            info = "\n" + name + ", you lost this round.";
            score.setScoreComputer(scoreComputer + 1);
        } else {
            info = "\nThis round ended in a draw.";
        }
        return info;
    }

    private String printCurrentResult(Game game) {
        int scorePlayer = game.getScore().getScorePlayer();
        int scoreComputer = game.getScore().getScoreComputer();
        int roundNumber = Math.max(scorePlayer,scoreComputer);
        int numberOfRounds = game.getInputData().getNumberOfRounds();
        String name = game.getInputData().getName();
        String info;

        if(roundNumber == numberOfRounds) {
            info = "\nThe final result is:";
            info = info + name + "-Computer   " + scorePlayer + ":" + scoreComputer;
            if(scorePlayer>scoreComputer) {
                info = info + "\n" + name + ", you won this game! Congrats!!!";
            } else {
                info = info + "\n" + name + ", unfortunately this time you lost. Have another try.";
            }
        } else {
            info = "\nThe current result is:";
            info = info + name + "-Computer   " + scorePlayer + ":" + scoreComputer;
        }
        return info;
    }
}
