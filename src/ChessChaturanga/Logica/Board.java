/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

/**
 *
 * @author KenyStev
 */
public class Board {
    public static final int SIZE = 8;
    private Piece[][] pieces;
    
    public Board() {
        pieces = new Piece[SIZE][SIZE];
    }
}
