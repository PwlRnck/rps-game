package com.kodilla.rps;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class RpsTestSuite {

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void testScoreEvaluate() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);
        Evaluate evaluate = new Evaluate();
        //When
        String result1 = "stone";
        String result2 = "paper";
        String result3 = "scissors";

        //Then
        assertEquals(evaluate.result(result1, result2), 0);
        assertEquals(evaluate.result(result2, result1), 1);
        assertEquals(evaluate.result(result1, result3), 1);
        assertEquals(evaluate.result(result3, result1), 0);
        assertEquals(evaluate.result(result2, result3), 0);
        assertEquals(evaluate.result(result3, result2), 1);
        assertEquals(evaluate.result(result1, result1), 0);
        assertEquals(evaluate.result(result2, result2), 0);
        assertEquals(evaluate.result(result3, result3), 0);
    }


    @Test
    public void testPlayARound() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);

        Dialogue dialogueMock = mock(Dialogue.class);

        Game game = new Game(inputData, new Score(0, 0));
        game.setDialogue(dialogueMock);

        when(dialogueMock.computerMove(any(String.class))).thenReturn(1);

        //When
        game.setMovePlayerCode("2");
        game.playARound(game);

        //Then
        assertEquals(game.getScore().getScoreComputer(), 0);
        assertEquals(game.getScore().getScorePlayer(), 1);
    }

    @Test
    public void testQuitDialogue() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);
        Dialogue dialogue = new Dialogue(inputData);
        systemInMock.provideLines("n", "1");

        //When
        String test1 = dialogue.quitDialogue();

        //Then
        assertEquals(test1, "1");
    }

    @Test
    public void testRestartDialogue() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);
        Dialogue dialogue = new Dialogue(inputData);
        systemInMock.provideLines("n", "1");

        //When
        String test1 = dialogue.restartDialogue();

        //Then
        assertEquals(test1, "1");
    }

    @Test
    public void testQuitConfirmation() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);
        Dialogue dialogue = new Dialogue(inputData);

        //When
        String test1 = dialogue.quitConfirmation(FunctionKeys.STONE.key());
        String test2 = dialogue.quitConfirmation(FunctionKeys.PAPER.key());
        String test3 = dialogue.quitConfirmation(FunctionKeys.SCISSORS.key());
        systemInMock.provideLines("n", "1");
        String test4 = dialogue.quitConfirmation(FunctionKeys.NEW.key());
        systemInMock.provideLines("n", "2");
        String test5 = dialogue.quitConfirmation(FunctionKeys.END.key());

        //Then
        assertEquals(test1, "1");
        assertEquals(test2, "2");
        assertEquals(test3, "3");
        assertEquals(test4, "1");
        assertEquals(test5, "2");
    }

    @Test
    public void testGetMove() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);
        Game game = new Game(inputData, new Score(0, 0));

        //When
        String test1 = null;
        String test2 = null;
        String test3 = null;
        String test4 = null;
        String test5 = null;
        try {
            test1 = inputData.getMove(FunctionKeys.STONE.key(), game.getFunctionKeys());
            test2 = inputData.getMove(FunctionKeys.PAPER.key(), game.getFunctionKeys());
            test3 = inputData.getMove(FunctionKeys.SCISSORS.key(), game.getFunctionKeys());
            test4 = inputData.getMove(FunctionKeys.NEW.key(), game.getFunctionKeys());
            test5 = inputData.getMove(FunctionKeys.END.key(), game.getFunctionKeys());
        } catch (WrongFunctionKeyException e) {
            e.printStackTrace();
        }

        //Then
        assertEquals(test1, FunctionKeys.STONE.keyFunction());
        assertEquals(test2, FunctionKeys.PAPER.keyFunction());
        assertEquals(test3, FunctionKeys.SCISSORS.keyFunction());
        assertEquals(test4, FunctionKeys.NEW.keyFunction());
        assertEquals(test5, FunctionKeys.END.keyFunction());
    }

    @Test
    public void testPrintResult() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(2);
        Game game = new Game(inputData, new Score(0, 0));
        Print print = new Print();

        //When
        String movePlayer1 = "paper";
        String moveComputer1 = "stone";
        String test1 = print.printResult(movePlayer1, moveComputer1, game);

        String movePlayer2 = "scissors";
        String moveComputer2 = "stone";
        String test2 = print.printResult(movePlayer2, moveComputer2, game);

        String movePlayer3 = "scissors";
        String moveComputer3 = "paper";
        String test3 = print.printResult(movePlayer3, moveComputer3, game);

        //Then
        assertEquals(String.format("%nYour move: %s. | Computer's move: %s.%s%s",
                movePlayer1, moveComputer1,
                String.format("%n%s, you won this round!%n", inputData.getName()),
                String.format("%nThe current result is:%n%s",
                        String.format("%s-Computer   %d:%d%n", inputData.getName(), 1, 0))).replaceAll("\\p{C}", ""), test1.replaceAll("\\p{C}", ""));

        assertEquals(String.format("%nYour move: %s. | Computer's move: %s.%s%s",
                movePlayer2, moveComputer2,
                String.format("%n%s, you lost this round.%n", inputData.getName()),
                String.format("%nThe current result is:%n%s",
                        String.format("%s-Computer   %d:%d%n", inputData.getName(), 1, 1))).replaceAll("\\p{C}", ""),
                test2.replaceAll("\\p{C}", ""));

        assertEquals(String.format("%nYour move: %s. | Computer's move: %s.%s%s",
                movePlayer3, moveComputer3,
                String.format("%n%s, you won this round!%n", inputData.getName()),
                String.format("%nThe final result is:%n%s%n%s%s",
                        String.format("%s-Computer   %d:%d%n", inputData.getName(), 2, 1),
                        inputData.getName(), ", you won this game! Congrats!!!")).replaceAll("\\p{C}", ""),
                test3.replaceAll("\\p{C}", ""));

    }
}