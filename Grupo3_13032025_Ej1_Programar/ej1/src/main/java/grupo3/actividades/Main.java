package grupo3.actividades;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1
        System.out.println("\n======= Ejercicio 1 =======\n");
        pruebasAla();

        // Ejercicio 2
        System.out.println("\n======= Ejercicio 2 =======\n");
        pruebasSistemaDeControlDeVuelo();
    
    }

    public static void pruebasAla(){
        // Crear dos objetos de tipo Ala
        Ala alaIzquierda = new Ala(11, "blanco", "Aluminio");
        Ala alaDerecha = new Ala(11, "blanco", "Papel");
        
        // Mostrar información de las alas
        System.out.println("ALA IZQUIERDA: " + alaIzquierda);
        
        System.out.println("\nALA DERECHA: " + alaDerecha);
    
        // Ejecutar el comportamiento flap en ambas alas
        System.out.println("\nEjecutando flap en el ala izquierda:");
        alaIzquierda.flap();
        
        System.out.println("\nEjecutando flap en el ala derecha:");
        alaDerecha.flap();
    }

    public static void pruebasSistemaDeControlDeVuelo(){
        // Crear diferentes tipos de sistemas de control de vuelo
        SistemaDeControlDeVuelo sistemaBoeing = new SistemaDeControlDeVuelo("Boeing", 5, "pilotoAutomatico");
        SistemaDeControlDeVuelo sistemaAirbus = new SistemaDeControlDeVuelo("Airbus", 3, "manual");
        SistemaDeControlDeVuelo sistemaLockheed = new SistemaDeControlDeVuelo("Lockheed Martin", 7, "pilotoAutomatico");
        
        // Mostrar información inicial de los sistemas
        System.out.println("=== SISTEMAS DE CONTROL DE VUELO INICIALIZADOS ===");
        
        System.out.println("\nSISTEMA 1:");
        sistemaBoeing.mostrarInformacion();
        
        System.out.println("\nSISTEMA 2:");
        sistemaAirbus.mostrarInformacion();
        
        System.out.println("\nSISTEMA 3:");
        sistemaLockheed.mostrarInformacion();
        
        // Cambiar modos de cada sistema
        System.out.println("\n=== CAMBIANDO MODOS DE LOS SISTEMAS ===");
        
        System.out.println("\nSistema Boeing:");
        sistemaBoeing.cambiarModo("Crucero");
        
        System.out.println("\nSistema Airbus:");
        sistemaAirbus.cambiarModo("Aproximación");
        
        System.out.println("\nSistema Lockheed Martin:");
        sistemaLockheed.cambiarModo("Altitud constante");
        
        // Mostrar información actualizada después de cambiar los modos
        System.out.println("\n=== INFORMACIÓN ACTUALIZADA DE LOS SISTEMAS ===");
        
        System.out.println("\nSISTEMA 1 (después de cambio):");
        sistemaBoeing.mostrarInformacion();
        
        System.out.println("\nSISTEMA 2 (después de cambio):");
        sistemaAirbus.mostrarInformacion();
        
        System.out.println("\nSISTEMA 3 (después de cambio):");
        sistemaLockheed.mostrarInformacion();
        
        // Ejemplo adicional: cambiar múltiples veces el modo de un sistema
        System.out.println("\n=== SECUENCIA DE CAMBIOS EN SISTEMA BOEING ===");
        sistemaBoeing.cambiarModo("Despegue");
        sistemaBoeing.cambiarModo("Ascenso");
        sistemaBoeing.cambiarModo("Crucero");
        
        System.out.println("\nEstado final del sistema Boeing:");
        sistemaBoeing.mostrarInformacion();
    }

}