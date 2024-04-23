/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_poo;

import com.ahorcado.AhorcadoInicio;
/**
 *
 * @author jcaba
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    private String nombreU;
    
    public Inicio() {
        initComponents();
    }
    
    public void setNombreUsuario(String nombreU) {
        this.nombreU = nombreU;
        lblNombreUsuario.setText(nombreU);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_inicio = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        btnBuscaMinas = new javax.swing.JButton();
        btnAhorcado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLBienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background_inicio.setBackground(new java.awt.Color(146, 154, 171));
        background_inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreUsuario.setFont(new java.awt.Font("Lemon Juice", 1, 36)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText(".....");
        background_inicio.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 78, 118, -1));

        btnBuscaMinas.setFont(new java.awt.Font("Avocado Cake", 0, 14)); // NOI18N
        btnBuscaMinas.setText("Busca Minas");
        background_inicio.add(btnBuscaMinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 216, 120, 30));

        btnAhorcado.setFont(new java.awt.Font("Avocado Cake", 0, 14)); // NOI18N
        btnAhorcado.setText("Ahorcado");
        btnAhorcado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAhorcadoActionPerformed(evt);
            }
        });
        background_inicio.add(btnAhorcado, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 216, 100, 30));

        jLabel1.setFont(new java.awt.Font("Avocado Cake", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Qué Deseas Jugar ?");
        background_inicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 148, -1, -1));

        jPanel2.setBackground(new java.awt.Color(57, 62, 70));

        btnVolver.setBackground(new java.awt.Color(146, 154, 171));
        btnVolver.setFont(new java.awt.Font("Lemon Juice", 0, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLBienvenido.setFont(new java.awt.Font("Lemon Juice", 1, 36)); // NOI18N
        jLBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        jLBienvenido.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLBienvenido))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLBienvenido)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        background_inicio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 21, 420, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAhorcadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAhorcadoActionPerformed
        AhorcadoInicio jAhorcado = new AhorcadoInicio();
        jAhorcado.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnAhorcadoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Login jLogin = new Login();
        jLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background_inicio;
    private javax.swing.JButton btnAhorcado;
    private javax.swing.JButton btnBuscaMinas;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLBienvenido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
