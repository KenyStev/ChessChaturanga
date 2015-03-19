/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Logica;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author KenyStev
 */
public class Datos {
                                    //User de prueba
    public static User logedin;// = new User("Keny", "keny", null, null);
//    public static Savable saver = new saveWithArrayList();
    public static Savable saver = new SaveWithFiles();
    public static LinkedList<String> logs = new LinkedList<>();
    
    private static final String USERS_PATH = SaveWithFiles.ROOT_PATH+"/chaturanga_players.cht",
            LOGS_PATH = SaveWithFiles.ROOT_PATH+"/logs.cht";

    public static void loadUsers() {
        if(saver instanceof SaveWithFiles){
            SaveWithFiles save = (SaveWithFiles)saver;
            ArrayList<User> tmp = (ArrayList<User>)save.deserializar(USERS_PATH);
            if(tmp!=null)
                save.users = tmp;
            
            LinkedList<String> tmpLogs = (LinkedList<String>)save.deserializar(LOGS_PATH);
            if(tmpLogs!=null)
                logs = tmpLogs;
        }
    }
    
    public static void unLoadUsers() {
        if(saver.serializar(USERS_PATH, ((SaveWithFiles)saver).users))
            System.out.println("Se Serializo users");
        if(saver.serializar(LOGS_PATH, logs))
            System.out.println("Se Serializo logs");
    }
}
