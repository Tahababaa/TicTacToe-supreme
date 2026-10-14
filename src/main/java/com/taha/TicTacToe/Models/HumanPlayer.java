package com.taha.TicTacToe.Models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private String email;
    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name, Symbol symbol, String email) {
        super(name, symbol);
        this.email=email;
    }

    @Override
    public Move makeMove() {
        System.out.println("It's "+this.getName() + "'s move!");
        System.out.println("Please enter the row: ");
        Integer row = scanner.nextInt();
        System.out.println("Please enter the row: ");
        Integer col = scanner.nextInt();
        Move move = new Move(this,new Cell(row,col));
        return move;
    }
}
