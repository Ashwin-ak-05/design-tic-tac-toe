package org.example.models;


import org.example.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int dimension;
    List<List<Cell>> board;

    Board(int dimension){
        this.dimension = dimension;
        board = new ArrayList<>();

        for(int i = 0;i<dimension; i++){
            board.add(new ArrayList<>());

            for(int j = 0; j<dimension; j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void print(){
        for(int i = 0; i<dimension; i++){
            for(int j = 0; j<dimension; j++){
                Cell cell = board.get(i).get(j);
                if(cell.cellState.equals(CellState.EMPTY)){
                    System.out.print("_  ");
                }
                else{
                    System.out.print(cell.getSymbol().getiChar() + " ");
                }
            }
            System.out.println();
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getCells() {
        return board;
    }

    public void setCells(List<List<Cell>> cells) {
        this.board = cells;
    }
}
