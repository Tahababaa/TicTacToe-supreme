package com.taha.TicTacToe.Models;

public class BotPlayer extends Player{
    private BotDifficultyLevel difficultyLevel;
    public BotPlayer(String name, Symbol symbol,BotDifficultyLevel difficultyLevel) {
        super(name, symbol);
        this.difficultyLevel=difficultyLevel;
    }
}
