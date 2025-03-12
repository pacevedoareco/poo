package grupo3.actividades;


public class Ala {
    // Atributos
    private Integer envergadura;  // en metros
    private String color;
    private String tipoMaterial; // aluminio, compuesto, etc.
    
    // Constructor
    public Ala(Integer envergadura, String color, String tipoMaterial) {
        this.envergadura = envergadura;
        this.color = color;
        this.tipoMaterial = tipoMaterial;
    }
    
    // Métodos getter y setter
    public Integer getEnvergadura() {
        return envergadura;
    }
    
    public void setEnvergadura(Integer envergadura) {
        this.envergadura = envergadura;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    
    // Comportamiento flap
    public void flap() {
        // se imprime por pantalla ya que no hay un requerimiento concreto sobre qué hacer con el flap
        System.out.println("El ala está realizando un movimiento de flap");
    }
    
    @Override
    public String toString() {
        // uso esta impresión para mostrar información del ala.
        return "El ala de color "+color+" tiene una envergadura de " + envergadura + " metros y su material principal es " + tipoMaterial +".";
    }
}