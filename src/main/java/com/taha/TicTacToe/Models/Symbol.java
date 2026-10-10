package com.taha.TicTacToe.Models;

public class Symbol {
    private Character symchar;

    public Character getSymchar() {
        return symchar;
    }

    public void setSymchar(Character symchar) {
        this.symchar = symchar;
    }
    public void display(){
        System.out.println(symchar);
    }
}
