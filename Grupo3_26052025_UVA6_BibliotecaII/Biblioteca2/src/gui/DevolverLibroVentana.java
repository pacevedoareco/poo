package gui;

import model.Biblioteca;
import model.Prestamo;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class DevolverLibroVentana extends JFrame {
    private JComboBox<Prestamo> comboPrestamos;
    private Biblioteca biblioteca;
    private Usuario usuarioActual;

    public DevolverLibroVentana(Biblioteca biblioteca, Usuario usuarioActual) {
        this.biblioteca = biblioteca;
        this.usuarioActual = usuarioActual;
        setTitle("Devolver Libro");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.add(new JLabel("Préstamo activo:"));
        comboPrestamos = new JComboBox<>();
        for (Prestamo p : biblioteca.getPrestamos()) {
            if (p.getFechaDevolucion() == null && 
                (usuarioActual.getTipo() == Usuario.TipoUsuario.Bibliotecario || p.getUsuario().getId() == usuarioActual.getId())) {
                comboPrestamos.addItem(p);
            }
        }
        mainPanel.add(comboPrestamos);
        mainPanel.add(new JLabel());
        JButton botonDevolver = new JButton("Devolver");
        mainPanel.add(botonDevolver);
        setContentPane(mainPanel);

        botonDevolver.addActionListener(e -> realizarDevolucion());
    }

    private void realizarDevolucion() {
        Prestamo prestamo = (Prestamo) comboPrestamos.getSelectedItem();
        if (prestamo == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un préstamo activo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean exito = biblioteca.devolverLibro(prestamo.getId());
        if (exito) {
            JOptionPane.showMessageDialog(this, "Libro devuelto con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo devolver el libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} 