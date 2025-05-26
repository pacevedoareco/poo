package gui;

import model.Biblioteca;
import model.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class AdminLibrosVentana extends JFrame {
    private Biblioteca biblioteca;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public AdminLibrosVentana(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setTitle("Administración de Libros");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Título", "Autor", "Categoría", "Disponible"};
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
        btnEliminar.addActionListener(e -> eliminarLibroSeleccionado());
    }

    private void refrescarTabla() {
        modeloTabla.setRowCount(0);
        for (Libro l : biblioteca.getLibros()) {
            modeloTabla.addRow(new Object[]{
                    l.getId(),
                    l.getTitulo(),
                    l.getAutor(),
                    l.getCategoria(),
                    l.isDisponible() ? "Sí" : "No"
            });
        }
    }

    private void mostrarDialogoAgregar() {
        JTextField campoTitulo = new JTextField(15);
        JTextField campoAutor = new JTextField(15);
        JTextField campoCategoria = new JTextField(15);
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Título:")); panel.add(campoTitulo);
        panel.add(new JLabel("Autor:")); panel.add(campoAutor);
        panel.add(new JLabel("Categoría:")); panel.add(campoCategoria);
        // Poner el foco en el campo de título
        SwingUtilities.invokeLater(campoTitulo::requestFocusInWindow);
        int res = JOptionPane.showConfirmDialog(this, panel, "Agregar Libro", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String titulo = campoTitulo.getText().trim();
            String autor = campoAutor.getText().trim();
            String categoria = campoCategoria.getText().trim();
            if (titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = biblioteca.generarIdLibro();
            Libro libro = new Libro(id, titulo, autor, categoria, true);
            biblioteca.agregarLibro(libro);
            refrescarTabla();
        }
    }

    private void mostrarDialogoEditar() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        Libro libro = biblioteca.buscarLibroPorId(id);
        if (libro == null) return;
        JTextField campoTitulo = new JTextField(libro.getTitulo(), 15);
        JTextField campoAutor = new JTextField(libro.getAutor(), 15);
        JTextField campoCategoria = new JTextField(libro.getCategoria(), 15);
        JCheckBox checkDisponible = new JCheckBox("Disponible", libro.isDisponible());
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Título:")); panel.add(campoTitulo);
        panel.add(new JLabel("Autor:")); panel.add(campoAutor);
        panel.add(new JLabel("Categoría:")); panel.add(campoCategoria);
        panel.add(new JLabel("")); panel.add(checkDisponible);
        int res = JOptionPane.showConfirmDialog(this, panel, "Editar Libro", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String titulo = campoTitulo.getText().trim();
            String autor = campoAutor.getText().trim();
            String categoria = campoCategoria.getText().trim();
            boolean disponible = checkDisponible.isSelected();
            if (titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Libro editado = new Libro(id, titulo, autor, categoria, disponible);
            biblioteca.editarLibro(editado);
            refrescarTabla();
        }
    }

    private void eliminarLibroSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = (int) modeloTabla.getValueAt(fila, 0);
        int res = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el libro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            biblioteca.eliminarLibro(id);
            refrescarTabla();
        }
    }
} 