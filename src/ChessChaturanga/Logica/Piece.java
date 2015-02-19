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
public abstract class Piece{
    protected ArrayList<Position> movementsValids= new ArrayList<>();
    protected Color color;
    protected String name;
    protected Position position;

    public Piece(String name,Color color, int row, int col) {
        this.color=color;
        this.name=name;
        position = new Position(row, col);
    }
    
    protected abstract Piece genereMovementsValid(Board b);
    protected abstract boolean validMovement(int row, int col);
    public abstract boolean mover(Board b, int row, int col);
    public abstract ArrayList<Position> getMovementsValids(Board b);
    
    public boolean isInMyRoad(Piece p){
        for (Position m : movementsValids) {
            if(m.validar(p.position.row, p.position.col))
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name.charAt(0)+color.getCapital();
    }

    public boolean isEnemy(Piece p) {
        return p.getColor()!=color;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Piece)
            return toString().equals(obj);
        return false;
    }
}
