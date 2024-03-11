package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> implements MyMap<K, V> {
    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry>[] buckets;
    private static final int SIZE = 16; // Tamaño simple para el ejemplo

    public HashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int index = key.hashCode() % SIZE;
        var bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    @Override
    public V get(K key) {
        int index = key.hashCode() % SIZE;
        var bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = key.hashCode() % SIZE;
        var bucket = buckets[index];
        bucket.removeIf(entry -> entry.key.equals(key));
    }

    @Override
    public boolean containsKey(K key) {
        int index = key.hashCode() % SIZE;
        var bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for (List<Entry> bucket : buckets) {
            size += bucket.size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (List<Entry> bucket : buckets) {
            if (!bucket.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }


}
