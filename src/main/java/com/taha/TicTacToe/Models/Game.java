package com.taha.TicTacToe.Models;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus status;
    private Player winner;
    private Integer nextPlayerIndex;
    private List<WinningStrategy> winningStrategyList;
    private List<Move> moves;
}
