package com.taha.TicTacToe.Validations;

import com.taha.TicTacToe.Exceptions.UniquePlayerException;
import com.taha.TicTacToe.Models.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePlayerValidation {

    public static void checkSymbol(List<Player> player){
        Set<Character> symbols = new HashSet<>();
        for(Player p:player ){
            if(symbols.contains(p.getSymbol().getSymchar())){
                throw new UniquePlayerException("Player symbol should be unique!");
            }
            else{
                symbols.add(p.getSymbol().getSymchar());
            }
        }
    }
}
