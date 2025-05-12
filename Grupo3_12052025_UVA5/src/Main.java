package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Validar edad del usuario");
            System.out.println("2. Leer/Escribir archivos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    validarEdad(scanner);
                    break;
                case 2:
                    manejarArchivos();
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 3);

        scanner.close();
    }

    public static void validarEdad(Scanner scanner) {
        int edad = -1;

        while (true) {
            System.out.print("Ingrese su edad (De 0 hasta 120): ");

            try {
                edad = Integer.parseInt(scanner.nextLine());

                if (edad >= 0 && edad <= 120) {
                    break;
                } else {
                    System.out.println("La edad debe estar entre 0 y 120.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }

        System.out.println("Edad ingresada: " + edad + " años.");
    }

    public static void manejarArchivos() {
        String inputFile = "data.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String linea;
            System.out.println("\nLeyendo desde " + inputFile + " y escribiendo en " + outputFile );

            while ((linea = reader.readLine()) != null) {
                System.out.println("Leído: " + linea);
                String procesado = linea.toUpperCase();
                writer.write(procesado);
                writer.newLine();
            }

            System.out.println("Operación completada.");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado o acceso denegado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
    }

    public static int leerOpcion(Scanner scanner) {
        int opcion;

        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido.");
            opcion = -1;
        }

        return opcion;
    }    
} 