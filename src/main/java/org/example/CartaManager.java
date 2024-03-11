package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CartaManager {
    private MyMap<String, Carta> cartasDisponibles;
    private MyMap<String, Integer> coleccionUsuario;

    public CartaManager(MyMap<String, Carta> mapaDisponibles) {
        this.cartasDisponibles = mapaDisponibles;
        this.coleccionUsuario = new LinkedHashMap<>(); // O cualquier implementación preferida
        cargarCartas("cards_desc.txt");
    }

    private void cargarCartas(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 2) {
                    Carta carta = new Carta(partes[0].trim(), partes[1].trim());
                    cartasDisponibles.put(carta.getNombre(), carta);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de cartas: " + e.getMessage());
        }
    }

    public void agregarCartaAColeccion(String nombreCarta) {
        // Primero, verifica si la carta existe en las cartas disponibles
        if (cartasDisponibles.containsKey(nombreCarta)) {
            // Si la carta está disponible, procede a agregarla o actualizar su cantidad en la colección del usuario
            Integer cantidadActual = coleccionUsuario.get(nombreCarta);
            if (cantidadActual == null) {
                // Si la carta no está actualmente en la colección, agrégala con una cantidad de 1
                coleccionUsuario.put(nombreCarta, 1);
                System.out.println("Carta '" + nombreCarta + "' agregada a tu colección con una cantidad de 1.");
            } else {
                // Si la carta ya está en la colección, incrementa su cantidad
                coleccionUsuario.put(nombreCarta, cantidadActual + 1);
                System.out.println("Cantidad de '" + nombreCarta + "' incrementada a " + (cantidadActual + 1) + ".");
            }
        } else {
            // Si la carta no existe en las cartas disponibles, informa al usuario
            System.out.println("La carta '" + nombreCarta + "' no existe en las cartas disponibles y no se puede agregar a la colección.");
        }
    }

    public void mostrarTipoCarta(String nombreCarta) {
        if (cartasDisponibles.containsKey(nombreCarta)) {
            System.out.println("Tipo de '" + nombreCarta + "': " + cartasDisponibles.get(nombreCarta).getTipo());
        } else {
            System.out.println("La carta '" + nombreCarta + "' no existe en las cartas disponibles.");
        }
    }

    public void mostrarColeccion() {
        if (coleccionUsuario.isEmpty()) {
            System.out.println("La colección está vacía.");
            return;
        }

        System.out.println("Colección del usuario:");
        for (String nombreCarta : coleccionUsuario.keySet()) {
            Carta carta = cartasDisponibles.get(nombreCarta);
            if (carta != null) {
                int cantidad = coleccionUsuario.get(nombreCarta);
                System.out.println("Nombre: " + carta.getNombre() + ", Tipo: " + carta.getTipo() + ", Cantidad: " + cantidad);
            } else {
                System.out.println("La carta con nombre '" + nombreCarta + "' no se encuentra en las cartas disponibles.");
            }
        }
    }

    // Implementa los métodos para mostrar las cartas en la colección del usuario,
    // así como cualquier otra funcionalidad requerida por tu asignación.
}
