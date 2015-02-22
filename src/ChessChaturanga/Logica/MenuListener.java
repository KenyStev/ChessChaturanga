/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import ChessChaturanga.Visual.BoardVisual;
import ChessChaturanga.Visual.OptionsWithGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author KenyStev
 */
public class MenuListener implements ActionListener{
    private BoardVisual b;
    private int opcion;
    
    public static final int NEW=1, SAVE=2, LOAD=3, DELET=4, TRANSFER=5;
    
    public MenuListener(BoardVisual obj, int opcion) {
        this.b = obj;
        this.opcion = opcion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(opcion){
            case 1: //Nueva Partida
                new OptionsWithGame(OptionGame.NEWGAME).setVisible(true);
                break;
            case 2: //Salvar Partida
                b.savePartida();
                break;
            case 3: //Cargar Partida
                new OptionsWithGame(OptionGame.LOADGAME).setVisible(true);
                break;
            case 4: //Eliminar Partida
                new OptionsWithGame(OptionGame.DELETEGAME).setVisible(true);
                break;
            case 5: //Transferir Partida
                new OptionsWithGame(OptionGame.TRASFERGAME).setVisible(true);
                break;
        }
    }
    
}
