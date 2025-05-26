package gui;

import model.Biblioteca;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class AdminUsuariosVentana extends JFrame {
    private Biblioteca biblioteca;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public AdminUsuariosVentana(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setTitle("Administración de Usuarios");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Tipo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(panelBotones, BorderLayout.SOUTH);
        setContentPane(mainPanel);

        refrescarTabla();

        btnAgregar.addActionListener(e -> mostrarDialogoAgregar());
        btnEditar.addActionListener(e -> mostrarDialogoEditar());
        btnEliminar.addActionListener(e -> eliminarUsuarioSeleccionado());
    }

    private void refrescarTabla() {
        modeloTabla.setRowCount(0);
        for (Usuario u : biblioteca.getUsuarios()) {
            modeloTabla.addRow(new Object[]{
                    u.getId(),
                    u.getNombre(),
                    u.getTipo().name()
            });
        }
    }

    private void mostrarDialogoAgregar() {
        JTextField campoNombre = new JTextField(15);
        JComboBox<Usuario.TipoUsuario> comboTipo = new JComboBox<>(Usuario.TipoUsuario.values());
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nombre:")); panel.add(campoNombre);
        panel.add(new JLabel("Tipo:")); panel.add(comboTipo);
        int res = JOptionPane.showConfirmDialog(this, panel, "Agregar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText().trim();
            Usuario.TipoUsuario tipo = (Usuario.TipoUsuario) comboTipo.getSelectedItem();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = biblioteca.generarIdUsuario();
            Usuario usuario = new Usuario(id, nombre, tipo);
            biblioteca.agregarUsuario(usuario);
            refrescarTabla();
        }
    }

    private void mostrarDialogoEditar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        Usuario usuario = biblioteca.buscarUsuarioPorId(id);
        if (usuario == null) return;
        JTextField campoNombre = new JTextField(usuario.getNombre(), 15);
        JComboBox<Usuario.TipoUsuario> comboTipo = new JComboBox<>(Usuario.TipoUsuario.values());
        comboTipo.setSelectedItem(usuario.getTipo());
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nombre:")); panel.add(campoNombre);
        panel.add(new JLabel("Tipo:")); panel.add(comboTipo);
        int res = JOptionPane.showConfirmDialog(this, panel, "Editar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText().trim();
            Usuario.TipoUsuario tipo = (Usuario.TipoUsuario) comboTipo.getSelectedItem();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Usuario editado = new Usuario(id, nombre, tipo);
            biblioteca.editarUsuario(editado);
            refrescarTabla();
        }
    }

    private void eliminarUsuarioSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        int res = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            biblioteca.eliminarUsuario(id);
            refrescarTabla();
        }
    }
} 