package org.example.models;

import org.example.enums.CellState;
import org.example.enums.GameState;
import org.example.enums.PlayerType;
import org.example.exceptions.InvalidBotCount;
import org.example.exceptions.InvalidPlayerCount;
import org.example.strategies.WinningStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    Player winner;
    GameState gameState;
    int nextPlayerIndex;
    List<WinningStrategy> strategies;

    private Game(List<Player> players, List<WinningStrategy> strategies,int dimension){
        this.players = players;
        this.strategies = strategies;
        this.board = new Board(dimension);
        this.gameState = GameState.PENDING;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
    }

    public void makeMove(){
        Player player = players.get(nextPlayerIndex);
        Move move = player.makeMove();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = getBoard().getCells().get(row).get(col);
        cell.cellState = CellState.OCUPPIED;
        cell.setOccupiedBy(player);
        cell.setSymbol(new Symbol(player.symbol.iChar));
        move.player = player;
        move.setPlayer(player);
        move.cell = cell;

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        Move newMove = new Move(player,cell);
        moves.add(newMove);

        if(checkWinner(newMove)){
            gameState = GameState.ENDED;
            winner = player;
        }else if (moves.size() == board.getDimension() * board.getDimension()) {
            gameState = GameState.DRAW;
        }

    }
    public boolean checkWinner(Move move){
        for(WinningStrategy winningStrategy : strategies){
            if(winningStrategy.checkWinner(this.board,move)){
                return true;
            }
        }
        return false;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayer() {
        return nextPlayerIndex;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayerIndex = nextPlayer;
    }

    public List<WinningStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<WinningStrategy> strategies) {
        this.strategies = strategies;
    }

    public static class Builder{
        List<Player> players;
        List<WinningStrategy> strategies;
        int dimension;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setStrategies(List<WinningStrategy> strategies) {
            this.strategies = strategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private void validateBot(){
            int count = 0;
            for(Player player : players){
                if(player.getType().equals(PlayerType.BOT)){
                    count++;
                }
            }

            if(count>1){
                throw new InvalidBotCount("Bot count is exceeded");
            }
        }

        private void validatePlayerCount(){
            if(players.size() >= dimension ){
                throw new InvalidPlayerCount("Invalid Player");
            }
        }

        private void validate(){
            validateBot();
            validatePlayerCount();
        }

        public Game build(){
            validate();
            return new Game(players,strategies,dimension);
        }
    }

}
