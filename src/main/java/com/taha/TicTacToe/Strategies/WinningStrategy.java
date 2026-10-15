package com.taha.TicTacToe.Strategies;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
