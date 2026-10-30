package com.usil.scooter.view;

import com.usil.scooter.controller.ScooterController;
import com.usil.scooter.model.Scooter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** Vista de Scooters. Solo conoce a su controller. Se edita en la pestana Design de NetBeans. */
public class ScooterFrame extends javax.swing.JFrame {

    private final ScooterController controlador;
    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Marca", "Modelo", "Tarifa/min"}, 0);

    public ScooterFrame(ScooterController controlador) {
        this.controlador = controlador;
        initComponents();
        tblScooters.setModel(modelo);
        // al elegir una fila, sus datos pasan a los campos para poder actualizar
        tblScooters.getSelectionModel().addListSelectionListener(e -> {
            int fila = tblScooters.getSelectedRow();
            if (!e.getValueIsAdjusting() && fila >= 0) {
                txtMarca.setText(String.valueOf(tblScooters.getValueAt(fila, 1)));
                txtModelo.setText(String.valueOf(tblScooters.getValueAt(fila, 2)));
                txtTarifa.setText(String.valueOf(tblScooters.getValueAt(fila, 3)));
            }
        });
        // los datos son compartidos con la otra vista: al volver a esta ventana se recargan
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                mostrar(controlador.listar());
            }
        });
        setSize(780, 420);
        setLocationRelativeTo(null);
        refrescar();
    }

    private void refrescar() {
        txtMarca.setText("");
        txtModelo.setText("");
        txtTarifa.setText("");
        mostrar(controlador.listar());
    }

    private void mostrar(List<Scooter> scooters) {
        modelo.setRowCount(0);
        scooters.forEach(s -> modelo.addRow(new Object[]{s.getId(), s.getMarca(), s.getModelo(),
            String.format("%.2f", s.getTarifaPorMinuto())}));
    }

    /** Ejecuta la accion y, si el controller rechaza los datos, muestra el aviso. */
    private void ejecutar(Runnable accion) {
        try {
            accion.run();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Escriba solo numeros en los campos numericos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Devuelve el ID de la fila elegida; si no hay fila elegida lanza un aviso. */
    private int idSeleccionado() {
        int fila = tblScooters.getSelectedRow();
        if (fila < 0) {
            throw new IllegalArgumentException("Seleccione una fila de la tabla.");
        }
        return (Integer) tblScooters.getValueAt(fila, 0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblTarifa = new javax.swing.JLabel();
        txtTarifa = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        scrollScooters = new javax.swing.JScrollPane();
        tblScooters = new javax.swing.JTable();
        pnlBuscar = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Scooters");

        pnlDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        lblMarca.setText("Marca:");

        txtMarca.setColumns(9);

        lblModelo.setText("Modelo:");

        txtModelo.setColumns(9);

        lblTarifa.setText("Tarifa/min:");

        txtTarifa.setColumns(5);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        pnlDatos.add(lblMarca);
        pnlDatos.add(txtMarca);
        pnlDatos.add(lblModelo);
        pnlDatos.add(txtModelo);
        pnlDatos.add(lblTarifa);
        pnlDatos.add(txtTarifa);
        pnlDatos.add(btnRegistrar);
        pnlDatos.add(btnActualizar);
        pnlDatos.add(btnEliminar);


        scrollScooters.setViewportView(tblScooters);

        pnlBuscar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        lblId.setText("Buscar ID:");

        txtId.setColumns(4);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblFiltro.setText("Filtrar por marca:");

        txtFiltro.setColumns(10);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar todo");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        pnlBuscar.add(lblId);
        pnlBuscar.add(txtId);
        pnlBuscar.add(btnBuscar);
        pnlBuscar.add(lblFiltro);
        pnlBuscar.add(txtFiltro);
        pnlBuscar.add(btnFiltrar);
        pnlBuscar.add(btnListar);

        getContentPane().add(pnlDatos, java.awt.BorderLayout.NORTH);
        getContentPane().add(scrollScooters, java.awt.BorderLayout.CENTER);
        getContentPane().add(pnlBuscar, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        ejecutar(() -> {
            controlador.registrar(txtMarca.getText(), txtModelo.getText(), Double.parseDouble(txtTarifa.getText().replace(',', '.')));
            refrescar();
        });
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ejecutar(() -> {
            controlador.actualizar(idSeleccionado(), txtMarca.getText(), txtModelo.getText(), Double.parseDouble(txtTarifa.getText().replace(',', '.')));
            refrescar();
        });
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ejecutar(() -> {
            controlador.eliminar(idSeleccionado());
            refrescar();
        });
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ejecutar(() -> mostrar(controlador.buscar(Integer.parseInt(txtId.getText().trim()))));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        mostrar(controlador.filtrar(txtFiltro.getText()));
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        txtId.setText("");
        txtFiltro.setText("");
        refrescar();
    }//GEN-LAST:event_btnListarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblTarifa;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JScrollPane scrollScooters;
    private javax.swing.JTable tblScooters;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtTarifa;
    // End of variables declaration//GEN-END:variables
}
