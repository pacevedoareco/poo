public class Main {
    public static void main(String[] args) {
        Coche coche = new Coche("Toyota", 120, 4);
        Moto moto = new Moto("Yamaha", 90, true);
        Vehiculo bici = new Bicicleta("Giant", 25, 21);

        System.out.println(coche.desplazar());
        System.out.println(coche.desplazar("automático")); // uso de la sobrecarga
        System.out.println(moto.desplazar());
        System.out.println(bici.desplazar());
    }
}
