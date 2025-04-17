package org.example.models;

import org.example.enums.CellState;
import org.example.enums.PlayerType;

import java.util.Scanner;

public class Player {
    String name;
    Symbol symbol;
    PlayerType type;
    Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.type = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move makeMove(){
        System.out.println(this.name + ", please make your move");
        System.out.println("Please enter the row");
        int row = scanner.nextInt();
        System.out.println("Please enter the col");
        int col = scanner.nextInt();

        Cell cell = new Cell(row,col);
        cell.setCellState(CellState.OCUPPIED);


        return new Move(this,cell);
    }


}
