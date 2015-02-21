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
public class User {
    private Color color;
    private String name, pass, email, passFace;
    private int puntos;
    private ArrayList<String> logs;

    public User(String name, String pass, String email, String passFace) {
        this.color = color;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.passFace = passFace;
        logs = new ArrayList<>();
        puntos=0;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public boolean valirColor(Color c){
        return c == color;
    }

    public String getEmail() {
        return email;
    }

    public String getPassFace() {
        return passFace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void addLog(String log){
        logs.add(log);
    }
    
    void addPoints() {
        puntos+=3;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
            return name.equals(((User)obj).name);
        if(obj instanceof String)
            return name.equals(obj);
        return false;
    }
}
