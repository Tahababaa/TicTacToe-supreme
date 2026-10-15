package com.taha.TicTacToe.Validations;

import com.taha.TicTacToe.Models.Board;
import com.taha.TicTacToe.Models.Cell;
import com.taha.TicTacToe.Models.CellStatus;
import com.taha.TicTacToe.Models.Move;

public class ValidateMove {
    public static void validate(Board board, Move move){
        Cell cell = move.getCell();
        if(cell.getRow()<0 || cell.getRow() >= board.getDimension() || cell.getColumn() <0 ||
        cell.getColumn()>=board.getDimension()){
            throw new IllegalArgumentException("iNVALID MOVE, OUT OF BOUNDS");

        }
        if(board.getGrid().get(cell.getRow()).get(cell.getColumn()).getStatus().equals(CellStatus.FILLED)){
            throw new IllegalArgumentException("Invalid move! Cell is already filled1");
        }
    }
}
