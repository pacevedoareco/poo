package grupo3.actividades;
import java.util.ArrayList;
import java.util.List;

public class Avion {
    // Atributos básicos
    private String marca;
    private String modelo;
    private int numeroAsientos;
    private boolean sistemasEntretenimiento;
    
    // Componentes del avión
    private MotorDeAvion motor;
    private SistemaDeControlDeVuelo sistemaControl;
    private List<Ala> alas;
    
    // Constructor
    public Avion(String marca, String modelo, int numeroAsientos, boolean sistemasEntretenimiento) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroAsientos = numeroAsientos;
        this.sistemasEntretenimiento = sistemasEntretenimiento;
        this.alas = new ArrayList<>();
    }
    
    // Métodos getter y setter
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getNumeroAsientos() {
        return numeroAsientos;
    }
    
    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    
    public boolean hasSistemasEntretenimiento() {
        return sistemasEntretenimiento;
    }
    
    public void setSistemasEntretenimiento(boolean sistemasEntretenimiento) {
        this.sistemasEntretenimiento = sistemasEntretenimiento;
    }
    
    public MotorDeAvion getMotor() {
        return motor;
    }
    
    public void setMotor(MotorDeAvion motor) {
        this.motor = motor;
    }
    
    public SistemaDeControlDeVuelo getSistemaControl() {
        return sistemaControl;
    }
    
    public void setSistemaControl(SistemaDeControlDeVuelo sistemaControl) {
        this.sistemaControl = sistemaControl;
    }
    
    public List<Ala> getAlas() {
        return alas;
    }
    
    // Método para añadir un ala
    public void agregarAla(Ala ala) {
        this.alas.add(ala);
    }
    
    // Método para verificar si el avión está completo
    public boolean estaCompleto() {
        return motor != null && sistemaControl != null && alas.size() >= 2;
    }
    
    // Método para mostrar información del avión
    public void mostrarInformacion() {
        System.out.println("========= INFORMACIÓN DEL AVIÓN =========");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Número de asientos: " + numeroAsientos);
        System.out.println("Sistema de entretenimiento: " + (sistemasEntretenimiento ? "Sí" : "No"));
        System.out.println("Número de alas: " + alas.size());
        System.out.println("Estado de ensamblaje: " + (estaCompleto() ? "Completo" : "Incompleto"));
        
        if (motor != null) {
            System.out.println("\n--- INFORMACIÓN DEL MOTOR ---");
            System.out.println("Marca: " + motor.getMarca());
            System.out.println("Potencia: " + motor.getCaballosFuerza() + " hp");
            System.out.println("Empuje: " + motor.getEmpuje() + " libras");
        } else {
            System.out.println("\nMotor: No instalado");
        }
        
        if (sistemaControl != null) {
            System.out.println("\n--- INFORMACIÓN DEL SISTEMA DE CONTROL ---");
            System.out.println("Fabricante: " + sistemaControl.getFabricante());
            System.out.println("Tipo: " + sistemaControl.getTipoSistema());
            System.out.println("Modo actual: " + sistemaControl.getModoActual());
        } else {
            System.out.println("\nSistema de control: No instalado");
        }
        
        if (!alas.isEmpty()) {
            System.out.println("\n--- INFORMACIÓN DE LAS ALAS ---");
            for (int i = 0; i < alas.size(); i++) {
                Ala ala = alas.get(i);
                System.out.println("Ala " + (i + 1) + ":");
                System.out.println("  Envergadura: " + ala.getEnvergadura() + " metros");
                System.out.println("  Material: " + ala.getTipoMaterial());
            }
        } else {
            System.out.println("\nAlas: No instaladas");
        }
    }
    
    // Método para iniciar el avión
    public void iniciar() {
        if (estaCompleto()) {
            System.out.println("\n========= INICIANDO AVIÓN " + marca + " " + modelo + " =========");
            motor.arrancar();
            sistemaControl.cambiarModo("Despegue");
            System.out.println("Avión listo para despegar!");
        } else {
            System.out.println("\nERROR: El avión no está completo, no se puede iniciar.");
            
            if (motor == null) {
                System.out.println("- Falta instalar el motor");
            }
            
            if (sistemaControl == null) {
                System.out.println("- Falta instalar el sistema de control de vuelo");
            }
            
            if (alas.size() < 2) {
                System.out.println("- Se necesitan al menos 2 alas (actualmente hay " + alas.size() + ")");
            }
        }
    }
}