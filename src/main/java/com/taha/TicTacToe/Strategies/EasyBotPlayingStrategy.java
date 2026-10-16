package com.taha.TicTacToe.Strategies;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Cell;
import com.taha.TicTacToe.Models.CellStatus;
import com.taha.TicTacToe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayerStrategy{

    @Override
    public Move makeMove(Board board) {
        //scan through the board and return th next empty cell and make move
        for(List<Cell> row: board.getGrid()){
            for(Cell cell: row){
                if(cell.getStatus().equals(CellStatus.EMPTY)){
                    return new Move(null,new Cell(cell.getRow(),cell.getColumn()));
                }

            }

        }
        return null;

    }
}
