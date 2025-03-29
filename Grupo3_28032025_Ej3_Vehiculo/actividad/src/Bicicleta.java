public class Bicicleta extends Vehiculo {
    private int cantidadMarchas;

    public Bicicleta(String marca, double velocidad, int cantidadMarchas) {
        super(marca, velocidad);
        this.cantidadMarchas = cantidadMarchas;
    }

    @Override
    public String desplazar() {
        return "Bicicleta pedaleando suavemente";
    }

    @Override
    public String toString() {
        return super.toString() + ", Marchas: " + cantidadMarchas;
    }
}
