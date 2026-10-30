package com.usil.scooter.view;

import com.usil.scooter.controller.PagoController;
import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Pago;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** Vista de Pagos: aqui se paga un alquiler y se consultan los pagos. Se edita en la pestana Design de NetBeans. */
public class PagoFrame extends javax.swing.JFrame {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM HH:mm");
    private static final DateTimeFormatter FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final PagoController controlador;
    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Alquiler", "Cliente", "Monto", "Fecha", "Tarjeta"}, 0);

    public PagoFrame(PagoController controlador) {
        this.controlador = controlador;
        initComponents();
        tblPagos.setModel(modelo);
        // los datos son compartidos con las otras vistas: al volver a esta ventana se recargan
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                cargar();
            }
        });
        setSize(860, 420);
        setLocationRelativeTo(null);
        refrescar();
    }

    /** Recarga el combo de alquileres pendientes y la tabla de pagos. */
    private void cargar() {
        cmbAlquiler.removeAllItems();
        controlador.alquileresPendientes().forEach(cmbAlquiler::addItem);
        mostrar(controlador.listar());
    }

    private void refrescar() {
        txtTarjeta.setText("");
        cargar();
    }

    private void mostrar(List<Pago> pagos) {
        modelo.setRowCount(0);
        pagos.forEach(p -> modelo.addRow(new Object[]{p.getId(), p.getAlquiler().getId(), p.getAlquiler().getCliente(),
            String.format("%.2f", p.getMonto()), p.getFecha().format(FORMATO), p.getTarjeta()}));
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        lblAlquiler = new javax.swing.JLabel();
        cmbAlquiler = new javax.swing.JComboBox<>();
        lblTarjeta = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        scrollPagos = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
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
        setTitle("Pagos");

        pnlDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        lblAlquiler.setText("Alquiler pendiente:");


        lblTarjeta.setText("Tarjeta (16 digitos):");

        txtTarjeta.setColumns(14);

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        pnlDatos.add(lblAlquiler);
        pnlDatos.add(cmbAlquiler);
        pnlDatos.add(lblTarjeta);
        pnlDatos.add(txtTarjeta);
        pnlDatos.add(btnPagar);


        scrollPagos.setViewportView(tblPagos);

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
        getContentPane().add(scrollPagos, java.awt.BorderLayout.CENTER);
        getContentPane().add(pnlBuscar, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        ejecutar(() -> {
            Alquiler alquiler = (Alquiler) cmbAlquiler.getSelectedItem();
            if (alquiler == null) {
                throw new IllegalArgumentException("No hay alquileres pendientes de pago.");
            }
            controlador.pagar(alquiler.getId(), txtTarjeta.getText());
            refrescar();
            JOptionPane.showMessageDialog(this, "Pago aprobado.");
        });
    }//GEN-LAST:event_btnPagarActionPerformed

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<com.usil.scooter.model.Alquiler> cmbAlquiler;
    private javax.swing.JLabel lblAlquiler;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTarjeta;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JScrollPane scrollPagos;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
