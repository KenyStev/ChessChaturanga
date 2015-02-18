/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

/**
 *
 * @author dmenjivar
 */
public class Horse extends Piece{

    public Horse(String name, Color color, int row, int col) {
        super("Horse", color, row, col);
    }

    @Override
    protected Piece genereMovementsValid(Board b) {
        int row = position.row, col = position.col;
        Piece p;
        if(row<b.SIZE-1){
            p = b.getPieceAt(row+1, col);
            if((p==null) || (p!=(null) && isEnemy(p)))
                movementsValids.add(new Position(row+1, col));
            if(col>0){
                p = b.getPieceAt(row+1, col-1);
                if((p==null) || (p!=(null) && isEnemy(p)))
                    movementsValids.add(new Position(row+1, col-1));
            }
            if(col<b.SIZE-1){
                p = b.getPieceAt(row+1, col+1);
                if((p==null) || (p!=(null) && isEnemy(p)))
                    movementsValids.add(new Position(row+1, col+1));
            }
        }
        
        if(row>0){
            p = b.getPieceAt(row-1, col);
            if((p==null) || (p!=(null) && isEnemy(p)))
                movementsValids.add(new Position(row-1, col));
            if(col>0){
                p = b.getPieceAt(row-1, col-1);
                if((p==null) || (p!=(null) && isEnemy(p)))
                    movementsValids.add(new Position(row-1, col-1));
            }
            if(col<b.SIZE-1){
                p = b.getPieceAt(row-1, col+1);
                if((p==null) || (p!=(null) && isEnemy(p)))
                    movementsValids.add(new Position(row-1, col+1));
            }
        }
        
        if(col>0){
            p = b.getPieceAt(row, col-1);
            if((p==null) || (p!=(null) && isEnemy(p)))
                movementsValids.add(new Position(row, col-1));
        }
        if(col<b.SIZE-1){
            p = b.getPieceAt(row, col+1);
            if((p==null) || (p!=(null) && isEnemy(p)))
                movementsValids.add(new Position(row, col+1));
        }
        return this;
    }

    @Override
    protected boolean validMovement(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean mover(Board b, int row, int col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
