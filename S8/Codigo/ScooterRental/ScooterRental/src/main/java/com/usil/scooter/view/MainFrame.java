package com.usil.scooter.view;

import com.usil.scooter.singleton.Contexto;

/** Vista principal: abre las vistas de Scooters y de Alquileres. Se edita en la pestana Design de NetBeans. */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(18f));
        setSize(640, 160);
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        btnScooters = new javax.swing.JButton();
        btnAlquileres = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alquiler de Scooters");

        lblTitulo.setText("Alquiler de Scooters");

        pnlMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        btnScooters.setText("Gestionar scooters");
        btnScooters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScootersActionPerformed(evt);
            }
        });

        btnAlquileres.setText("Gestionar alquileres");
        btnAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquileresActionPerformed(evt);
            }
        });

        btnPagos.setText("Gestionar pagos");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });

        pnlMenu.add(btnScooters);
        pnlMenu.add(btnAlquileres);
        pnlMenu.add(btnPagos);

        getContentPane().add(lblTitulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(pnlMenu, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnScootersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScootersActionPerformed
        new ScooterFrame(Contexto.getInstancia().scooterController()).setVisible(true);
    }//GEN-LAST:event_btnScootersActionPerformed

    private void btnAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquileresActionPerformed
        new AlquilerFrame(Contexto.getInstancia().alquilerController()).setVisible(true);
    }//GEN-LAST:event_btnAlquileresActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        new PagoFrame(Contexto.getInstancia().pagoController()).setVisible(true);
    }//GEN-LAST:event_btnPagosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlquileres;
    private javax.swing.JButton btnPagos;
    private javax.swing.JButton btnScooters;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
