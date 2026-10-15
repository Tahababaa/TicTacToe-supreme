package com.taha.TicTacToe.Factories;

import com.taha.TicTacToe.Models.WinningStrategyType;
import com.taha.TicTacToe.Strategies.ColWinningStrategy;
import com.taha.TicTacToe.Strategies.DiagonalWinningStrategy;
import com.taha.TicTacToe.Strategies.RowWinningStrategy;
import com.taha.TicTacToe.Strategies.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getStrategy(WinningStrategyType type){
        if(type.equals(WinningStrategyType.COLUMN)){
            return new ColWinningStrategy();
        }
        else if(type.equals(WinningStrategyType.ROW)){
            return new RowWinningStrategy();
        }
        else if(type.equals(WinningStrategyType.DIAGONAL)){
            return new DiagonalWinningStrategy();
        }
        else{
            throw new IllegalArgumentException("Invalid Strategy type!");
        }

    }
}
