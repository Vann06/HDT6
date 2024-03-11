package org.example;

public class MapaFactory {

    public MyMap<String, Carta> crearMapa(String tipo) {

        if (tipo == null){
            return null;
        }

        if (tipo.equalsIgnoreCase("HashMap")){
            return new HashMap();
        }
        else if (tipo.equalsIgnoreCase("LinkedHashMap")){
            return new LinkedHashMap();
        }
        if (tipo.equalsIgnoreCase("TreeMap")){
            return new TreeMap();
        }
        return null;

    }
}



