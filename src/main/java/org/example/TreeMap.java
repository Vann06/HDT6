package org.example;
/*
Facultad de Ingenieria
Departamento de Ciencias de la Computacion
Algoritmos y Estructura de Datos

Ricardo Godinez - 23247
Vianka Castro - 23201

TreeMap
 */



import java.util.HashSet;
import java.util.Set;

public class TreeMap<K extends Comparable<K>, V> implements MyMap<K, V> {
    private class Node implements MyMap.Entry<K, V> {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
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

    private Node root;
    private int size = 0;

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void remove(K key) {
        //xd
    }

    private Node get(Node node, K key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
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
        Set<K> keys = new HashSet<>();
        keySet(root, keys);
        return keys;
    }

    private void keySet(Node node, Set<K> set) {
        if (node == null) return;
        keySet(node.left, set);
        set.add(node.key);
        keySet(node.right, set);
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> entries = new HashSet<>();
        entrySet(root, entries);
        return entries;
    }

    private void entrySet(Node node, Set<MyMap.Entry<K, V>> entries) {
        if (node == null) return;
        entrySet(node.left, entries);
        entries.add(node);
        entrySet(node.right, entries);
    }
}

