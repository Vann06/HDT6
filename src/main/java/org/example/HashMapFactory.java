package org.example;

public class HashMapFactory implements MapaFactory<HashMap>{

    public HashMap crearMapa(){
        return new HashMap();
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
