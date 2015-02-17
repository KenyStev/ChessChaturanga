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
public interface Savable {
    boolean crearUser(String name, String pass, String email, String passFace);
    boolean eliminarUser(String name);
    boolean crearPartida(String player1, String player2);
    boolean guardarPartida(String code);
    boolean eliminarPartida(String code);
    boolean transferirPartida(String code, String user1, String user2);
}
