/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Visual;

import ChessChaturanga.Logica.Datos;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;

/**
 *
 * @author kenystev
 */
public class Menu extends javax.swing.JFrame {
    private JDesktopPane jDP;
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess Chaturanga");
        setPreferredSize(new java.awt.Dimension(760, 430));
        setResizable(false);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void init() {
        setJMenuBar(new MenuBarGame(this));
        jDP = new JDesktopPane();
        getContentPane().add(jDP);
        jDP.setBounds(getContentPane().getBounds());
        JMenu loged = new JMenu("Logedin: "+Datos.logedin.getName());
        loged.setEnabled(false);
        getJMenuBar().add(loged);
    }

    public void showChangePass() {
        ChangePass cp = new ChangePass();
        cp.setVisible(true);
        jDP.add(cp);
    }

    public void showProfile() {
        Profile p = new Profile();
        p.setVisible(true);
        jDP.add(p);
    }

    public void showLastGames() {
        LastGames p = new LastGames();
        p.setVisible(true);
        jDP.add(p);
    }

    public JDesktopPane getjDP() {
        return jDP;
    }

    public void showRanking() {
        Ranking p = new Ranking();
        p.setVisible(true);
        jDP.add(p);
    }
}
