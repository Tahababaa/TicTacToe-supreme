package com.taha.TicTacToe;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Game;
import com.taha.TicTacToe.Models.WinningStrategyType;
import com.taha.TicTacToe.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board(3);
        board.displayBoard();

        Game game = Game.getBuilder()
                .setDimensions(7)
                .setPlayers(new ArrayList<>())
                .setWinningStrategyTypes(List.of(WinningStrategyType.DIAGONAL, WinningStrategyType.COLUMN,WinningStrategyType.ROW,WinningStrategyType.CORNER))
                .build();

        game.getBoard().displayBoard();

    }
}
