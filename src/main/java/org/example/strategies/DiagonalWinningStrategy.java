package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();





        if(row == col){
            int countOne = 0;
            for(int i = 0; i<board.getDimension(); i++){
                Cell cell = board.getCells().get(i).get(i);
                if((cell.getOccupiedBy()!= null) && cell.getOccupiedBy().getName().equals(move.getPlayer().getName())){
                    countOne++;
                }
            }
            if(countOne == board.getDimension()){
                return true;
            }
        }




        if((row+col) == board.getDimension()-1){
            int countOne = 0;
            for(int i = 0; i<board.getDimension(); i++){
                Cell cell = board.getCells().get(i).get(board.getDimension()-i-1);
                if((cell.getOccupiedBy()!= null) && cell.getOccupiedBy().getName().equals(move.getPlayer().getName())){
                    countOne++;
                }
            }
            if(countOne == board.getDimension()){
                return true;
            }
        }
        return false;
    }
}
