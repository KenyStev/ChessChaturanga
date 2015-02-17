/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import java.util.ArrayList;

/**
 *
 * @author KenyStev
 */
public class Pawn extends Piece{
    private ArrayList<Position> attaksValids= new ArrayList<>();

    public Pawn(Color color, int row, int col) {
        super("Peon", color, row, col);
    }

    @Override
    public Piece genereMovementsValid(Board b) {
        int row = position.row, col = position.col;
        switch(color){
            case GREEN: 
                if(row < b.SIZE){
                    if(b.getPieceAt(row+1, col)==null)
                        movementsValids.add(new Position(row+1, col));
                    if(col>0){
                        Piece pIzqu = b.getPieceAt(row+1, col-1);
                        if(pIzqu!=null && isEnemy(pIzqu))
                            attaksValids.add(pIzqu.position);
                    }
                    if(col<b.SIZE){
                        Piece pDer = b.getPieceAt(row+1, col+1);
                        if(pDer!=null && isEnemy(pDer))
                            attaksValids.add(pDer.position);
                    }
                }
                break;
            case RED: 
                if(row > 0){
                    if(b.getPieceAt(row-1, col)==null)
                        movementsValids.add(new Position(row-1, col));
                    if(col>0){
                        Piece pIzqu = b.getPieceAt(row-1, col-1);
                        if(pIzqu!=null && isEnemy(pIzqu))
                            attaksValids.add(pIzqu.position);
                    }
                    if(col<b.SIZE){
                        Piece pDer = b.getPieceAt(row-1, col+1);
                        if(pDer!=null && isEnemy(pDer))
                            attaksValids.add(pDer.position);
                    }
                }
                break;
        }
        
        return this;
    }

    @Override
    protected boolean validMovement(int row, int col) {
        if(row!=position.row){
            for (Position a : attaksValids) {
                if(a.validar(row, col))
                    return true;
            }
        }else{
            for (Position m : movementsValids) {
                if(m.validar(row, col))
                    return true;
            }
        }
        return false;
    }

    @Override
    protected boolean mover(Board b, int row, int col) {
        boolean isValid = validMovement(row, col);
        if(isValid){
            position.set(row, col);
            genereMovementsValid(b);
        }
        return isValid;
    }
    
}
