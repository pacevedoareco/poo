package gui;

import model.Biblioteca;
import model.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.border.EmptyBorder;

public class BuscarLibroVentana extends JFrame {
    private JTextField campoTitulo;
    private JTextField campoAutor;
    private JTextField campoCategoria;
    private DefaultTableModel modeloTabla;
    private Biblioteca biblioteca;

    public BuscarLibroVentana(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setTitle("Buscar Libro");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel panelBusqueda = new JPanel(new FlowLayout());
        panelBusqueda.add(new JLabel("Título:"));
        campoTitulo = new JTextField(10);
        panelBusqueda.add(campoTitulo);
        panelBusqueda.add(new JLabel("Autor:"));
        campoAutor = new JTextField(10);
        panelBusqueda.add(campoAutor);
        panelBusqueda.add(new JLabel("Categoría:"));
        campoCategoria = new JTextField(10);
        panelBusqueda.add(campoCategoria);
        JButton botonBuscar = new JButton("Buscar");
        panelBusqueda.add(botonBuscar);
        JButton botonVerTodos = new JButton("Ver todos");
        panelBusqueda.add(botonVerTodos);

        String[] columnas = {"ID", "Título", "Autor", "Categoría", "Disponible"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        mainPanel.add(panelBusqueda, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);

        setContentPane(mainPanel);

        botonBuscar.addActionListener((ActionEvent e) -> buscarYActualizarTabla());
        botonVerTodos.addActionListener((ActionEvent e) -> mostrarTodosLosLibros());

        // Mostrar todos los libros por defecto
        mostrarTodosLosLibros();
    }

    private void buscarYActualizarTabla() {
        String titulo = campoTitulo.getText();
        String autor = campoAutor.getText();
        String categoria = campoCategoria.getText();
        List<Libro> resultados = biblioteca.buscarLibros(titulo, autor, categoria);
        actualizarTabla(resultados);
    }

    private void mostrarTodosLosLibros() {
        campoTitulo.setText("");
        campoAutor.setText("");
        campoCategoria.setText("");
        actualizarTabla(biblioteca.getLibros());
    }

    private void actualizarTabla(List<Libro> libros) {
        modeloTabla.setRowCount(0);
        for (Libro l : libros) {
            modeloTabla.addRow(new Object[]{
                    l.getId(),
                    l.getTitulo(),
                    l.getAutor(),
                    l.getCategoria(),
                    l.isDisponible() ? "Sí" : "No"
            });
        }
    }
} 