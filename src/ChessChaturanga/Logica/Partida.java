/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import ChessChaturanga.Visual.BoardVisual;
import java.util.Calendar;

/**
 *
 * @author KenyStev
 */
public class Partida {
    private Board board;
    private Calendar fechaCreada, lastFechaEdited;
    private int num;
    

    public Partida(Board board, int num) {
        this.board = board;
        this.fechaCreada = Calendar.getInstance();
        this.lastFechaEdited = Calendar.getInstance();
        this.num = num;
        new BoardVisual(board).setVisible(true);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Calendar getFechaCreada() {
        return fechaCreada;
    }

    public void setFechaCreada(Calendar fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public Calendar getLastFechaEdited() {
        return lastFechaEdited;
    }

    public void setLastFechaEdited(Calendar lastFechaEdited) {
        this.lastFechaEdited = lastFechaEdited;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num + " vs "+board.getPlayer2().getName();
    }
}
