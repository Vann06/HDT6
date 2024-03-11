package org.example;

import java.util.Set;

public interface MyMap<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean containsKey(K key);
    int size();
    boolean isEmpty();
    Set<K> keySet();
    Set<Entry<K, V>> entrySet(); // Asegúrate de que este método esté definido correctamente.

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }
}
