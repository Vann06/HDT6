package org.example;

import java.util.Map;
import java.util.Set;

public class LinkedHashMap<K, V> implements MyMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry<K, V> before, after; // Para mantener el orden de inserción

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] table;
    private final int capacity = 16; // Tamaño fijo para simplificar
    private Entry<K, V> head, tail; // Mantener el orden de inserción

    public LinkedHashMap() {
        table = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        int index = getIndexForKey(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        insertInOrder(newEntry);
    }

    private void insertInOrder(Entry<K, V> newEntry) {
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
        int index = getIndexForKey(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public void remove(K key) {
        // Implementación simplificada de remove
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndexForKey(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }


    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void mostrarCartas() {
        System.out.println("Todas las cartas disponibles:");
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                System.out.println("Nombre: " + current.key + ", Valor: " + current.value);
                current = current.next;
            }
        }

    }
}

