/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Visual;

import ChessChaturanga.Logica.Color;
import ChessChaturanga.Logica.Piece;

/**
 *
 * @author KenyStev
 */
public class Casilla extends javax.swing.JToggleButton{
    private Color color;
    private boolean activeToMove, selected;
    private Piece piece;
    
    public Casilla() {
        setBounds(TOP, TOP, 84, 84);
        activeToMove=false;
        selected=false;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
    
    public void deletePiece(){
        piece=null;
    }

    public boolean thereIsPiece() {
        return piece != null;
    }
    
    public void select(){
        selected=true;
        
    }
    
    public void unSelect(){
        selected=false;
    }

    public boolean isActiveToMove() {
        return activeToMove;
    }
    
    public boolean excangePiece(Casilla c){
        boolean state = false;
        if(c.getPiece()!=null && (!c.thereIsPiece() || c.getPiece().isEnemy(c.getPiece()))){
            setPiece(c.getPiece());
        }
        return state;
    }
}
