package gui;

import model.Biblioteca;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;

public class SeleccionUsuarioVentana extends JDialog {
    private Usuario usuarioSeleccionado;

    public SeleccionUsuarioVentana(JFrame parent, Biblioteca biblioteca) {
        super(parent, "Gestión de biblioteca - Iniciar sesión", true);
        setSize(500, 250);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        // Si no hay usuarios, crear el Bibliotecario por defecto
        if (biblioteca.getUsuarios().isEmpty()) {
            Usuario admin = new Usuario(1, "Bibliotecario", Usuario.TipoUsuario.Bibliotecario);
            biblioteca.agregarUsuario(admin);
        }

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel labelBienvenida = new JLabel("Bienvenido al sistema de gestión de la biblioteca.");
        JLabel labelBienvenida2 = new JLabel("Para comenzar, seleccione su usuario.");
        labelBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelBienvenida2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelBienvenida);
        panel.add(Box.createVerticalStrut(15)); 
        panel.add(labelBienvenida2);
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("Usuario:"));
        JComboBox<Usuario> comboUsuarios = new JComboBox<>();
        for (Usuario u : biblioteca.getUsuarios()) {
            comboUsuarios.addItem(u);
        }
        panel.add(comboUsuarios, BorderLayout.CENTER);

        JButton btnIngresar = new JButton("Ingresar");
        panel.add(btnIngresar, BorderLayout.WEST);

        add(panel, BorderLayout.CENTER);

        btnIngresar.addActionListener((ActionEvent e) -> {
            usuarioSeleccionado = (Usuario) comboUsuarios.getSelectedItem();
            dispose();
        });
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }
} 