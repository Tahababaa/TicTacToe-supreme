package com.taha.TicTacToe;

import com.taha.TicTacToe.Controllers.GameController;
import com.taha.TicTacToe.Models.*;
import com.taha.TicTacToe.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      GameController gameController = new GameController();
      List<Player> players = new ArrayList<>();
      players.add(new HumanPlayer("Taha",new Symbol('X'),"taha@gmail.com"));
      players.add(new BotPlayer("Bottie",new Symbol('O'),BotDifficultyLevel.EASY));

      List<WinningStrategyType> winningStrategyTypes = new ArrayList<>();
      winningStrategyTypes.add(WinningStrategyType.ROW);

      Game game = gameController.startGame(3,players,winningStrategyTypes);

      gameController.displayBoard(game);

      while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
          gameController.makeMove(game);
          gameController.displayBoard(game);
          System.out.println("Do you want to undo the previous move? (Y/N)");
          String choice = sc.nextLine();
          if(choice.equalsIgnoreCase("Y")){
              gameController.undo(game);
          }

      }
      if(gameController.getGameStatus(game).equals(GameStatus.WON)){
          System.out.println(gameController.getGameWinner(game) + " won the game!");
      }else{
          System.out.println(" The game was a tie!");
      }

    }
}
