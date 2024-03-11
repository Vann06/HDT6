package org.example;

public class LinkedHashMapFactory implements MapaFactory<LinkedHashMap> {

    public LinkedHashMap crearMapa(){
        return new LinkedHashMap();
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
