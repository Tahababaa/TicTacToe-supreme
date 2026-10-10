package com.taha.TicTacToe.Models;

public class Cell {
    private Integer row;
    private Integer col;
    private Symbol symbol;
    private CellStatus status;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
        this.status=CellStatus.EMPTY;
    }

    public void display() {
        if(this.status == CellStatus.EMPTY){
            System.out.print("|   |");
        }
        else{
            System.out.print("| ");
            this.symbol.display();
            System.out.print(" |");
        }
    }
}
