package com.taha.TicTacToe.Models;

import com.taha.TicTacToe.Strategies.WinningStrategy;
import com.taha.TicTacToe.Validations.UniquePlayerValidation;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus status;
    private Player winner;
    private Integer nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;

    private Game(GameBuilder gameBuilder) {
        this.board = new Board(gameBuilder.dimensions);
        this.players = gameBuilder.players;
        this.winningStrategies = new ArrayList<>();

        for(WinningStrategyType type:gameBuilder.winningStrategyTypes){

        }
        this.status=GameStatus.IN_PROGRESS;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex =0;
    }

    public Board getBoard() {
        return board;
    }

    public static GameBuilder getBuilder(){
        return  new GameBuilder();
    }

    public static class GameBuilder{
        private Integer dimensions;
        private List<WinningStrategyType> winningStrategyTypes;
        private List<Player> players;

        public GameBuilder setDimensions(Integer dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public GameBuilder setWinningStrategyTypes(List<WinningStrategyType> winningStrategyTypes) {
            this.winningStrategyTypes = winningStrategyTypes;
            return this;

        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;

        }

        public Game build(){
            //Validations
            UniquePlayerValidation.checkSymbol(this.players);
            return new Game(this);
        }
    }
}
