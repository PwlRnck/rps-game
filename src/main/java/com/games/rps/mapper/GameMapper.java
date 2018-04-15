package com.games.rps.mapper;

import com.games.rps.domain.GameDto;
import com.games.rps.domain.InputDataDto;
import com.kodilla.rps.Game;
import com.kodilla.rps.InputData;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public Game mapToGame(final GameDto gameDto) {
        Game game = new Game(gameDto.getInputData(), gameDto.getScore());
        game.setMovePlayerCode(gameDto.getMovePlayerCode());
        game.setMoveComputer(gameDto.getMoveComputer());
        game.setInfo(gameDto.getInfo());

        return game;
    }

    public GameDto mapToGameDto(final Game game) {
        GameDto gameDto = new GameDto(game.getInputData(), game.getScore());
        gameDto.setMovePlayerCode(game.getMovePlayerCode());
        gameDto.setMoveComputer(game.getMoveComputer());
        gameDto.setInfo(game.getInfo());

        return gameDto;
    }

    public InputData mapToInputData(final InputDataDto inputDataDto) {
        InputData inputData = new InputData();
        inputData.setNumberOfRounds(inputDataDto.getNumberOfRounds());
        inputData.setName(inputDataDto.getName());

        return inputData;
    }

    public InputDataDto mapToInputDataDto(final InputData inputData) {
        InputDataDto inputDataDto = new InputDataDto();
        inputDataDto.setNumberOfRounds(inputData.getNumberOfRounds());
        inputDataDto.setName(inputData.getName());

        return inputDataDto;
    }

}
