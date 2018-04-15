package com.games.rps.controller;

import com.games.rps.domain.GameDto;
import com.games.rps.mapper.GameMapper;
import com.google.gson.Gson;
import com.kodilla.rps.Game;
import com.kodilla.rps.InputData;
import com.kodilla.rps.Score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameMapper gameMapper;

    @MockBean
    private Game game;

    @Test
    public void testNewGame() throws Exception {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(2);
        GameDto gameDto = new GameDto(inputData, new Score(0, 0));

        when(gameMapper.mapToInputData(any())).thenReturn(inputData);
        when(gameMapper.mapToGameDto(any())).thenReturn(gameDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(gameDto);

        //When&Then
        mockMvc.perform(post("/v1/game/newGame")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonContent))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.inputData.name", is("Paweł")))
                .andExpect(jsonPath("$.inputData.numberOfRounds", is(2)));

    }

    @Test
    public void testPlayGame() throws Exception {
        //Given
        InputData inputData = new InputData();
        inputData.setName("Paweł");
        inputData.setNumberOfRounds(2);
        Game game2 = new Game(inputData, new Score(1, 0));
        GameDto gameDto = new GameDto(inputData, new Score(game2.getScore().getScorePlayer(), game2.getScore().getScoreComputer()));

        when(gameMapper.mapToGame(any())).thenReturn(game);
        when(game.playARound(any())).thenReturn(game2);
        when(gameMapper.mapToGameDto(any())).thenReturn(gameDto);


        Gson gson = new Gson();
        String jsonContent = gson.toJson(gameDto);

        //When&Then
        mockMvc.perform(post("/v1/game/playGame")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonContent))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.inputData.name", is("Paweł")))
                .andExpect(jsonPath("$.inputData.numberOfRounds", is(2)))
                .andExpect(jsonPath("$.score.scorePlayer", is(1)))
                .andExpect(jsonPath("$.score.scoreComputer", is(0)));
    }
}
