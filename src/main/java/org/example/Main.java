package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué tipo de mapa desea crear?");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Ingrese el número de su elección: ");

        int eleccion = scanner.nextInt();

        Mapa mapa = null;

        switch(eleccion){
            case 1:
                MapaFactory<HashMap> factoryHash = new HashMapFactory();
                //mapa = factoryHash.crearMapa();
                break;
            case 2:
                MapaFactory<TreeMap> factoryTree = new TreeMapFactory();
                //mapa = factoryTree.crearMapa();
        }

    }
}