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
        movementsValids.clear();
        attaksValids.clear();
        int row = position.row, col = position.col;
        switch(color){
            case GREEN: 
                if(row < b.SIZE-1){
                    if(b.getPieceAt(row+1, col)==null)
                        movementsValids.add(new Position(row+1, col));
                    if(col>0){
                        Piece pIzqu = b.getPieceAt(row+1, col-1);
                        if(pIzqu!=null && isEnemy(pIzqu))
                            attaksValids.add(pIzqu.position);
                    }
                    if(col<b.SIZE-1){
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
                    if(col<b.SIZE-1){
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
        if(col!=position.col){
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
    public boolean mover(Board b, int row, int col) {
        System.out.println("movements valids for: "+this+": "+movementsValids.size());
        boolean isValid = validMovement(row, col);
        if(isValid){
            position.set(row, col);
            genereMovementsValid(b);
        }
        return isValid;
    }

    @Override
    public ArrayList<Position> getMovementsValids(Board b) {
        genereMovementsValid(b);
        ArrayList<Position> movements = new ArrayList<>();
        
        for (Position m : movementsValids) {
            movements.add(m);
        }
        
        for (Position p : attaksValids) {
            movements.add(p);
        }
        
        return movements;
    }
    
}
