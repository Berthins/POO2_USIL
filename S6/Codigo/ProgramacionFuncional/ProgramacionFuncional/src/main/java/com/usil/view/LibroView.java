package com.usil.view;

import com.usil.controller.LibroController;
import com.usil.model.Genero;
import com.usil.model.Libro;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LibroView extends javax.swing.JFrame {

    private final LibroController controlador;
    private final DefaultTableModel modeloTabla = new DefaultTableModel(
            new Object[]{"Código", "Título", "Autor", "Género", "Precio", "Stock"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public LibroView(LibroController controlador) {
        this.controlador = controlador;
        initComponents();
        cboGenero.setModel(new DefaultComboBoxModel<>(Genero.values()));
        cboFiltroGenero.setModel(new DefaultComboBoxModel<>(Genero.values()));
        tblLibros.setModel(modeloTabla);
        cargarLibros();
    }

    private void cargarLibros() {
        mostrarLibros(controlador.listarLibros());
    }

    private void mostrarLibros(List<Libro> libros) {
        modeloTabla.setRowCount(0);
        libros.forEach(l -> modeloTabla.addRow(new Object[]{
            l.getCodigo(), l.getTitulo(), l.getAutor(), l.getGenero(), l.getPrecio(), l.getStock()
        }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        pnlRegistro = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblVacio = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        cboGenero = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        pnlBusqueda = new javax.swing.JPanel();
        lblFiltroGenero = new javax.swing.JLabel();
        cboFiltroGenero = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        pnlDatos = new javax.swing.JPanel();
        scrollLibros = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        scrollResultado = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        pnlLateral = new javax.swing.JPanel();
        pnlReportes = new javax.swing.JPanel();
        btnReporteGenero = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Librería - Registro, búsqueda y reportes");

        pnlSuperior.setLayout(new java.awt.BorderLayout());

        pnlRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlRegistro.setLayout(new java.awt.GridLayout(2, 7, 8, 4));

        lblCodigo.setText("Código");
        pnlRegistro.add(lblCodigo);

        lblTitulo.setText("Título");
        pnlRegistro.add(lblTitulo);

        lblAutor.setText("Autor");
        pnlRegistro.add(lblAutor);

        lblGenero.setText("Género");
        pnlRegistro.add(lblGenero);

        lblPrecio.setText("Precio");
        pnlRegistro.add(lblPrecio);

        lblStock.setText("Stock");
        pnlRegistro.add(lblStock);
        pnlRegistro.add(lblVacio);

        txtCodigo.setColumns(8);
        pnlRegistro.add(txtCodigo);

        txtTitulo.setColumns(8);
        pnlRegistro.add(txtTitulo);

        txtAutor.setColumns(8);
        pnlRegistro.add(txtAutor);

        pnlRegistro.add(cboGenero);

        txtPrecio.setColumns(8);
        pnlRegistro.add(txtPrecio);

        txtStock.setColumns(8);
        pnlRegistro.add(txtStock);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlRegistro.add(btnRegistrar);

        pnlSuperior.add(pnlRegistro, java.awt.BorderLayout.NORTH);

        pnlBusqueda.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblFiltroGenero.setText("Buscar por género:");
        pnlBusqueda.add(lblFiltroGenero);

        pnlBusqueda.add(cboFiltroGenero);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlBusqueda.add(btnBuscar);

        btnListarTodos.setText("Listar todos");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });
        pnlBusqueda.add(btnListarTodos);

        pnlSuperior.add(pnlBusqueda, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        pnlDatos.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlDatos.setLayout(new java.awt.BorderLayout(0, 8));

        scrollLibros.setViewportView(tblLibros);

        pnlDatos.add(scrollLibros, java.awt.BorderLayout.CENTER);

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setRows(6);
        scrollResultado.setViewportView(txtResultado);

        pnlDatos.add(scrollResultado, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlDatos, java.awt.BorderLayout.CENTER);

        pnlLateral.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlLateral.setLayout(new java.awt.BorderLayout());

        pnlReportes.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        btnReporteGenero.setText("Reporte por género");
        btnReporteGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneroActionPerformed(evt);
            }
        });
        pnlReportes.add(btnReporteGenero);

        btnEstadisticas.setText("Estadísticas de precios");
        btnEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasActionPerformed(evt);
            }
        });
        pnlReportes.add(btnEstadisticas);

        pnlLateral.add(pnlReportes, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlLateral, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String mensaje = controlador.registrarLibro(
                txtCodigo.getText(),
                txtTitulo.getText(),
                txtAutor.getText(),
                (Genero) cboGenero.getSelectedItem(),
                txtPrecio.getText(),
                txtStock.getText());
        JOptionPane.showMessageDialog(this, mensaje);
        cargarLibros();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        List<Libro> encontrados = controlador.buscarPorGenero((Genero) cboFiltroGenero.getSelectedItem());
        mostrarLibros(encontrados);
        txtResultado.setText("Libros encontrados: " + encontrados.size());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
        cargarLibros();
        txtResultado.setText("");
    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnReporteGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneroActionPerformed
        txtResultado.setText(controlador.reportePorGenero());
    }//GEN-LAST:event_btnReporteGeneroActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        txtResultado.setText(controlador.reporteEstadisticas());
    }//GEN-LAST:event_btnEstadisticasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporteGenero;
    private javax.swing.JComboBox<com.usil.model.Genero> cboFiltroGenero;
    private javax.swing.JComboBox<com.usil.model.Genero> cboGenero;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFiltroGenero;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVacio;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JPanel pnlReportes;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane scrollLibros;
    private javax.swing.JScrollPane scrollResultado;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
