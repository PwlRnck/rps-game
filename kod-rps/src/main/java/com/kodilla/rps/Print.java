package com.kodilla.rps;

public class Print {


    public String printResult(String movePlayer, String moveComputer, Game game) {

        String info = String.format("%nYour move: %s. | Computer's move: %s.%s%s",
                movePlayer, moveComputer, printRoundResult(movePlayer, moveComputer, game), printCurrentResult(game));
        System.out.println(info);
        return info;
    }

    private String printRoundResult(String movePlayer, String moveComputer, Game game) {
        Evaluate evaluate = new Evaluate();
        Score score = game.getScore();
        int scorePlayer = score.getScorePlayer();
        int scoreComputer = score.getScoreComputer();
        String name = game.getInputData().getName();
        String info;

        if (evaluate.result(movePlayer, moveComputer) == 1) {
            info = "\n" + name + ", you won this round!\n";
            score.setScorePlayer(scorePlayer + 1);
        } else if (evaluate.result(moveComputer, movePlayer) == 1) {
            info = "\n" + name + ", you lost this round.\n";
            score.setScoreComputer(scoreComputer + 1);
        } else {
            info = "\nThis round ended in a draw.\n";
        }
        return info;
    }

    private String printCurrentResult(Game game) {
        int scorePlayer = game.getScore().getScorePlayer();
        int scoreComputer = game.getScore().getScoreComputer();
        int roundNumber = Math.max(scorePlayer, scoreComputer);
        int numberOfRounds = game.getInputData().getNumberOfRounds();
        String name = game.getInputData().getName();
        String result = String.format("%s-Computer   %d:%d%n", name, scorePlayer, scoreComputer);
        String info;

        if (roundNumber == numberOfRounds) {
            if (scorePlayer > scoreComputer) {
                info = String.format("%nThe final result is:%n%s%n%s%s", result, name, ", you won this game! Congrats!!!");
            } else {
                info = String.format("%nThe final result is:%n%s%n%s%s", result, name, ", unfortunately this time you lost. Have another try.");
            }
        } else {
            info = String.format("%nThe current result is:%n%s", result);
        }
        return info;
    }
}
