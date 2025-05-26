package util;

import model.Biblioteca;
import java.io.*;

public class PersistenciaDatos {
    private static final String ARCHIVO_BIBLIOTECA = "biblioteca.dat";

    public static void guardarBiblioteca(Biblioteca biblioteca) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_BIBLIOTECA))) {
            oos.writeObject(biblioteca);
        }
    }

    public static Biblioteca cargarBiblioteca() throws IOException, ClassNotFoundException {
        File archivo = new File(ARCHIVO_BIBLIOTECA);
        if (!archivo.exists())
            return new Biblioteca(); // Si no existe, devolver una nueva
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Biblioteca) ois.readObject();
        }
    }
} 