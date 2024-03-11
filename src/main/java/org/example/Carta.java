package org.example;
/*
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Algoritmos y Estructura de Datos
 *
 * Ricardo Godinez - 23247
 * Vianka Castro - 23201
 *
 * La clase Carta representa una carta de un juego.
 * Cada carta tiene un nombre y un tipo asociado.
 */

public class Carta {
    private String nombre;
    private String tipo;

    /**
     * Constructor para crear una nueva carta con un nombre y un tipo.
     *
     * @param nombre El nombre de la carta.
     * @param tipo   El tipo de la carta.
     */
    public Carta(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters
    /**
     * Obtiene el nombre de la carta.
     *
     * @return El nombre de la carta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo de la carta.
     *
     * @return El tipo de la carta.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve una representación en cadena de la carta.
     *
     * @return Una cadena que contiene el nombre y el tipo de la carta.
     */
    @Override
    public String toString() {
        return nombre + " | " + tipo;
    }
}