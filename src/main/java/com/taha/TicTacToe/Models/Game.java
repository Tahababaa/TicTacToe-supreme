package com.taha.TicTacToe.Models;

import com.taha.TicTacToe.Factories.WinningStrategyFactory;
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
            winningStrategies.add(WinningStrategyFactory.getStrategy(type));

        }
        this.status=GameStatus.IN_PROGRESS;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex =0;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Board getBoard() {
        return board;
    }

    public static GameBuilder getBuilder(){
        return  new GameBuilder();
    }

    public void displayBoard() {
        board.displayBoard();
    }

    public void makeMove() {
        //Identify and fetch the current player
        Player player = players.get(nextPlayerIndex);
        //Ask player to make a move
        Move move = player.makeMove(this.board);
        //Update the board and the cells
        Cell cellFromMove = move.getCell(); // just for row col info
        this.board.getGrid().get(cellFromMove.getRow()).get(cellFromMove.getColumn()).setStatus(CellStatus.FILLED);
        this.board.getGrid().get(cellFromMove.getRow()).get(cellFromMove.getColumn()).setSymbol(move.getPlayer().getSymbol());
        // update move history
        this.moves.add(move);

        // check winner logic  - update game status and winner accordingly
        for(WinningStrategy strategy : winningStrategies){
            if(strategy.checkWinner(this.board,move)){
                //update game status and winner accordingly
                this.status=GameStatus.WON;
                this.winner=move.getPlayer();
            }
        }
        //check draw
        if(board.getDimension()* board.getDimension() == moves.size()){
            this.status=GameStatus.DRAW;
        }
        // increment and nextPlayer index
        nextPlayerIndex = (nextPlayerIndex + 1) % this.players.size();

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
