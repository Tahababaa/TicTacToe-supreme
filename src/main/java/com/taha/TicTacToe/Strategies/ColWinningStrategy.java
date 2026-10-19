package com.taha.TicTacToe.Strategies;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Cell;
import com.taha.TicTacToe.Models.Move;
import com.taha.TicTacToe.Models.Player;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy{
    HashMap<Integer,HashMap<Character,Integer>> colCountMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        Character symbol = player.getSymbol().getSymchar();

        Integer col = cell.getColumn();

        colCountMap.putIfAbsent(col,new HashMap<>());
        HashMap<Character,Integer> countMap = colCountMap.get(col);
        countMap.putIfAbsent(symbol,0);
        countMap.put(symbol,countMap.get(symbol)+1);


        //Check if WON or not ie: count==dimensions

        if(countMap.get(symbol) == board.getDimension()){
            return true;
        }
        return false;
    }
}
