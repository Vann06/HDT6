package org.example;

public class LinkedHashMapFactory implements MapaFactory<LinkedHashMap> {

    public LinkedHashMap crearMapa(){
        return new LinkedHashMap();
    }

}
