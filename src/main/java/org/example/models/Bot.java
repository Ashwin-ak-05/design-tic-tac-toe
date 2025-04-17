package org.example.models;

import org.example.enums.BotDifficulty;
import org.example.enums.PlayerType;

public class Bot extends Player{
    BotDifficulty difficulty;

    public Bot(String name, Symbol symbol, PlayerType playerType) {
        super(name, symbol, playerType);
    }
}
