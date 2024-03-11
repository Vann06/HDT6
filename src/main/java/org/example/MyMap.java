package org.example;

import java.util.Map;
import java.util.Set;

public interface MyMap<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean containsKey(K key);
    int size();
    boolean isEmpty();
    default V getOrDefault(K key, V defaultValue) {
        V value = get(key);
        return value != null ? value : defaultValue;
    }
    Set<Map.Entry<K, V>> entrySet();
}
