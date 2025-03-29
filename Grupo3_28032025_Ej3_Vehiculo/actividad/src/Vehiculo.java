public class Vehiculo {
    protected String marca;
    protected double velocidad;

    public Vehiculo(String marca, double velocidad) {
        this.marca = marca;
        this.velocidad = velocidad;
    }

    public String desplazar() {
        return "Vehículo desplazándose";
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Velocidad: " + velocidad + " km/h";
    }
}
