package org.example;

public class TreeMapFactory implements MapaFactory<TreeMap> {

    @Override
    public TreeMap crearMapa() {
        return new TreeMap<>();
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public void remove(Object key) {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
