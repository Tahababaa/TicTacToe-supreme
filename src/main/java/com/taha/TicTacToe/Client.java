package com.taha.TicTacToe;

import com.taha.TicTacToe.Controllers.GameController;
import com.taha.TicTacToe.Models.*;
import com.taha.TicTacToe.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
      GameController gameController = new GameController();
      List<Player> players = new ArrayList<>();
      players.add(new HumanPlayer("Taha",new Symbol('X'),"taha@gmail.com"));
      players.add(new BotPlayer("Bottie",new Symbol('O'),BotDifficultyLevel.EASY));

      List<WinningStrategyType> winningStrategyTypes = new ArrayList<>();
      winningStrategyTypes.add(WinningStrategyType.COLUMN);

      Game game = gameController.startGame(5,players,winningStrategyTypes);

      gameController.displayBoard(game);

    }
}
