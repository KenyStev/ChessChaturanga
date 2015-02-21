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
public class saveWithArrayList implements Savable{
    private ArrayList<User> users;
    private ArrayList<Partida> partidas;

    public saveWithArrayList() {
        users = new ArrayList<>();
        partidas = new ArrayList<>();
    }

    @Override
    public int buscarUser(String name) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).equals(name))
                return i;
        }
        return -1;
    }

    @Override
    public boolean crearUser(String name, String pass, String email, String passFace) {
        if(buscarUser(name)==-1){
            users.add(new User(name, pass, email, passFace));
        }
        return false;
    }

    @Override
    public boolean eliminarUser(String name) {
        int index = buscarUser(name);
        if(index>=0){
            users.remove(index);
        }
        return false;
    }

    @Override
    public boolean modificarPassword(String name, String pass) {
        int index = buscarUser(name);
        if(index>=0){
            users.get(index).setPass(pass);
            return true;
        }
        return false;
    }

    @Override
    public boolean crearPartida(User player1, User player2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Partida cargarPartida(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sobrescribirPartida(Partida p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarPartida(Partida p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPartida(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transferirPartida(String path, User user1, User user2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean serializar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object deserializar(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
