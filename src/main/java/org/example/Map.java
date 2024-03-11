package org.example;

public interface Map <K, V> {
    void put(K key, V value); // Añade un par clave-valor al mapa
    V get(K key); // Obtiene el valor asociado con la clave
    void remove(K key); // Elimina el par clave-valor asociado con la clave
    boolean containsKey(K key); // Verifica si el mapa contiene la clave
    int size(); // Devuelve el número de pares clave-valor en el mapa
    boolean isEmpty(); // Verifica si el mapa está vacío


}
