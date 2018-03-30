package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        InputData inputData = new InputData();
        inputData.input();

        Game game = new Game(inputData, new Score(0, 0));

        game.info();
        play(game);
    }

    public static void play(Game game) {

        Dialogue dialogue = new Dialogue(game.getInputData());

        Score score = game.getScore();
        int numberOfRounds = game.getInputData().getNumberOfRounds();
        int roundNumber = Math.max(score.getScorePlayer(), score.getScoreComputer());

        while(roundNumber < numberOfRounds) {

            String movePlayerCode = dialogue.makeAMoveDialogue();
            movePlayerCode = dialogue.quitConfirmation(movePlayerCode);

            game.setMovePlayerCode(movePlayerCode);

            game = game.playARound(game);
            roundNumber = Math.max(score.getScorePlayer(), score.getScoreComputer());
        }

        String decision = dialogue.finalDialogue();

        if (decision.equals(FunctionKeys.NEW.key())) {
            RpsRunner.main(null);
        } else {
            dialogue.quit();
        }
    }

}
