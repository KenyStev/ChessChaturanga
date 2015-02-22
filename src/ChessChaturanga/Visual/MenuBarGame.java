/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Visual;

import ChessChaturanga.Logica.MenuListener;
import java.awt.HeadlessException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author KenyStev
 */
public class MenuBarGame extends JMenuBar{
    private JMenu file, profile;
    private JMenuItem newGame, saveGame, openGame, deletGame, transferGame, ranking, logout,
            verMisDatos, lastGames, editPass, retirarse, salir;
    private BoardVisual b;

    /**
     * Recibe el tipo de Frame al que se le pondra el menu:
     * 'M' = Menu y 'G' = Game
     * @param type
     * @throws HeadlessException 
     */
    public MenuBarGame(char type) throws HeadlessException {
        init(type);
    }
    
    public MenuBarGame(BoardVisual b) throws HeadlessException {
        this.b=b;
        init('G');
    }
    
    public void init(char type){
        file = new JMenu("File");
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new MenuListener(b, MenuListener.NEW));
        saveGame = new JMenuItem("Save Game");
        saveGame.addActionListener(new MenuListener(b, MenuListener.SAVE));
        openGame = new JMenuItem("Open Game");
        openGame.addActionListener(new MenuListener(b, MenuListener.LOAD));
        deletGame = new JMenuItem("Delet Game");
        deletGame.addActionListener(new MenuListener(b, MenuListener.DELET));
        transferGame = new JMenuItem("Transfer Game");
        retirarse = new JMenuItem("Retirarse");
        ranking = new JMenuItem("Ranking");
        salir = new JMenuItem("Salir");
        
        file.add(newGame);
        file.add(saveGame);
        file.add(openGame);
        file.add(deletGame);
        file.add(transferGame);
        file.add(retirarse);
        file.add(ranking);
        
        profile = new JMenu("Profile");
        verMisDatos = new JMenuItem("Ver Mis Ultimos Datos");
        lastGames = new JMenuItem("Ver Mis Ultimos Juegos");
        editPass = new JMenuItem("Cambiar mi Pasword");
        logout = new JMenuItem("Logout");
        
        profile.add(verMisDatos);
        profile.add(lastGames);
        profile.add(editPass);
        profile.add(logout);
        
        add(file);
        add(profile);
        
        switch(type){
            case 'M': //Desavilitar las opciones que no lleva el Menu
                saveGame.setEnabled(false);
                retirarse.setEnabled(false);
                break;
            case 'G': //Desavilitar las opciones que no lleva el Game
                profile.setEnabled(false);
                openGame.setEnabled(false);
                deletGame.setEnabled(false);
                transferGame.setEnabled(false);
                ranking.setEnabled(false);
                salir.setEnabled(false);
                break;
        }
    }
    
}
