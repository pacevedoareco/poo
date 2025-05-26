package model;

import java.io.Serializable;

public class Usuario implements Serializable {
    public enum TipoUsuario { Usuario, Bibliotecario }

    private int id;
    private String nombre;
    private TipoUsuario tipo;

    public Usuario(int id, String nombre, TipoUsuario tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }
} 