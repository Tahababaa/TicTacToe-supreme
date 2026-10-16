package com.taha.TicTacToe.Factories;

import com.taha.TicTacToe.Models.BotDifficultyLevel;
import com.taha.TicTacToe.Models.BotPlayer;
import com.taha.TicTacToe.Strategies.BotPlayerStrategy;
import com.taha.TicTacToe.Strategies.EasyBotPlayingStrategy;

public class BotPlayerStrategyFactory {
    public static BotPlayerStrategy getStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel==BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }else{
            throw new IllegalArgumentException("Invalid Bot Difficulty Level!");
        }

    }
}
