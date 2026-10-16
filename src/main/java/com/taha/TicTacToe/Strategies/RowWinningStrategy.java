package com.taha.TicTacToe.Strategies;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Cell;
import com.taha.TicTacToe.Models.Move;
import com.taha.TicTacToe.Models.Player;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{
//    For each row - 1 row map (symbol:count}
//     ROw 1 -> {X-> 0,o-> 0}
    HashMap<Integer,HashMap<Character,Integer>> rowCountMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        Character symbol = player.getSymbol().getSymchar();

        Integer row = cell.getRow();

        rowCountMap.putIfAbsent(row,new HashMap<>());
        HashMap<Character,Integer> countMap = rowCountMap.get(row);
        countMap.putIfAbsent(symbol,0);
        countMap.put(symbol,countMap.get(symbol)+1);

    }
}
