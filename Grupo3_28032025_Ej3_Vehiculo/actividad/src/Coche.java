public class Coche extends Vehiculo {
    private int cantidadPuertas;

    public Coche(String marca, double velocidad, int cantidadPuertas) {
        super(marca, velocidad);
        this.cantidadPuertas = cantidadPuertas;
    }

    // Método original
    @Override
    public String desplazar() {
        return "Coche desplazándose en modo normal";
    }

    // Sobrecarga: modo automático o normal
    public String desplazar(String modo) {
        if ("automático".equalsIgnoreCase(modo)) {
            return "Coche desplazándose en modo automático";
        } else {
            return "Coche desplazándose en modo normal";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Puertas: " + cantidadPuertas;
    }
}
