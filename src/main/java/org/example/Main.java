package org.example;
/*
Facultad de Ingenieria
Departamento de Ciencias de la Computacion
Algoritmos y Estructura de Datos

Ricardo Godinez - 23247
Vianka Castro - 23201

Clase main
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CartaManager manager = null;

        System.out.println("Bienvenido al gestor de cartas.");

        // Selección del tipo de Mapa
        System.out.println("Seleccione el tipo de Mapa (HashMap, TreeMap, LinkedHashMap):");
        String tipoMapa = scanner.nextLine();
        try {
            manager = new CartaManager(new MapaFactory().crearMapa(tipoMapa));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Termina el programa si el tipo de mapa no es válido
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n¿Qué acción desea realizar?");
            System.out.println("1. Agregar carta a la colección");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar todas las cartas en la colección");
            System.out.println("4. Mostrar todas las casrtas en la colección por tipo");
            System.out.println("5. Mostrar todas las cartas disponibles");
            System.out.println("6. Mostrar todas las cartas disponibles por tipo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta que desea agregar: ");
                    String nombreCarta = scanner.nextLine();
                    manager.agregarCartaAColeccion(nombreCarta);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la carta para mostrar su tipo: ");
                    nombreCarta = scanner.nextLine();
                    manager.mostrarTipoCarta(nombreCarta);
                    break;
                case 3:
                    manager.mostrarColeccion();
                    break;
                case 4:
                    manager.mostrarColeccionTipo();
                    break;
                case 5:
                    manager.mostrarCartas();
                    break;
                case 6:
                    manager.mostarCartasTipo();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        System.out.println("Gracias por usar el gestor de cartas.");
    }
}
