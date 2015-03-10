/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import static facebook4j.internal.http.RequestMethod.GET;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KenyStev
 */
public class Datos {
                                    //User de prueba
    public static User logedin;// = new User("Keny", "keny", null, null);
    public static Savable saver = new saveWithArrayList();
    public static LinkedList<String> logs = new LinkedList<>();
}
