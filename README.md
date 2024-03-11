# Gestor de Cartas

Este programa es un gestor de cartas que permite a los usuarios realizar diversas operaciones con un conjunto de cartas predefinido. El programa lee un archivo que contiene una lista de nombres de cartas junto con su tipo (monstruo, trampa o hechizo), y luego permite al usuario realizar varias operaciones, como agregar cartas, mostrar tipos de cartas y mostrar la colección del usuario.

## Contexto

La elección de la estructura de datos correcta es crucial para el rendimiento y la eficiencia del programa. En este caso, se consideran tres implementaciones de mapas en Java: HashMap, LinkedHashMap y TreeMap, cada una con sus ventajas y desventajas.


### Estructuras de Datos

Este programa utiliza tres implementaciones de la interfaz de mapa en Java: **HashMap**, **LinkedHashMap** y **TreeMap**. Cada una de estas implementaciones tiene sus propias características y consideraciones:

- **HashMap**: Almacena los pares clave/valor en una tabla hash sin ningún orden específico. Ofrece un rendimiento de tiempo constante (O(1)) en operaciones básicas como get y put, pero puede degradarse en el peor de los casos.
- **LinkedHashMap**: Combina las características de un HashMap con una lista vinculada para mantener el orden de inserción. Proporciona un rendimiento similar a un HashMap con la ventaja adicional de mantener el orden de inserción.
- **TreeMap**: Implementado como un árbol Rojo-Negro, garantiza un ordenamiento automático de las claves. Ofrece un rendimiento logarítmico (O(log n)) en operaciones como contains, get o put.

#### Elección de Implementación

Dado que nuestro programa necesita mantener el orden de inserción de las cartas y proporcionar un acceso rápido a través de los nombres de las cartas, **la implementación más adecuada sería un LinkedHashMap**. Esta implementación ofrece un equilibrio entre rendimiento y funcionalidad al proporcionar un acceso rápido a los elementos y mantener el orden de inserción.

##### Complejidad de Tiempo

Para la implementación de **HashMap**, **la complejidad de tiempo para mostrar todas las cartas sería O(n)** en el peor de los casos, donde n es el número total de cartas en el mapa. Esto se debe a la necesidad de acceder a cada elemento en el mapa y luego iterar sobre todos los elementos para mostrar las cartas.

##### UML
<img width="690" alt="Screenshot 2024-03-11 at 4 38 36 PM" src="https://github.com/Vann06/HDT6/assets/127684976/53769a90-371a-405e-8187-b7e1c6149df3">

###### Decisiones Futuras

Es importante tener en cuenta que la elección de la implementación del mapa depende de los requisitos específicos del proyecto y las características del conjunto de datos. Si en el futuro cambian los requisitos o las características de los datos, puede ser necesario reconsiderar la elección de la implementación del mapa.
