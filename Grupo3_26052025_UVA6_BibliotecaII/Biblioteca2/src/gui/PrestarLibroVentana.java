package gui;

import model.Biblioteca;
import model.Libro;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class PrestarLibroVentana extends JFrame {
    private JComboBox<Usuario> comboUsuarios;
    private JComboBox<Libro> comboLibros;
    private Biblioteca biblioteca;

    public PrestarLibroVentana(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setTitle("Nuevo préstamo");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.add(new JLabel("Usuario:"));
        comboUsuarios = new JComboBox<>();
        for (Usuario u : biblioteca.getUsuarios()) {
            comboUsuarios.addItem(u);
        }
        mainPanel.add(comboUsuarios);

        mainPanel.add(new JLabel("Libro disponible:"));
        comboLibros = new JComboBox<>();
        for (Libro l : biblioteca.getLibros()) {
            if (l.isDisponible()) {
                comboLibros.addItem(l);
            }
        }
        mainPanel.add(comboLibros);

        mainPanel.add(new JLabel());
        JButton botonPrestar = new JButton("Prestar");
        mainPanel.add(botonPrestar);

        botonPrestar.addActionListener(e -> realizarPrestamo());

        setContentPane(mainPanel);
    }

    private void realizarPrestamo() {
        Usuario usuario = (Usuario) comboUsuarios.getSelectedItem();
        Libro libro = (Libro) comboLibros.getSelectedItem();
        if (usuario == null || libro == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario y un libro disponible.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean exito = biblioteca.prestarLibro(libro.getId(), usuario.getId());
        if (exito) {
            JOptionPane.showMessageDialog(this, "Préstamo realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} 