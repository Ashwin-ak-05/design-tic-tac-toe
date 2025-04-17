package org.example;

import org.example.controller.GameController;
import org.example.enums.GameState;
import org.example.enums.PlayerType;
import org.example.models.Game;
import org.example.models.Player;
import org.example.models.Symbol;
import org.example.strategies.ColumnWinningStrategy;
import org.example.strategies.DiagonalWinningStrategy;
import org.example.strategies.RowWinningStrategy;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Symbol symbolOne = new Symbol('X');
        players.add(new Player("Ashwin",new Symbol('X'), PlayerType.HUMAN));
        players.add(new Player("Josh",new Symbol('O'), PlayerType.HUMAN));
        List<WinningStrategy> strategies = new ArrayList<>();
        strategies.add(new ColumnWinningStrategy());
        strategies.add(new DiagonalWinningStrategy());
        strategies.add(new RowWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.start(3,players,strategies);

        while (game.getGameState().equals(GameState.PENDING)){
            game.getBoard().print();
            game.makeMove();
        }

        if (game.getGameState().equals(GameState.ENDED)) {
            game.getBoard().print();
            System.out.println(gameController.getWinner(game).getName() + " has WON the game");
        } else {
            System.out.println("Game draw");
        }

    }
}