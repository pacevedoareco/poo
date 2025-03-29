public class Moto extends Vehiculo {
    private boolean tieneParabrisas;

    public Moto(String marca, double velocidad, boolean tieneParabrisas) {
        super(marca, velocidad);
        this.tieneParabrisas = tieneParabrisas;
    }

    @Override
    public String desplazar() {
        return "Moto desplazándose a gran velocidad";
    }

    @Override
    public String toString() {
        return super.toString() + ", Parabrisas: " + (tieneParabrisas ? "Sí" : "No");
    }
}
