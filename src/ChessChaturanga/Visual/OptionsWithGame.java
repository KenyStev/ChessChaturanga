/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessChaturanga.Visual;

import ChessChaturanga.Logica.Datos;
import ChessChaturanga.Logica.OptionGame;
import ChessChaturanga.Logica.Partida;
import ChessChaturanga.Logica.User;
import ChessChaturanga.Logica.saveWithArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author KenyStev
 */
public class OptionsWithGame extends javax.swing.JFrame {
    private OptionGame option;
    
    /**
     * Creates new form newGame
     */
    public OptionsWithGame(OptionGame option) {
        initComponents();
        this.option=option;
        loadFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbOptions = new javax.swing.JComboBox();
        btnPlay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbUsers = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Adversario:");

        btnPlay.setText("Jugar Chaturanga");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        jLabel2.setText("Transferir a:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPlay)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        boolean state=false;
        switch(option){
            case NEWGAME: state = Datos.saver.crearPartida(Datos.logedin, getUser()); break;
            case LOADGAME: Partida p = Datos.saver.cargarPartida(cmbOptions.getSelectedIndex());
                if(p!=null){state=true; new BoardVisual(p).setVisible(state);} break;
            case DELETEGAME: state = Datos.saver.eliminarPartida(cmbOptions.getSelectedIndex()+""); break;
        }
        if(state)dispose();
    }//GEN-LAST:event_btnPlayActionPerformed

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
            java.util.logging.Logger.getLogger(OptionsWithGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionsWithGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionsWithGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionsWithGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsWithGame(OptionGame.NEWGAME).setVisible(true);
            }
        });
    }

    public User getUser() {
        if (Datos.saver instanceof saveWithArrayList) {
            return ((saveWithArrayList) Datos.saver).users.get(Datos.saver.buscarUser(cmbOptions.getSelectedItem().toString()));
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JComboBox cmbOptions;
    private javax.swing.JComboBox cmbUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private void loadFrame() {
        switch(option){
            case NEWGAME:
                if (Datos.saver instanceof saveWithArrayList) {
                    for (User u : ((saveWithArrayList) Datos.saver).users) {
                        cmbOptions.addItem(u.getName());
                    }
                }
            break;
                //En las siguientes tres opciones se muestra solo las partidas del user logedin
            case LOADGAME:
            case DELETEGAME:
            case TRASFERGAME: 
                if (Datos.saver instanceof saveWithArrayList) {
                    for (Partida p : ((saveWithArrayList) Datos.saver).partidas) {
                        if(Datos.logedin.equals(p.getBoard().getPlayer1()))
                            cmbOptions.addItem(p);
                    }
                }
                jLabel1.setText("Partida:");
                if(cmbOptions.getItemCount()==0)
                    JOptionPane.showMessageDialog(this, "No Hay Partidas Guardadas!!!", "No hay Partidas!!!", JOptionPane.INFORMATION_MESSAGE);
                    
                break;
        }
        btnPlay.setText(option.name());
        if(option == OptionGame.TRASFERGAME){
            if (Datos.saver instanceof saveWithArrayList) {
                    for (User u : ((saveWithArrayList) Datos.saver).users) {
                        cmbUsers.addItem(u.getName());
                    }
                }
            jLabel2.setVisible(true);
            cmbUsers.setVisible(true);
        }else{
            jLabel2.setVisible(false);
            cmbUsers.setVisible(false);
        }
    }
}
