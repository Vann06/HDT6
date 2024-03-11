package org.example;
/*
Facultad de Ingenieria
Departamento de Ciencias de la Computacion
Algoritmos y Estructura de Datos

Ricardo Godinez - 23247
Vianka Castro - 23201

LinkedHashMap
 */

import java.util.HashSet;
import java.util.Set;

public class LinkedHashMap<K, V> implements MyMap<K, V> {
    private static class Entry<K, V> implements MyMap.Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next; // Siguiente entrada en el cubo (para manejar colisiones)
        Entry<K, V> before, after; // Para mantener el orden de inserción

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }

    private Entry<K, V>[] table;
    private final int capacity = 16; // Tamaño fijo para simplificar
    private Entry<K, V> head, tail; // Referencias para mantener el orden de inserción
    private int size = 0;

    @SuppressWarnings("unchecked")
    public LinkedHashMap() {
        table = (Entry<K, V>[]) new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEntry;
        }
        size++;

        if (head == null) {
            head = tail = newEntry;
        } else {
            tail.after = newEntry;
            newEntry.before = tail;
            tail = newEntry;
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                return e.value;
            }
        }
        return null;
    }

    // Implementación simplificada; este método no actualiza el tamaño ni mantiene el orden de inserción
    @Override
    public void remove(K key) {
        // Implementación simplificada; se omite por simplicidad
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Entry<K, V> e = head; e != null; e = e.after) {
            set.add(e.key);
        }
        return set;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> set = new HashSet<>();
        for (Entry<K, V> e = head; e != null; e = e.after) {
            set.add(e);
        }
        return set;
    }
}


