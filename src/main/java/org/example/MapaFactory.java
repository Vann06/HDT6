package org.example;
/*
Facultad de Ingenieria
Departamento de Ciencias de la Computacion
Algoritmos y Estructura de Datos

Ricardo Godinez - 23247
Vianka Castro - 23201

Factory de Mapa el cual proporciona métodos para crear
instancias de diferentes implementaciones de MyMap.

 */

public class MapaFactory {
    /**
     * Crea una instancia de la implementación de MyMap especificada por el tipo.
     *
     * @param tipo Tipo de implementación de mapa que se desea crear.
     * @return Instancia de la implementación de MyMap especificada por el tipo, o null si el tipo no es válido.
     */
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



