package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements Serializable {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public List<Libro> getLibros() { return libros; }
    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Prestamo> getPrestamos() { return prestamos; }

    // Métodos para manipulación de libros
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarLibro(int id) {
        return libros.removeIf(l -> l.getId() == id);
    }

    public Libro buscarLibroPorId(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public List<Libro> buscarLibros(String titulo, String autor, String categoria) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            boolean coincide = true;
            if (titulo != null && !titulo.isEmpty() && !l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) coincide = false;
            if (autor != null && !autor.isEmpty() && !l.getAutor().toLowerCase().contains(autor.toLowerCase())) coincide = false;
            if (categoria != null && !categoria.isEmpty() && !l.getCategoria().toLowerCase().contains(categoria.toLowerCase())) coincide = false;
            if (coincide) resultado.add(l);
        }
        return resultado;
    }

    public boolean editarLibro(Libro libroEditado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libroEditado.getId()) {
                libros.set(i, libroEditado);
                return true;
            }
        }
        return false;
    }

    public int generarIdLibro() {
        int max = 0;
        for (Libro l : libros) {
            if (l.getId() > max) max = l.getId();
        }
        return max + 1;
    }

    // Métodos para manipulación de usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    public boolean editarUsuario(Usuario usuarioEditado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuarioEditado.getId()) {
                usuarios.set(i, usuarioEditado);
                return true;
            }
        }
        return false;
    }

    public int generarIdUsuario() {
        int max = 0;
        for (Usuario u : usuarios) {
            if (u.getId() > max) max = u.getId();
        }
        return max + 1;
    }

    // Métodos para préstamos
    public boolean prestarLibro(int idLibro, int idUsuario) {
        Libro libro = buscarLibroPorId(idLibro);
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (libro != null && usuario != null && libro.isDisponible()) {
            libro.setDisponible(false);
            Prestamo prestamo = new Prestamo(generarIdPrestamo(), libro, usuario, new java.util.Date());
            prestamos.add(prestamo);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(int idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getId() == idPrestamo && p.getFechaDevolucion() == null) {
                p.setFechaDevolucion(new java.util.Date());
                p.getLibro().setDisponible(true);
                return true;
            }
        }
        return false;
    }

    private int generarIdPrestamo() {
        int max = 0;
        for (Prestamo p : prestamos) {
            if (p.getId() > max) max = p.getId();
        }
        return max + 1;
    }
} 