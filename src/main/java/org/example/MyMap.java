package org.example;
/*
Facultad de Ingenieria
Departamento de Ciencias de la Computacion
Algoritmos y Estructura de Datos

Ricardo Godinez - 23247
Vianka Castro - 23201

Interfaz MyMap define las operaciones básicas de un mapa.
 */

import java.util.Set;

public interface MyMap<K, V> {
    /**
     * Agrega una entrada al mapa con la clave especificada y el valor asociado.
     *
     * @param key   Clave con la que se asociará el valor.
     * @param value Valor asociado a la clave.
     */
    void put(K key, V value);

    /**
     * Obtiene el valor asociado a la clave especificada.
     *
     * @param key Clave cuyo valor se desea obtener.
     * @return Valor asociado a la clave, o null si la clave no está presente en el mapa.
     */
    V get(K key);

    /**
     * Elimina la entrada asociada a la clave especificada, si existe.
     *
     * @param key Clave de la entrada que se desea eliminar.
     */
    void remove(K key);

    /**
     * Verifica si el mapa contiene una entrada con la clave especificada.
     *
     * @param key Clave cuya presencia se desea verificar.
     * @return true si el mapa contiene la clave, false de lo contrario.
     */
    boolean containsKey(K key);

    /**
     * Obtiene el número de entradas (pares clave-valor) en el mapa.
     *
     * @return Número de entradas en el mapa.
     */
    int size();

    /**
     * Verifica si el mapa está vacío (sin entradas).
     *
     * @return true si el mapa está vacío, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene un conjunto de todas las claves en el mapa.
     *
     * @return Conjunto de claves presentes en el mapa.
     */
    Set<K> keySet();

    /**
     * Obtiene un conjunto de todas las entradas (pares clave-valor) en el mapa.
     *
     * @return Conjunto de entradas presentes en el mapa.
     */
    Set<Entry<K, V>> entrySet();

    /**
     * Interfaz Entry que define una entrada en el mapa, que consiste en un par clave-valor.
     *
     * @param <K> Tipo de la clave.
     * @param <V> Tipo del valor.
     */
    interface Entry<K, V> {
        /**
         * Obtiene la clave de la entrada.
         *
         * @return Clave de la entrada.
         */
        K getKey();

        /**
         * Obtiene el valor asociado a la clave de la entrada.
         *
         * @return Valor asociado a la clave de la entrada.
         */
        V getValue();
    }
}
