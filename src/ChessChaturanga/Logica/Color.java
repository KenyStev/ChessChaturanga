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
public enum Color {
    GREEN{

        @Override
        String getCapital() {
            return "V";
        }
        
    },
    RED{

        @Override
        String getCapital() {
            return "R";
        }
        
    };
    
    abstract String getCapital();
}
