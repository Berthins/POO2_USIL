package com.usil.vista;

import com.usil.controlador.EstudianteController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaEstudiantes extends javax.swing.JFrame {

    private final EstudianteController controlador;

    public VentanaEstudiantes(EstudianteController controlador) {
        this.controlador = controlador;
        initComponents();
        setLocationRelativeTo(null);

        btnRegistrar.addActionListener(e -> registrar());
        btnListar.addActionListener(e -> mostrarLista());
        btnBuscar.addActionListener(e -> buscar());
        btnResumen.addActionListener(e -> mostrarResumen());
    }

    private void registrar() {
        try {
            controlador.registrarEstudiante(txtCodigo.getText(), txtNombres.getText(),
                txtNota1.getText(), txtNota2.getText(), txtNota3.getText());
            limpiarCampos();
            mostrarLista();
            mostrarMensaje("Estudiante registrado correctamente.");
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void mostrarLista() {
        List<String[]> filas = controlador.listarEstudiantes();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        filas.forEach(modelo::addRow);
    }

    private void buscar() {
        controlador.buscarEstudiante(txtCodigo.getText()).ifPresentOrElse(
            areaDetalle::setText,
            () -> mostrarError("No existe un estudiante con ese código."));
    }

    private void mostrarResumen() {
        areaDetalle.setText(controlador.obtenerResumen());
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblNota1 = new javax.swing.JLabel();
        txtNota1 = new javax.swing.JTextField();
        lblNota2 = new javax.swing.JLabel();
        txtNota2 = new javax.swing.JTextField();
        lblNota3 = new javax.swing.JLabel();
        txtNota3 = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnResumen = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        scrollDetalle = new javax.swing.JScrollPane();
        areaDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Academia Saber - Registro de notas");

        panelNorte.setLayout(new java.awt.BorderLayout());

        panelFormulario.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        lblCodigo.setText("Código (6 dígitos):");
        panelFormulario.add(lblCodigo);
        panelFormulario.add(txtCodigo);

        lblNombres.setText("Nombres:");
        panelFormulario.add(lblNombres);
        panelFormulario.add(txtNombres);

        lblNota1.setText("Nota 1:");
        panelFormulario.add(lblNota1);
        panelFormulario.add(txtNota1);

        lblNota2.setText("Nota 2:");
        panelFormulario.add(lblNota2);
        panelFormulario.add(txtNota2);

        lblNota3.setText("Nota 3:");
        panelFormulario.add(lblNota3);
        panelFormulario.add(txtNota3);

        panelNorte.add(panelFormulario, java.awt.BorderLayout.CENTER);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        panelBotones.add(btnRegistrar);

        btnListar.setText("Ver lista");
        panelBotones.add(btnListar);

        btnBuscar.setText("Buscar por código");
        panelBotones.add(btnBuscar);

        btnResumen.setText("Ver resumen");
        panelBotones.add(btnResumen);

        panelNorte.add(panelBotones, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelNorte, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombres", "Promedio", "Condición"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTabla.setViewportView(tabla);

        getContentPane().add(scrollTabla, java.awt.BorderLayout.CENTER);

        areaDetalle.setEditable(false);
        areaDetalle.setColumns(40);
        areaDetalle.setRows(5);
        scrollDetalle.setViewportView(areaDetalle);

        getContentPane().add(scrollDetalle, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDetalle;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnResumen;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNota1;
    private javax.swing.JLabel lblNota2;
    private javax.swing.JLabel lblNota3;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JScrollPane scrollDetalle;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtNota3;
    // End of variables declaration//GEN-END:variables
}
