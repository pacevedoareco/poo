package gui;

import model.Biblioteca;
import model.Prestamo;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class HistorialPrestamosVentana extends JFrame {
    private Biblioteca biblioteca;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JTextField campoLibro;
    private JTextField campoUsuario;
    private JTextField campoFechaDesde;
    private JTextField campoFechaHasta;
    private Usuario usuarioActual;

    public HistorialPrestamosVentana(Biblioteca biblioteca, Usuario usuarioActual) {
        this.biblioteca = biblioteca;
        this.usuarioActual = usuarioActual;
        setTitle("Historial de Préstamos");
        setSize(900, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel panelBusqueda = new JPanel(new FlowLayout());
        panelBusqueda.add(new JLabel("Libro:"));
        campoLibro = new JTextField(10);
        panelBusqueda.add(campoLibro);
        panelBusqueda.add(new JLabel("Usuario:"));
        campoUsuario = new JTextField(10);
        panelBusqueda.add(campoUsuario);
        panelBusqueda.add(new JLabel("Desde (dd/MM/yyyy):"));
        campoFechaDesde = new JTextField(8);
        panelBusqueda.add(campoFechaDesde);
        panelBusqueda.add(new JLabel("Hasta (dd/MM/yyyy):"));
        campoFechaHasta = new JTextField(8);
        panelBusqueda.add(campoFechaHasta);
        JButton botonBuscar = new JButton("Buscar");
        panelBusqueda.add(botonBuscar);
        JButton botonVerTodos = new JButton("Ver todos");
        panelBusqueda.add(botonVerTodos);

        String[] columnas = {"ID", "Libro", "Usuario", "Fecha Préstamo", "Fecha Devolución"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(0).setMaxWidth(60);
        JScrollPane scroll = new JScrollPane(tabla);

        mainPanel.add(panelBusqueda, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
        setContentPane(mainPanel);

        botonBuscar.addActionListener(e -> buscarYActualizarTabla());
        botonVerTodos.addActionListener(e -> mostrarTodosLosPrestamos());

        mostrarTodosLosPrestamos();
    }

    private void buscarYActualizarTabla() {
        String libroFiltro = campoLibro.getText().trim().toLowerCase();
        String usuarioFiltro = campoUsuario.getText().trim().toLowerCase();
        String desde = campoFechaDesde.getText().trim();
        String hasta = campoFechaHasta.getText().trim();
        java.util.List<Prestamo> prestamos = biblioteca.getPrestamos().stream().filter(p -> {
            boolean coincide = true;
            if (!libroFiltro.isEmpty() && !p.getLibro().getTitulo().toLowerCase().contains(libroFiltro)) coincide = false;
            if (!usuarioFiltro.isEmpty() && !p.getUsuario().getNombre().toLowerCase().contains(usuarioFiltro)) coincide = false;
            if (!desde.isEmpty()) {
                try {
                    java.util.Date fechaDesde = model.Prestamo.FORMATO_FECHA.parse(desde);
                    if (p.getFechaPrestamo() == null || p.getFechaPrestamo().before(fechaDesde)) coincide = false;
                } catch (Exception ex) { coincide = false; }
            }
            if (!hasta.isEmpty()) {
                try {
                    java.util.Date fechaHasta = model.Prestamo.FORMATO_FECHA.parse(hasta);
                    if (p.getFechaPrestamo() == null || p.getFechaPrestamo().after(fechaHasta)) coincide = false;
                } catch (Exception ex) { coincide = false; }
            }
            return coincide;
        }).collect(java.util.stream.Collectors.toList());
        // Filtrar por usuario si no es bibliotecario
        if (usuarioActual.getTipo() != Usuario.TipoUsuario.Bibliotecario) {
            prestamos = prestamos.stream()
                .filter(p -> p.getUsuario().getId() == usuarioActual.getId())
                .collect(java.util.stream.Collectors.toList());
        }
        actualizarTabla(prestamos);
    }

    private void mostrarTodosLosPrestamos() {
        campoLibro.setText("");
        campoUsuario.setText("");
        campoFechaDesde.setText("");
        campoFechaHasta.setText("");
        if (usuarioActual.getTipo() == Usuario.TipoUsuario.Bibliotecario) {
            actualizarTabla(biblioteca.getPrestamos());
        } else {
            actualizarTabla(biblioteca.getPrestamos().stream()
                .filter(p -> p.getUsuario().getId() == usuarioActual.getId())
                .collect(java.util.stream.Collectors.toList()));
        }
    }

    private void actualizarTabla(List<Prestamo> prestamos) {
        modeloTabla.setRowCount(0);
        for (Prestamo p : prestamos) {
            modeloTabla.addRow(new Object[]{
                    p.getId(),
                    p.getLibro().getTitulo(),
                    p.getUsuario().getNombre(),
                    p.getFechaPrestamoFormateada(),
                    p.getFechaDevolucionFormateada()
            });
        }
    }
} 