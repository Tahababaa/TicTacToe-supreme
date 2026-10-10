package com.taha.TicTacToe.Controllers;

import com.taha.TicTacToe.Models.Game;
import com.taha.TicTacToe.Models.Player;
import com.taha.TicTacToe.Models.WinningStrategyType;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public Game startGame(Integer dimensions, List<Player> players, List<WinningStrategyType> winningStrategyType){
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setWinningStrategyTypes(winningStrategyType)
                .build();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }
}
