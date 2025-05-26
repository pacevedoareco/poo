package model;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Prestamo implements Serializable {
    private int id;
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy");

    public Prestamo(int id, Libro libro, Usuario usuario, Date fechaPrestamo) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public String getFechaPrestamoFormateada() {
        return fechaPrestamo != null ? FORMATO_FECHA.format(fechaPrestamo) : "";
    }

    public String getFechaDevolucionFormateada() {
        return fechaDevolucion != null ? FORMATO_FECHA.format(fechaDevolucion) : "";
    }

    @Override
    public String toString() {
        return libro.getTitulo() + " a " + usuario.getNombre() + " (" + getFechaPrestamoFormateada() + (fechaDevolucion != null ? " - Devuelto: " + getFechaDevolucionFormateada() : "") + ")";
    }
} 