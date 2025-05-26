package gui;

import javax.swing.*;
import java.awt.*;
import model.Biblioteca;
import model.Usuario;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {
    private Biblioteca biblioteca;
    private Usuario usuarioActual;
    public VentanaPrincipal(Biblioteca biblioteca, Usuario usuarioActual) {
        this.biblioteca = biblioteca;
        this.usuarioActual = usuarioActual;
        setTitle("Gestión de Biblioteca - " + usuarioActual.getNombre());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelBotones.setLayout(new GridLayout(7, 1, 10, 10));
        String[] opciones = {
            "Buscar libro",
            "Nuevo préstamo",
            "Devolver libro",
            "Administración de libros",
            "Administración de usuarios",
            "Historial de préstamos",
            "Salir"
        };

        for (String opcion : opciones) {
            JButton boton = new JButton(opcion);
            if ((opcion.equals("Administración de libros") || opcion.equals("Administración de usuarios"))
                && usuarioActual.getTipo() != Usuario.TipoUsuario.Bibliotecario) {
                boton.setEnabled(false);
            }
            boton.addActionListener(e -> {
                switch (opcion) {
                    case "Buscar libro":
                        new BuscarLibroVentana(biblioteca).setVisible(true);
                        break;
                    case "Nuevo préstamo":
                        new PrestarLibroVentana(biblioteca).setVisible(true);
                        break;
                    case "Devolver libro":
                        new DevolverLibroVentana(biblioteca, usuarioActual).setVisible(true);
                        break;
                    case "Administración de libros":
                        new AdminLibrosVentana(biblioteca).setVisible(true);
                        break;
                    case "Administración de usuarios":
                        new AdminUsuariosVentana(biblioteca).setVisible(true);
                        break;
                    case "Historial de préstamos":
                        new HistorialPrestamosVentana(biblioteca, usuarioActual).setVisible(true);
                        break;
                    case "Salir":
                        dispose();
                        break;
                }
            });
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);
    }
} 