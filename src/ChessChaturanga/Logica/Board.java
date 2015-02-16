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
    private User player1, player2, activo;
    
    //Constructor para crear una nueva partida
    public Board(String play1, String play2) {
        pieces = new Piece[SIZE][SIZE];
        player1 = new User(Color.GREEN, play1);
        player2 = new User(Color.RED, play2);
        activo=player1;
    }

    //Constructor para cargar partida
    public Board(Piece[][] pieces, User player1, User player2, User activo) {
        this.pieces = pieces;
        this.player1 = player1;
        this.player2 = player2;
        this.activo = activo;
    }
    
    
    
    public Piece getPieceAt(int row, int col){
        if(row>=0 && row<SIZE && col>=0 && col<SIZE){
            if(pieces[row][col]!=null)
                return pieces[row][col];
        }
        return null;
    }
    
    public boolean move(Position piece, Position ne){
        boolean state = false;
        Piece p = pieces[piece.row][piece.col];
        if(p!=null && p.getColor()==activo.getColor()){
            state = p.mover(this, ne.row, ne.col);
            if(state){
                pieces[ne.row][ne.col] = p;
                pieces[piece.row][piece.col]=null;
            }
        }
        return state;
    }
}
