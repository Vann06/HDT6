package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CartaManager {
    private MyMap<String, Carta> cartasDisponibles;
    private MyMap<String, Integer> coleccionUsuario;

    public CartaManager(MyMap<String, Carta> mapaDisponibles) {
        this.cartasDisponibles = mapaDisponibles;
        this.coleccionUsuario = new LinkedHashMap<>(); // O cualquier implementación preferida
        cargarCartas("C:\Users\richi\OneDrive\Documentos\GitHub\HDT6\cards_desc.txt");
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
        if (cartasDisponibles.containsKey(nombreCarta)) {
            coleccionUsuario.put(nombreCarta, coleccionUsuario.getOrDefault(nombreCarta, 0) + 1);
            System.out.println("Carta agregada a tu colección: " + nombreCarta);
        } else {
            System.out.println("La carta '" + nombreCarta + "' no existe en las cartas disponibles.");
        }
    }

    public void mostrarTipoCarta(String nombreCarta) {
        if (cartasDisponibles.containsKey(nombreCarta)) {
            System.out.println("Tipo de '" + nombreCarta + "': " + cartasDisponibles.get(nombreCarta).getTipo());
        } else {
            System.out.println("La carta '" + nombreCarta + "' no existe en las cartas disponibles.");
        }
    }

    // Implementa los métodos para mostrar las cartas en la colección del usuario,
    // así como cualquier otra funcionalidad requerida por tu asignación.
}
