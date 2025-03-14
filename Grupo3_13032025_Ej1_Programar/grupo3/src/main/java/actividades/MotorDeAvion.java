package actividades;

 public class MotorDeAvion {
    // Atributos
    private String marca;
    private int caballosFuerza; // hp
    private double empuje;      // en libras
    private boolean encendido;  // estado del motor (encendido/apagado)
    
    // Constructor
    public MotorDeAvion(String marca, int caballosFuerza, double empuje) {
        this.marca = marca;
        this.caballosFuerza = caballosFuerza;
        this.empuje = empuje;
        this.encendido = false; // Por defecto el motor está apagado
    }
    
    // Métodos getter y setter
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public int getCaballosFuerza() {
        return caballosFuerza;
    }
    
    public void setCaballosFuerza(int caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }
    
    public double getEmpuje() {
        return empuje;
    }
    
    public void setEmpuje(double empuje) {
        this.empuje = empuje;
    }
    
    public boolean isEncendido() {
        return encendido;
    }
    
    // Comportamiento: arrancar el motor
    public void arrancar() {
        encendido = true;
    }
    
    // Comportamiento: detener el motor
    public void detener() {
        encendido = false;
    }
    
    // Método para mostrar información del motor
    public void mostrarInformacion() {
        System.out.println("Marca del motor: " + marca);
        System.out.println("Potencia: " + caballosFuerza + " hp");
        System.out.println("Empuje: " + empuje + " libras");
        System.out.println("Estado: " + (encendido ? "Encendido" : "Apagado"));
    }
}