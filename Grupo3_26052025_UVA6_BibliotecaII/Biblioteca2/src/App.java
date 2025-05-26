import model.Biblioteca;
import model.Usuario;
import util.PersistenciaDatos;
import gui.VentanaPrincipal;
import gui.SeleccionUsuarioVentana;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Biblioteca tempBiblioteca;
        try {
            tempBiblioteca = PersistenciaDatos.cargarBiblioteca();
            System.out.println("Datos de la biblioteca cargados correctamente.");
        } catch (Exception e) {
            System.out.println("No se pudieron cargar los datos. Se inicia una biblioteca vacía.");
            tempBiblioteca = new Biblioteca();
        }
        final Biblioteca biblioteca = tempBiblioteca;

        final Usuario[] usuarioActual = new Usuario[1];
        SwingUtilities.invokeLater(() -> {
            SeleccionUsuarioVentana seleccion = new SeleccionUsuarioVentana(null, biblioteca);
            seleccion.setVisible(true);
            usuarioActual[0] = seleccion.getUsuarioSeleccionado();
            VentanaPrincipal ventana = new VentanaPrincipal(biblioteca, usuarioActual[0]);
            ventana.setVisible(true);
        });

        // Guardar los datos de la biblioteca al cerrar
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                PersistenciaDatos.guardarBiblioteca(biblioteca);
                System.out.println("Datos de la biblioteca guardados correctamente.");
            } catch (Exception e) {
                System.out.println("Error al guardar los datos de la biblioteca: " + e.getMessage());
            }
        }));
    }
}
