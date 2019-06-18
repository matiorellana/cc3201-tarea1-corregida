# Pokemon TCG: Elementos Básicos.
## Tarea 1.

### Descripcion.

Esta tarea busca simular el juego de cartas tradicional de Pokemon de una forma bastante simple de lo que es el juego original.
Para realizar esto el trabajo se dividio en 3 partes.
En esta parte se implementaron la interacciones basicas entre entrenador y pokemon, las cuales incluye el juego de cartas en la mano, campo, la interaccion entre estas etc.

### Implmentación.

Para implementar esta tares el trabajo se dividio principalmente en 4 grandes clases, las cuales son Entrenador, Energia, Pokemon (agrupado junto con la anterior en una interfaz carta) y Ataque, teniendo estas ultimas dos subclases de cuerdo al tipo de pokemon y/o ataque.
principalmente las clases Pokemon y Ataque, junto con sus subclases realizan las interacciones entre el daño que reciven los pokemon de acuerdo al ataque que se ejecuta, mientras que todo esto se ve reflejado en Entrenador, que realiza las interacciones de los mencionados antes pero como cartas, entre algunas colocar en el campo y/o banca, añadir cartas a la mano etc.
Principalmente se uso double dispatch como patron general de diseño, ya que aun no hemos trabajado con otros como para implementarlos. Ademas se usaron algunas clases de estructura de datos vistos en clases, como Map y ArrayList.

### Correr el programa.

De momento el programa no se puede correr, ya que es la implementacion basica del programa total, por lo tanto tendremos que esperar para especificar esta parte.

### Testing.

Para correr los test basta con correr la carpeta test.

## Actualizacion.

Se implmento codigo que mejora el diseño hecho anteriormente, por lo tanto a partir de ahora se considera este codigo para la tarea 2.

los cambios que se implementaron fueron principalmente la creacion de subclases Energia, correspondiente a cada elemento, cambio en la logica de algunos metodos, principalmente trasladandolos de clase, uso optio del double dispatch entre otros 

## Tarea 2.

Principalmente en esta tarea se trato de modificar lo minimo el codigo de la tarea anterior. como se modifico el codigo casi por complente respecto a lo anterior, se procedio a trabajar en primera instancia en la tarea 1, para luego seguir con laa tarea 2.

### Detalles.

Entre algunos patrones de diseño se utilizo el patron visitor para corregir el juego de la evolucion de pokemon. tambien de dio el primer paso para realizar el patron template en la clase controlador, ya que bastaba con realizar la logica de dicha clase.

Observacion: tambien es posible usar un patron observer para notificar los cambios en clase controlador, pero por tiempo no se immplemento.

Respecto a las modificaciones realizadas al codigo, fueron principalmente cambios en un par de lineas de algunos metodos para adaptar la logica que se implemento de acuerdo a las nuevas caracteristicas pedidas. En ningun caso se modifico el codigo a un nivel extremo.

Siguiendo con lo anteriror, los cambios mas extremos fueron cambiar las clases elementales de los pokemon de clases normales a abstraactas, ya que era necesario para poder implementar el patron visitor de forma eficiente, esto produjo que los test anteriores se actualizaran, pero solo cambiando el objeto creado, ya que los parametro se mantuvieron. Por ejemplo en los test se cambio new PokemonAgua por new PokemonBasicoAgua.

Se dividio todo el proyecto en packages para mantener un mejor orden de las clases.

Respecto a ls nuevas clases y sus test, hubo algunos metodos que no era posible testear de forma eficiente, ya que dicho metodo implementaba una interaccion con un usuario o algunos valores interiores del metodo se obtenian por medio de azar (principalmente lanzamiento de una moneda) es por ello que no se pudo testear todos los metodos nuevos.
