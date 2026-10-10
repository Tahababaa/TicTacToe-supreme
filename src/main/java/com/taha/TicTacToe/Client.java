package com.taha.TicTacToe;

import com.taha.TicTacToe.Models.Board;

public class Client {
    public static void main(String[] args) {
        Board board = new Board(3);
        board.displayBoard();
    }
}
