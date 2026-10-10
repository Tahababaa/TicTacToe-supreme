package com.taha.TicTacToe.Models;

public class HumanPlayer extends Player{
    private String email;
    public HumanPlayer(String name, Symbol symbol, String email) {
        super(name, symbol);
        this.email=email;
    }
}
