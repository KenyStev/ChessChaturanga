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
    private Piece kingGreen, kingRed;
    private User player1, player2, activo;
    private boolean active;
    private int atePieces1, atePieces2;
    
    //Constructor para crear una nueva partida
    public Board(User play1, User play2) {
        pieces = new Piece[SIZE][SIZE];
        player1 = play1;
        player2 = play2;
        activo=player1;
        active=true;
        atePieces1=0;
        atePieces2=0;
        initPieces();
        setColorOfUsers();
    }

    //Constructor para cargar partida
    public Board(Board board) {
        this.pieces = board.getPieces();
        this.player1 = board.player1;
        this.player2 = board.player2;
        this.activo = board.active?player1:player2;
        this.active=board.active;
        this.atePieces1 = board.atePieces1;
        this.atePieces2 = board.atePieces2;
        setColorOfUsers();
    }
    
    public final void setColorOfUsers(){
        player1.setColor(Color.RED);
        player2.setColor(Color.GREEN);
    }
    
    /**
     * 
     * @param row
     * @param col
     * @return la pieza que esta en la row y col indicados en los parametros
     */
    public Piece getPieceAt(int row, int col){
        for (Piece[] piece : pieces) {
            for (Piece piece1 : piece) {
                if(piece1!=null && piece1.position.validar(row, col))
                    return piece1;
            }
        }
        return null;
    }
    
    //no usado
    public Board genMovements(){
        for (Piece[] piece : pieces) {
            for (Piece piece1 : piece) {
                if(piece1!=null)
                    piece1.genereMovementsValid(this);
            }
        }
        return this;
    }
    
    /**
     * Intenta mover la piece, si el lugar donde se movio se comio una pieza del
     * adversario, entonces aumenta el contarod de las piezas comidas correspondiene.
     * si se logra mover tambien cambia el turno del jugador
     * @param piece posicion de la pieza a mover
     * @param ne posicion a donde se intenta mover
     * @return true si fue posible moverla y false de lo contrario
     */
    public boolean move(Position piece, Position ne){
        boolean state = false;
        Piece p = pieces[piece.row][piece.col];
        if(p!=null && activo.valirColor(p.getColor())){
            state = p.mover(this, ne.row, ne.col);
            if(state){
                if(pieces[ne.row][ne.col]!=null && !activo.valirColor(pieces[ne.row][ne.col].getColor())){
                    if(activo.equals(player1)){
                        atePieces1++;
                        System.out.println("Piezas comidas P1: "+atePieces1);
                    }
                    else{
                        atePieces2++;
                        System.out.println("Piezas comidas P2: "+atePieces2);
                    }
                }
                pieces[ne.row][ne.col] = p;
                pieces[piece.row][piece.col]=null;
                active=!active;
                activo = active?player1:player2;
            }
        }
        return state;
    }
    
    

    public Piece[][] getPieces() {
        return pieces;
    }

    public User getActivo() {
        return activo;
    }

    public User getPlayer1() {
        return player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public int getAtePieces1() {
        return atePieces1;
    }

    public int getAtePieces2() {
        return atePieces2;
    }
    
    public void addPiece(Piece p){
        pieces[p.position.row][p.position.col] = p;
    }

    /**
     * Inicializa las pocisiones de las pieces en el tablero
     */
    private void initPieces() {
        int r1=0, r2=SIZE-1, c1=0, c2=SIZE-1;
        
        //addPiece(new Tower());
        //addPiece(new Tower());
        
        //addPiece(new Horse());
        //addPiece(new Horse());
        
        //addPiece(new Elephant());
        //addPiece(new Elephant());
        
        //addPiece(new Advisor());
        //addPiece(new Advisor());
        
        kingRed = new King(Color.RED, r2, c1++);
        kingGreen = new King(Color.GREEN, r1, c2--);
        
        addPiece(kingRed);
        addPiece(kingGreen);
        
        //addPiece(new Elephant());
        //addPiece(new Elephant());
        
        //addPiece(new Horse());
        //addPiece(new Horse());
        
        //addPiece(new Tower()); //r1++
        //addPiece(new Tower()); //r2--
        
        for (int i = 0; i < SIZE; i++) {
            addPiece(new Pawn(Color.RED, 6, i));
            addPiece(new Pawn(Color.GREEN, 1, i));
        }
    }
    
    /**
     * 
     * @param p anything piece
     * @return Rey enemigo de una piece
     */
    public King getKingEnemy(Piece p){
        if(kingRed.isEnemy(p))
            return (King)kingRed;
        else
            return (King)kingGreen;
    }
}
