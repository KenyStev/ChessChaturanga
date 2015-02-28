/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import ChessChaturanga.Visual.BoardVisual;
import ChessChaturanga.Visual.Menu;
import ChessChaturanga.Visual.OptionsWithGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KenyStev
 */
public class MenuListener implements ActionListener{
    private BoardVisual b;
    private Menu m;
    private int opcion, type;
    
    public static final int NEW=1, SAVE=2, LOAD=3, DELET=4, TRANSFER=5;
    
    public MenuListener(BoardVisual obj, int opcion) {
        this.b = obj;
        type = 'G';
        this.opcion = opcion;
    }
    
    public MenuListener(Menu obj, int opcion) {
        this.m = obj;
        type = 'M';
        this.opcion = opcion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OptionsWithGame owg;
        switch(opcion){
            case 1: //Nueva Partida
                if(type=='G')
                    new OptionsWithGame(OptionGame.NEWGAME).setVisible(true);
                
                break;
            case 2: //Salvar Partida
                b.savePartida();
                break;
            case 3: //Cargar Partida
                if(type=='G'){
                    owg = new OptionsWithGame(OptionGame.LOADGAME);
                    if(owg.getCount()==0){
                        JOptionPane.showMessageDialog(null, "No Hay Partidas Guardadas!!!", "No hay Partidas!!!", JOptionPane.INFORMATION_MESSAGE);
                        owg.dispose();
                    }else
                        owg.setVisible(true);
                }
                break;
            case 4: //Eliminar Partida
                if(type=='G'){
                    owg = new OptionsWithGame(OptionGame.DELETEGAME);
                    if(owg.getCount()==0){
                        JOptionPane.showMessageDialog(null, "No Hay Partidas Guardadas!!!", "No hay Partidas!!!", JOptionPane.INFORMATION_MESSAGE);
                        owg.dispose();
                    }else
                        owg.setVisible(true);
                }
                break;
            case 5: //Transferir Partida
                if(type=='G'){
                    owg = new OptionsWithGame(OptionGame.TRASFERGAME);
                    if(owg.getCount()==0){
                        JOptionPane.showMessageDialog(null, "No Hay Partidas Guardadas!!!", "No hay Partidas!!!", JOptionPane.INFORMATION_MESSAGE);
                        owg.dispose();
                    }else
                        owg.setVisible(true);
                }
                break;
        }
    }
    
}
