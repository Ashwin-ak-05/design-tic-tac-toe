package org.example.controller;

import org.example.enums.GameState;
import org.example.models.Game;
import org.example.models.Move;
import org.example.models.Player;
import org.example.strategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game start(int dimension, List<Player> players, List<WinningStrategy> strategies){
        return Game.getBuilder().setDimension(3).setPlayers(players).setStrategies(strategies).build();
    }

    public void print(Game game){
        game.getBoard().print();
    }

    public GameState getState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void MakeMove(Move move){

    }
}
