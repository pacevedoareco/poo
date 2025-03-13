package grupo3.actividades;

public class Main {
    public static void main(String[] args) {
        
        // Ejercicio 1
        System.out.println("\n======= Ejercicio 1 =======\n");
        pruebasAla();
        
        // Ejercicio 2
        System.out.println("\n======= Ejercicio 2 =======\n");
        pruebasSistemaDeControlDeVuelo();
        
        // Ejercicio 3
        System.out.println("\n======= Ejercicio 3 =======\n");
        pruebasMotor();
        
        // Ejercicio 4
        System.out.println("\n======= Ejercicio 4 =======\n");
        pruebasAvion();
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
    
    private static void pruebasMotor() {
        
        // Crear diferentes tipos de motores de avión
        MotorDeAvion motorRollsRoyce = new MotorDeAvion("Rolls-Royce Trent 900", 70000, 84000);
        MotorDeAvion motorGE = new MotorDeAvion("General Electric GE90", 115000, 115300);
        MotorDeAvion motorPrattWhitney = new MotorDeAvion("Pratt & Whitney PW4000", 90000, 95000);
        
        // Mostrar información inicial de los motores
        System.out.println("=== MOTORES DE AVIÓN INICIALIZADOS ===");
        
        System.out.println("\nMOTOR 1:");
        motorRollsRoyce.mostrarInformacion();
        
        System.out.println("\nMOTOR 2:");
        motorGE.mostrarInformacion();
        
        System.out.println("\nMOTOR 3:");
        motorPrattWhitney.mostrarInformacion();
        
        // Arrancar los motores
        System.out.println("\n=== ARRANCANDO MOTORES ===");
        motorRollsRoyce.arrancar();
        motorGE.arrancar();
        motorPrattWhitney.arrancar();
        
        // Mostrar el estado actualizado de los motores
        System.out.println("\n=== ESTADO ACTUALIZADO DE LOS MOTORES ===");
        
        System.out.println("\nMOTOR 1 (después de arrancar):");
        motorRollsRoyce.mostrarInformacion();
        
        System.out.println("\nMOTOR 2 (después de arrancar):");
        motorGE.mostrarInformacion();
        
        System.out.println("\nMOTOR 3 (después de arrancar):");
        motorPrattWhitney.mostrarInformacion();
        
        // Detener algunos motores
        System.out.println("\n=== DETENIENDO ALGUNOS MOTORES ===");
        motorRollsRoyce.detener();
        motorPrattWhitney.detener();
        
        // Intentar detener un motor ya detenido
        System.out.println("\n=== INTENTANDO DETENER UN MOTOR YA DETENIDO ===");
        motorRollsRoyce.detener();
        
        // Intentar arrancar un motor ya arrancado
        System.out.println("\n=== INTENTANDO ARRANCAR UN MOTOR YA ARRANCADO ===");
        motorGE.arrancar();
        
        // Mostrar estado final
        System.out.println("\n=== ESTADO FINAL DE LOS MOTORES ===");
        
        System.out.println("\nMOTOR 1:");
        motorRollsRoyce.mostrarInformacion();
        
        System.out.println("\nMOTOR 2:");
        motorGE.mostrarInformacion();
        
        System.out.println("\nMOTOR 3:");
        motorPrattWhitney.mostrarInformacion();
        
    }
    
    private static void pruebasAvion() {
        
        // Crear componentes para aviones
        System.out.println("=== CREANDO COMPONENTES PARA AVIONES ===");
        
        // Motores
        MotorDeAvion motorBoeing = new MotorDeAvion("General Electric GEnx", 75000, 76100);
        MotorDeAvion motorAirbus = new MotorDeAvion("Rolls-Royce Trent XWB", 97000, 97000);
        
        // Sistemas de control
        SistemaDeControlDeVuelo sistemaBoeing = new SistemaDeControlDeVuelo("Honeywell", 6, "pilotoAutomatico");
        SistemaDeControlDeVuelo sistemaAirbus = new SistemaDeControlDeVuelo("Thales", 5, "pilotoAutomatico");
        
        // Alas
        Ala alaBoeingIzquierda = new Ala(35, "blanco", "Compuesto de carbono");
        Ala alaBoeingDerecha = new Ala(35, "blanco", "Compuesto de carbono");
        
        Ala alaAirbusIzquierda = new Ala(33, "blanco", "Fibra de carbono y aluminio");
        Ala alaAirbusDerecha = new Ala(33, "blanco", "Fibra de carbono y aluminio");
        Ala alaAirbusCentral = new Ala(5, "gris", "Aleación de titanio"); // Estabilizador extra
        
        // Crear aviones
        System.out.println("\n=== CREANDO AVIONES ===");
        
        // Avión Boeing 787 Dreamliner
        Avion boeing787 = new Avion("Boeing", "787 Dreamliner", 290, true);
        
        // Avión Airbus A350
        Avion airbusA350 = new Avion("Airbus", "A350 XWB", 325, true);
        
        // Avión incompleto (para demostración)
        Avion avionIncompleto = new Avion("Cessna", "172 Skyhawk", 4, false);
        
        // Mostrar información de los aviones antes del ensamblaje
        System.out.println("\n=== AVIONES ANTES DEL ENSAMBLAJE ===");
        System.out.println("\nAVIÓN 1 - BOEING 787:");
        boeing787.mostrarInformacion();
        
        System.out.println("\nAVIÓN 2 - AIRBUS A350:");
        airbusA350.mostrarInformacion();
        
        System.out.println("\nAVIÓN 3 - CESSNA (INCOMPLETO):");
        avionIncompleto.mostrarInformacion();
        
        // Ensamblar avión Boeing
        System.out.println("\n=== ENSAMBLANDO BOEING 787 ===");
        boeing787.setMotor(motorBoeing);
        boeing787.setSistemaControl(sistemaBoeing);
        boeing787.agregarAla(alaBoeingIzquierda);
        boeing787.agregarAla(alaBoeingDerecha);
        System.out.println("Boeing 787 ensamblado correctamente!");
        
        // Ensamblar avión Airbus
        System.out.println("\n=== ENSAMBLANDO AIRBUS A350 ===");
        airbusA350.setMotor(motorAirbus);
        airbusA350.setSistemaControl(sistemaAirbus);
        airbusA350.agregarAla(alaAirbusIzquierda);
        airbusA350.agregarAla(alaAirbusDerecha);
        airbusA350.agregarAla(alaAirbusCentral);
        System.out.println("Airbus A350 ensamblado correctamente!");
        
        // Ensamblar parcialmente el avión incompleto (para demostración)
        System.out.println("\n=== ENSAMBLANDO PARCIALMENTE CESSNA 172 ===");
        avionIncompleto.agregarAla(new Ala(11, "blanco", "Aluminio"));
        // Intencionalmente no agregamos todas las partes
        
        // Mostrar información de los aviones después del ensamblaje
        System.out.println("\n=== AVIONES DESPUÉS DEL ENSAMBLAJE ===");
        System.out.println("\nAVIÓN 1 - BOEING 787:");
        boeing787.mostrarInformacion();
        
        System.out.println("\nAVIÓN 2 - AIRBUS A350:");
        airbusA350.mostrarInformacion();
        
        System.out.println("\nAVIÓN 3 - CESSNA (INCOMPLETO):");
        avionIncompleto.mostrarInformacion();
        
        // Probar el método iniciar en los aviones
        System.out.println("\n=== PROBANDO LOS AVIONES ===");
        boeing787.iniciar();
        airbusA350.iniciar();
        avionIncompleto.iniciar();
        
        
    }
}