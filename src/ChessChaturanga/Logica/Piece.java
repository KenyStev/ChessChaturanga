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
    protected abstract boolean mover(Board b, int row, int col);
    
    public ArrayList<Position> getMovementsValids(){
        return movementsValids;
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
}
