package org.example;
/*
Facultad de Ingenieria
Departamento de Ciencias de la Computacion
Algoritmos y Estructura de Datos

Ricardo Godinez - 23247
Vianka Castro - 23201

Hashmap
 */

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> implements MyMap<K, V> {
    private static class Entry<K, V> implements MyMap.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    private List<Entry<K, V>>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public HashMap() {
        table = (List<Entry<K, V>>[]) new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> prev = null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                if (prev != null) {
                    prev.next = entry.next;
                } else {
                    table[index].remove(entry);
                }
                size--;
                return;
            }
            prev = entry;
        }
    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
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
        Set<K> keys = new HashSet<>();
        for (List<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> entrySet = new HashSet<>();
        for (List<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                entrySet.add(entry);
            }
        }
        return entrySet;
    }
}

