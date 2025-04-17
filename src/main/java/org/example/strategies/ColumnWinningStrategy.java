package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Move;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int count = 0;
        int col = move.getCell().getCol();

        for(int row = 0; row < board.getDimension();row++){
            Cell cell = board.getCells().get(row).get(col);
            if((cell.getOccupiedBy()!= null) &&  cell.getOccupiedBy().getName().equals(move.getPlayer().getName())){
                count++;
            }
        }

        if(count == board.getDimension()){
            return true;
        }
        return false;
    }
}
