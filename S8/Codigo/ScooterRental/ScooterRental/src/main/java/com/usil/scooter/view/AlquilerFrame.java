package com.usil.scooter.view;

import com.usil.scooter.controller.AlquilerController;
import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Scooter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** Vista de Alquileres. Solo conoce a su controller. Se edita en la pestana Design de NetBeans. */
public class AlquilerFrame extends javax.swing.JFrame {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM HH:mm");
    private static final DateTimeFormatter FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final AlquilerController controlador;
    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Scooter", "Cliente", "Inicio", "Fin", "Minutos", "Monto", "Pagado"}, 0);

    public AlquilerFrame(AlquilerController controlador) {
        this.controlador = controlador;
        initComponents();
        tblAlquileres.setModel(modelo);
        // al elegir una fila, sus datos pasan a los campos para poder actualizar
        tblAlquileres.getSelectionModel().addListSelectionListener(e -> {
            int fila = tblAlquileres.getSelectedRow();
            if (!e.getValueIsAdjusting() && fila >= 0) {
                txtCliente.setText(String.valueOf(tblAlquileres.getValueAt(fila, 2)));
                txtMinutos.setText(String.valueOf(tblAlquileres.getValueAt(fila, 5)));
            }
        });
        // los datos son compartidos con la otra vista: al volver a esta ventana se recargan
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                cargar();
            }
        });
        setSize(900, 440);
        setLocationRelativeTo(null);
        refrescar();
    }

    /** Recarga el combo de scooters y la tabla. */
    private void cargar() {
        cmbScooter.removeAllItems();
        controlador.listarScooters().forEach(cmbScooter::addItem);
        mostrar(controlador.listar());
    }

    private void refrescar() {
        txtCliente.setText("");
        txtMinutos.setText("");
        cargar();
    }

    private void mostrar(List<Alquiler> alquileres) {
        modelo.setRowCount(0);
        alquileres.forEach(a -> modelo.addRow(new Object[]{a.getId(), a.getScooter(), a.getCliente(),
            a.getInicio().format(FORMATO), a.getFin().format(FORMATO), a.getMinutos(),
            String.format("%.2f", a.getMonto()), a.isPagado() ? "Si" : "No"}));
    }

    /** Ejecuta la accion y, si el controller rechaza los datos, muestra el aviso. */
    private void ejecutar(Runnable accion) {
        try {
            accion.run();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Escriba solo numeros en los campos numericos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Escriba la fecha como dd/MM/yyyy (ej. 08/10/2026).", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Devuelve el ID de la fila elegida; si no hay fila elegida lanza un aviso. */
    private int idSeleccionado() {
        int fila = tblAlquileres.getSelectedRow();
        if (fila < 0) {
            throw new IllegalArgumentException("Seleccione una fila de la tabla.");
        }
        return (Integer) tblAlquileres.getValueAt(fila, 0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        lblScooter = new javax.swing.JLabel();
        cmbScooter = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblMinutos = new javax.swing.JLabel();
        txtMinutos = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        scrollAlquileres = new javax.swing.JScrollPane();
        tblAlquileres = new javax.swing.JTable();
        pnlBuscar = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblDesde = new javax.swing.JLabel();
        txtDesde = new javax.swing.JTextField();
        lblHasta = new javax.swing.JLabel();
        txtHasta = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alquileres");

        pnlDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        lblScooter.setText("Scooter:");


        lblCliente.setText("Cliente:");

        txtCliente.setColumns(10);

        lblMinutos.setText("Minutos:");

        txtMinutos.setColumns(4);

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

        pnlDatos.add(lblScooter);
        pnlDatos.add(cmbScooter);
        pnlDatos.add(lblCliente);
        pnlDatos.add(txtCliente);
        pnlDatos.add(lblMinutos);
        pnlDatos.add(txtMinutos);
        pnlDatos.add(btnRegistrar);
        pnlDatos.add(btnActualizar);
        pnlDatos.add(btnEliminar);


        scrollAlquileres.setViewportView(tblAlquileres);

        pnlBuscar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        lblId.setText("Buscar ID:");

        txtId.setColumns(4);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblDesde.setText("Desde (dd/MM/yyyy):");

        txtDesde.setColumns(8);

        lblHasta.setText("Hasta:");

        txtHasta.setColumns(8);

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
        pnlBuscar.add(lblDesde);
        pnlBuscar.add(txtDesde);
        pnlBuscar.add(lblHasta);
        pnlBuscar.add(txtHasta);
        pnlBuscar.add(btnFiltrar);
        pnlBuscar.add(btnListar);

        getContentPane().add(pnlDatos, java.awt.BorderLayout.NORTH);
        getContentPane().add(scrollAlquileres, java.awt.BorderLayout.CENTER);
        getContentPane().add(pnlBuscar, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        ejecutar(() -> {
            controlador.registrar((Scooter) cmbScooter.getSelectedItem(), txtCliente.getText(), Long.parseLong(txtMinutos.getText().trim()));
            refrescar();
        });
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ejecutar(() -> {
            controlador.actualizar(idSeleccionado(), txtCliente.getText(), Long.parseLong(txtMinutos.getText().trim()));
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
        ejecutar(() -> mostrar(controlador.filtrar(LocalDate.parse(txtDesde.getText().trim(), FECHA),
                LocalDate.parse(txtHasta.getText().trim(), FECHA))));
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        txtId.setText("");
        txtDesde.setText("");
        txtHasta.setText("");
        refrescar();
    }//GEN-LAST:event_btnListarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<com.usil.scooter.model.Scooter> cmbScooter;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMinutos;
    private javax.swing.JLabel lblScooter;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JScrollPane scrollAlquileres;
    private javax.swing.JTable tblAlquileres;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMinutos;
    // End of variables declaration//GEN-END:variables
}
