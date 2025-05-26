package gui;

import model.Biblioteca;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class SeleccionUsuarioVentana extends JDialog {
    private Usuario usuarioSeleccionado;

    public SeleccionUsuarioVentana(JFrame parent, Biblioteca biblioteca) {
        super(parent, "Gestión de biblioteca - Iniciar sesión", true);
        setSize(450, 250);
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
        panel.add(new JLabel("Para comenzar, seleccione su usuario:"));
        JComboBox<Usuario> comboUsuarios = new JComboBox<>();
        for (Usuario u : biblioteca.getUsuarios()) {
            comboUsuarios.addItem(u);
        }
        panel.add(comboUsuarios);

        JButton btnIngresar = new JButton("Ingresar");
        panel.add(btnIngresar);

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