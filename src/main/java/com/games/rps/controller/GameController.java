package com.games.rps.controller;

import com.games.rps.domain.GameDto;
import com.games.rps.domain.InputDataDto;
import com.games.rps.mapper.GameMapper;
import com.kodilla.rps.Game;
import com.kodilla.rps.InputData;
import com.kodilla.rps.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/game")
public class GameController {

    @Autowired
    GameMapper gameMapper;


    @RequestMapping(method = RequestMethod.POST, value = "newGame", consumes = APPLICATION_JSON_VALUE)
    public GameDto newGame(@RequestBody InputDataDto inputDataDto) {
        InputData inputData = gameMapper.mapToInputData(inputDataDto);
        Game game = new Game(inputData, new Score(0,0));
        return gameMapper.mapToGameDto(game);
    }

    @RequestMapping(method = RequestMethod.POST, value = "playGame", consumes = APPLICATION_JSON_VALUE)
    public GameDto playGame(@RequestBody GameDto gameDto) {
        Game game = gameMapper.mapToGame(gameDto);
        game = game.playARound(game);
        return gameMapper.mapToGameDto(game);
    }
}
