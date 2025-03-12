package grupo3.actividades;

public class SistemaDeControlDeVuelo {
    // Atributos
    private String fabricante;
    private int numeroModos;
    private String tipoSistema; // manual o pilotoAutomatico
    private String modoActual;
    
    // Constructor
    public SistemaDeControlDeVuelo(String fabricante, int numeroModos, String tipoSistema) {
        this.fabricante = fabricante;
        this.numeroModos = numeroModos;
        this.tipoSistema = tipoSistema;
        this.modoActual = "Estándar"; // Modo por defecto
    }
    
    // Métodos getter y setter
    public String getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public int getNumeroModos() {
        return numeroModos;
    }
    
    public void setNumeroModos(int numeroModos) {
        this.numeroModos = numeroModos;
    }
    
    public String getTipoSistema() {
        return tipoSistema;
    }
    
    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }
    
    public String getModoActual() {
        return modoActual;
    }
    
    // Comportamiento: cambiar modo
    public void cambiarModo(String nuevoModo) {
        this.modoActual = nuevoModo;
    }
    
    // Método para mostrar información del sistema
    public void mostrarInformacion() {
        System.out.println("Información del Sistema de Control de Vuelo:");
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Número de modos: " + numeroModos);
        System.out.println("Tipo de sistema: " + tipoSistema);
        System.out.println("Modo actual: " + modoActual);
    }
}