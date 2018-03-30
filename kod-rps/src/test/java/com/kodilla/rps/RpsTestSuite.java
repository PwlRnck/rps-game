package com.kodilla.rps;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RpsTestSuite {

    @Test
    public void testScoreEvaluate() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);
        Game game = new Game(inputData,new Score(0,0));
        //When
        String result1 = "stone";
        String result2 = "paper";
        String result3 = "scissors";

        //Then
        assertEquals(game.getScore().evaluate(result1,result2),0);
        assertEquals(game.getScore().evaluate(result2,result1),1);
        assertEquals(game.getScore().evaluate(result1,result3),1);
        assertEquals(game.getScore().evaluate(result3,result1),0);
        assertEquals(game.getScore().evaluate(result2,result3),0);
        assertEquals(game.getScore().evaluate(result3,result2),1);
        assertEquals(game.getScore().evaluate(result1,result1),0);
        assertEquals(game.getScore().evaluate(result2,result2),0);
        assertEquals(game.getScore().evaluate(result3,result3),0);
    }


    @Test
    public void testPlayARound() {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(3);

        Dialogue dialogueMock = mock(Dialogue.class);

        Game game = new Game(inputData,new Score(0,0));
        game.setDialogue(dialogueMock);

        when(dialogueMock.computerMove(any(String.class))).thenReturn(1);

        //When
        game.setMovePlayerCode("2");
        game.playARound(game);

        //Then
        assertEquals(game.getScore().getScoreComputer(),0);
        assertEquals(game.getScore().getScorePlayer(),1);
    }
}
