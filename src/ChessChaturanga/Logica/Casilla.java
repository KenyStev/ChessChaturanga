/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import javax.swing.event.ChangeListener;

/**
 *
 * @author KenyStev
 */
public class Casilla extends javax.swing.JToggleButton{
    private Color color;
    private boolean thereIsPiece, activeToMove, selected;
    private Piece piece;
    
    public Casilla() {
        setBounds(TOP, TOP, 84, 84);
        thereIsPiece=false;
        activeToMove=false;
        selected=false;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if(piece!=null)
            thereIsPiece=true;
    }

    public Piece getPiece() {
        return piece;
    }
    
    public void deletePiece(){
        piece=null;
        thereIsPiece=false;
    }

    public boolean thereIsPiece() {
        return thereIsPiece;
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
}
