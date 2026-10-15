package com.taha.TicTacToe.Strategies;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Move;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
