---
    title: Ejercicios de la UD06
    language: ES
    author: David Martínez Peña [www.martinezpenya.es]
    subject: Programación
    keywords: [PRG, 2021, Programacion, Java]
    IES: IES Mestre Ramón Esteve (Catadau) [iesmre.es]
    header: ${title} - ${subject} (ver: ${today}) 
    footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
    typora-root-url:${filename}/../
    typora-copy-images-to:${filename}/../assets
---
[toc]
# Ejercicios

## Paquete: `UD06._7.gestorVuelos`

Se desea realizar una aplicación `GestorVuelos` para gestionar la reserva y cancelación de vuelos en una agencia de viajes. Dicha agencia trabaja únicamente con la compañía aérea Iberia, que ofrece vuelos desde/hacia varias ciudades de Europa. Se deben definir las clases que siguen, teniendo en cuenta que sus atributos serán privados y sus métodos sólo los que se indican en cada clase.

1. Implementación de la clase **Vuelo**, que permite representar un vuelo mediante los atributos:  

   - `identificador` (`String`)
   - `origen` (`String`)
   - `destino` (`String`)
   - `hSalida` (`Time`)
   - `hLlegada` (`Time`)
   - Además, cada vuelo dispone de 50 asientos, es decir, pueden viajar, como mucho, 50 pasajeros en cada vuelo. Para representarlos, se hará uso de `asiento`, un array de `String` (nombres de los pasajeros) junto con un atributo `numP` que indique el número actual de asientos reservados. Si el asiento `i` está reservado, `asiento[i]` contendrá el nombre del pasajero que lo ha reservado. Si no lo está, `asiento[i]` será `null`. En el array `asiento`, las posiciones impares pertenecen a asientos de ventanilla y las posiciones pares, a asientos de pasillo (la posición 0 no se utilizará).

   En esta clase, se deben implementar los siguientes métodos:

   - `public Vuelo(String id, String orig, String dest, Time hsal, Time hlleg)`. **Constructor** que crea un vuelo con identificador, ciudad de origen, ciudad de destino, hora de salida y hora de llegada indicados en los respectivos parámetros, y sin pasajeros.

   - `public String getIdenificador()`. Devuelve el `identificador`

   - `public String getOrigen()`. Devuelve `origen`.

   - `public String getDestino()`. Devuelve `destino`.

   - `public boolean hayLibres()`. Devuelve `true` si quedan asientos libres y `false` si no quedan.

   - `public boolean equals(Object o)`. Dos vuelos son iguales si tienen el mismo identificador.

   - `public int reservarAsiento(String pas, char pref) throws VueloCompletoException`. Si el vuelo ya está completo se lanza una excepción. Si no está completo, se reserva al pasajero `pas` el primer asiento libre en `pref`. El carácter `pref` será '`P`' o '`V`' en función de que el pasajero desee un asiento de pasillo o de ventanilla. En caso de que no quede ningún asiento libre en la preferencia indicada (`pref`), se reservará el primer asiento libre de la otra preferencia. El método devolverá el número de asiento que se le ha reservado. Este método hace uso del método privado `asientoLibre`, que se explica a continuación.

   - `private int asientoLibre(char pref)`. Dado un tipo de asiento `pref` (pasillo '`P`' o ventanilla '`V`'), devuelve el primer asiento libre (el de menor numero) que encuentre de ese tipo. O devuelve `0` si no quedan asientos libres de tipo `pref`.

   - `public void cancelarReserva(int numasiento)`. Se cancela la reserva del asiento `numasiento`.

   - `public String toString()`. Devuelve una `String` con los datos del vuelo y los nombres de los pasajeros, con el siguiente formato:

     ```
     IB101 Valencia París 19:05:00 21:00:00
     Pasajeros:
     Asiento 1: Sonia Dominguez
     …
     Asiento 23: Fernando Romero
     ```

2. Diseñar e implementar una clase Java `TestVuelo` que permita probar la clase `Vuelo` y sus métodos. Para ello se desarrollará el método `main` en el que:

   - Se cree el vuelo IB101 de Valencia a París, que sale a las 19:05 y llega a las 21:00
   - Reservar:
     - Un asiento de ventanilla a "Miguel Fernández"
     - Un asiento de ventanilla a "Ana Folgado"
     - Un asiento de pasillo a "David Más"
   - Mostrar el vuelo por pantalla
   - Cancelar la reserva del asiento que indique el usuario.

3. Implementación de la clase `Compañía` para representar todos los vuelos de una compañía aérea. Una Compañía tiene un nombre nombre y puede ofrecer, como mucho, 10 vuelos distintos. Para representarlos se utilizará `listaVuelos`, un array de objetos `Vuelo` junto con un atributo `numVuelos` que indique el número de vuelos que la compañía ofrece en un momento dado. Las operaciones de esta clase son:

   - `public Compania(String n) throws FileNotFoundException`. Constructor de una compañía de nombre `n`. Cuando se crea una compañía, se invoca al método privado `leeVuelos()` para cargar la información de vuelos desde un fichero. Si el fichero no existe, se propaga la excepción `FileNotFoundException`

   - `private void leeVuelos() throws FileNotFoundException`. Lee desde un fichero toda la información de los vuelos que ofrece la compañía y los va almacenando en el array de vuelos `listaVuelos`. El nombre del fichero coincide con el nombre de la compañía y tiene extensión `.txt`. La información de cada vuelo se estructura en el fichero como sigue:

     ```
     <Identificador>
     <Origen>
     <Destino>
     <Hora de salida>
     <Minuto de salida>
     <Hora de llegada>
     <Minuto de llegada>
     ...
     ...
     ```

     Si el fichero no existe, se propaga la excepción `FileNotFoundException`.

   - `public Vuelo buscarVuelo(String id) throws ElementoNoEncontradoException`. Dado un identificador de vuelo `id`, busca dicho vuelo en el array de vuelos `listaVuelos`. Si lo encuentra, lo devuelve. Si no, lanza `ElementoNoEncontradoException`.

   - `public void mostrarVuelosIncompletos(String o, String d)`. Muestra por pantalla los vuelos con origen `o` y destino `d`, y que tengan asientos libres. Por ejemplo, vuelos con asientos libres de la compañía Iberia con origen Milán y destino Valencia:

     ```
     Iberia IB201 Milán Valencia 14:25:00 16:20:00
     Iberia IB202 Mílán Valencia 21:40:00 23:35:00
     ```

4. En la clase `GestorVuelos` se probará el comportamiento de las clases anteriores. En esta clase se debe implementar el método `main` en el que, por simplificar, se pide únicamente:

   - la creación de la compañía aérea `Iberia`. Se dispone de un fichero de texto "`Iberia.txt`", con la información de los vuelos que ofrece.
   - Reserva de un asiento de ventanilla en un vuelo de Valencia a París por parte de Manuel Soler Roca. Para ello:
     - Mostraremos vuelos con origen Valencia y destino París, que no estén completos.
     - Pediremos al usuario el identificador del vuelo en que quiere hacer la reserva.
     - Buscaremos el vuelo que tiene el identificador indicado. Si existe realizaremos la reserva y mostraremos un mensaje por pantalla. En caso contrario mostraremos un mensaje de error por pantalla.

## Paquete: `UD06._8.maquinaExpendedora`

Se desea simular el funcionamiento de una máquina expendedora. Se trata de una expendedora sencilla que, por el momento, será capaz de dispensar únicamente un producto.

Su funcionamiento, a grandes rasgos, es el siguiente:

1. El cliente introduce dinero en la máquina. Al dinero introducido lo llamaremos `credito`.
2. Selecciona el artículo que quiere comprar (ya hemos comentado que por el momento habrá un solo artículo).
3. Si hay stock del artículo seleccionado, la máquina dispensa el artículo elegido y devuelve el importe sobrante (diferencia entre el crédito introducido y el precio del artículo).

Durante el proceso se pueden producir diversas incidencias, como por ejemplo, que el cliente no haya introducido suficiente crédito para comprar el producto, que no quede producto o que no haya cambio suficiente para la devolución. La máquina también da la posibilidad de solicitar la devolución del crédito sin realizar la compra.

1. Diseñar la clase `Expendedora` (proyecto `Expendedora`) con los atributos y métodos que se describen a continuación.

   - Atributos (privados)

     - `credito`: Cantidad de dinero (en euros) introducida por el cliente.
     - `stock`: Número de unidades que quedan en la máquina disponibles para la venta. Se reducirá con cada nueva venta.
     - `precio`: Precio del único artículo que dispensa la máquina (en euros).
     - `cambio`: Cambio del que dispone la máquina. El cambio disponible se reduce cada vez que se devuelve al cliente la diferencia entre el crédito introducido y el precio del producto comprado. El cambio nunca se ve incrementado por las compras de los clientes.
     - `recaudación`: Representa la suma de las ventas realizadas por la máquina (en euros). Se ve incrementada con cada nueva compra.

   - Métodos:

     - Constructor: `public Expendedora (double cambio, int stock, double precio)`. Crea la expendedora inicializando los atributos cambio, stock y precio con los valores indicados en los parámetros). El crédito y la recaudación serán cero.

     - Consultores:

       - Métodos consultores para los atributos crédito, cambio, y recaudación
       - Los consultores para el stock y el precio los haremos previendo que en el futuro la máquina pueda expender más de un tipo de producto. Para consultar el stock y el precio se indicará como parámetro el número de producto que se quiere consultar aunque, por el momento se ignorará el valor de dicho atributo.
       - `public getStock (int producto)` Devuelve el stock disponible del producto indicado. En esta versión simplificada se devolverá el valor del atributo stock, sea cual sea el valor de producto.
       - `public getPrecio (int producto)` Devuelve el precio del producto indicado. En esta versión simplificada se devolverá el valor del atributo precio, , sea cual sea el valor de producto.

     - Modificadores: Para simplificar, consideramos que los atributos de la máquina solo van a cambiar por operaciones derivadas de su funcionamiento, por lo que no proporcionamos modificadores públicos

     - Otros métodos:

     - `public String toString()` Devuelve un `String` de la forma:

       ```
       Credito: 3.0 euros
       Cambio: 12.73 euros
       Stock: 12 unidades:
       Recaudación: 127.87 euros
       ```

     - `public void introducirDinero(double importe)` Representa la operación mediante la cual el cliente añade dinero (crédito) a la máquina. Esta operación incrementa el crédito introducido por el cliente en el importe indicado como parámetro.

     - `public double solicitarDevolucion()` Representa la operación mediante la cual el cliente solicita la devolución del crédito introducido sin realizar la compra. El método devuelve la cantidad de dinero que se devuelve al cliente.

     - `public double comprarProducto(int producto) throws NoHayCambioException, NoHayProductoException, CreditoInsuficienteException`. Representa la operación mediante la cual el cliente selecciona un producto para su compra. El método devuelve la cantidad de dinero que se devuelve al cliente.

       Si no se produce ninguna situación inesperada, se reduce el stock del producto, se devuelve el cambio, se pone el crédito a cero y se incrementa la recaudación.

       Si la venta no es posible se lanzará la excepción correspondiente a la situación que impide completar la venta.

2. La clase `Producto` permite representar uno de los artículos de los que vende una máquina expendedora. Para ello utilizaremos tres atributos privados `nombre` (`String`), `precio` (`double`) y `stock` (`int`), y los siguientes métodos:

   - `public Producto(String nombre, double precio, int stock)` Constructor que inicializa el producto con los parámetros indicados
   - Consultores de los tres atributos: `getNombre`, `getPrecio` y `getStock`
   - `public int decrementarStock()`: Decrementa en 1 el stock del producto y devuelve el stock resultante.

3. La clase `Surtido` representa una colección de productos. Para ello se usará un atributo `listaProductos`, array de `Productos`. El array se rellenará con los datos de productos extraidos de un fichero de texto y, una vez creado el surtido no será posible añadir o quitar productos. Así, el array de productos estará siempre completo y no es necesario ningún atributo que indique cuantos productos hay en el array.

   Se implementarán los siguientes métodos:

   - `public Surtido() throws FileNotFoundException` Crea el surtido con los datos de los productos que se encuentran en el fichero `productos.txt`. El fichero tiene el siguiente formato:

     ```
     <nº de productos>
     <nombre de producto> <precio> <stock>
     <nombre de producto> <precio> <stock>
     <nombre de producto> <precio> <stock>
     ...
     ```

     Como vemos, la primera línea del fichero indica el número de productos que contiene el surtido. Este dato lo usaremos para dar al array de productos el tamaño adecuado.

   - `public int numProductos()` Devuelve el número de productos que componen el surtido

   - `public Producto getProducto(int numProducto)`: Devuelve el producto que ocupa la posición `numProducto` del surtido. La primera posición válida es la `1`. La posición `0` no se utiliza.

   - `public String[] getNombresProductos()` Devuelve un array con los nombres de los productos. La posición `0` del array no se utilizará (será `null`)

4. Revisar la clase `Expendedora`. Añadir los atributos y hacer los cambios necesarios en la clase para que sea capaz de dispensar varios productos.

5. Añadir a la clase el método public Surtido `getSurtido()`, que devuelva el surtido de la máquina (`Objeto` de la clase `Surtido`)

6. Modificar la clase `TestExpendedora` para adaptarla a los cambios hechos en la clase `Expendedora`.

# Actividades

1. Introducir por teclado un valor de tipo `double` , convertirlo en Wrapper e imprimirlo.

2. Introducir por teclado un valor numérico en un `String` y convertirlo en entero e imprimirlo.

3. Introducir por teclado un valor numérico entero en un `String` y convertirlo en un `Wrapper` e imprimirlo.

4. Introducir por teclado dos valores numéricos enteros y la operación que queremos realizar (`suma`, `resta` o `multiplicación`). Realizar la operación y mostrar el resultado en `Binario`, `Hexadecimal` y `Octal`.

   Ejemplo de ejecución:

   ```sh
   Introduce el primer valor numérico: 14
   Introduce el segundo valor numérico: 4
   Introduce la operación: resta
   EL RESULTADO:
    en binario: 1010
    en octal: 12
    en binario: a
   ```

5. Mostrar los segundos transcurridos desde el `1 de Enero de 1970 a las 0:00:00` hasta `hoy`.

6. Mostrar la `fecha` y `hora` de hoy con los siguientes formatos (para todos los ejemplos se supone que hoy es 26 de agosto de 2021 a las 17 horas 16 minutos y 8 segundos, tu deberas mostrar la fecha y hora de tu sistema en el momento de ejecuc):

   a) `August 26, 2021, 5:16 pm`
   b) `08.26.21`
   c) `26, 8, 2021`
   d) `20210826`
   e) `05-16-08, 26-08-21`
   f) `Thu Aug 26 17:16:08`
   g) `17:16:08`

7. Introducir un día, un mes y un año y verificar si es una fecha correcta. 

   ```sh
   Introduce un dia para la fecha: 29
   Introduce un mes para la fecha: 2
   Introduce un año para la fecha: 2022
   LA FECHA ES INCORRECTA
   
   Introduce un dia para la fecha: 29
   Introduce un mes para la fecha: 2
   Introduce un año para la fecha: 2020
   LA FECHA ES CORRECTA
   ```

8. Introducir dos fechas e indicar los días transcurridos entre las dos fechas. 

   ```sh
   Introduce la fecha inicial con formato dd/mm/yyyy: 01/02/2021
   Introduce la fecha final con formato dd/mm/yyyy: 15/03/2022
   La fecha inicial es: 1/2/2021
   La fecha final es: 15/3/2022
   Entre la fecha inicial y la final hay un periodo de: P1Y1M14D
   dias: 14
   meses: 1
   años: 1
   ```

9. Introducir una fecha y devolver las fecha de los pagos a 30, 60 y 90 días. 

10. Introducir tres fechas e indicar la mayor y a menor.

11. Introducir el día, mes, año. Crear una fecha a partir de los datos introducidos y comprobar e indicar si se trata de la fecha actual, si es una fecha pasada o una fecha futura.

12. Introducir una fecha de nacimiento de un empelado e indicar cuántos años tiene el empleado.

13. Introducir la fecha de caducidad de un producto e indicar si el producto está o no caducado. El valor por defecto será la fecha actual y solo se podrán introducir fechas del año en curso.

14. Mostrar una fecha con formato dd/mm/aaaa utilizando 0 delante de los días o meses de 1 dígito.

15. Mostrar una fecha con formato `DiaSemana`, `DiaMes` de `Mes` del `Año` a las `horas:minutos:segundos`. Por ejemplo: Miercoles, 9 de Diciembre del 2015 a las 18:45:32

16. Suma 10 años, 4 meses y 5 días a la fecha actual.

    ```sh
    Hoy es: dijous, 03 de març del 2022
    Dentro de 10 años, 4 meses y 5 dias será: dijous, 08 de juliol del 2032
    ```

17. Resta 5 años, 11 meses y 18 días a la fecha actual.

18. Introducir el número de horas trabajadas por un empleado y la fecha en las que las trabajo. Si el día fue sábado o domingo el precio hora trabajada es 20€ en caso contrario 15€. Calcula la cantidad de dinero que habrá que pagar al empleado por las horas trabajadas.

19. Introducir la fecha inicial y final de una nómina y calcular lo que debe cobrar el empleado sabiendo que cada día trabajado recibe 55 € y tiene una retención del 12% sobre el sueldo.

20. Crear una clase `Alumno` con los atributos `codigo`, `nombre`, `apellidos`, `fecha_nacimiento`, `calificacion`. La fecha de nacimiento deberá introducirse como una fecha. Crear constructor, métodos `setter` y `getter` y `toString`. Crear una instancia con los siguientes valores `1`, `'Luis'`, `'Mas Ros'`, `05/10/1990`, `7.5`. Mostrar los datos del alumno además de su edad.

    ```sh
    Alumno{codigo=1, nombre=Luis, apellidos=Mas Ros, fecha=1990-10-05, calificacion=7.5, edad= 31}
    ```

21. Introducir la fecha de entrega de un documento y nos diga si está dentro o fuera de plazo teniendo en cuenta que la fecha de entrega límite es la fecha actual.

22. Introducir en un array `nombre`, `apellidos` y `sueldo` de varios trabajadores y la `fecha de alta` en la empresa. Las fechas deberán introducirse como fechas. Recorrer el array y mostrar para cada trabajador la retención que debe aplicarse sobre el sueldo teniendo en cuenta que los trabajadores incorporados antes de 1980 tienen una retención del 20%, los trabajadores con fecha entre 1980 y 2000 una retención del 15% y los trabajadores con fecha posterior al 2000 la retención que aplicaremos será el 5% del sueldo.

23. Realizar una aplicación para la gestión de la información de las personas vinculadas a una `Facultad`, que se pueden clasificar en tres tipos: estudiantes, profesores y personal de servicio.
    A continuación, se detalla qué tipo de información debe gestionar esta aplicación:

    - Por cada `Persona`, se debe conocer, al menos, su `nombre` y `apellidos`, su `número de identificación` y su `estado civil`.
    - Con respecto a los `Empleados`, sean del tipo que sean, hay que saber su `año de incorporación` a la facultad y qué `número de despacho` tienen asignado.
    - En cuanto a los `Estudiantes`, se requiere almacenar el `curso` en el que están matriculados.
    - Por lo que se refiere a los `Profesores`, es necesario gestionar a qué `departamento` pertenecen (`lenguajes`, `matemáticas`, `arquitectura`, ...).
    - Sobre el `Personal de servicio`, hay que conocer a qué `sección` están asignados (`biblioteca`, `decanato`, `secretaría`, ...).

    El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de esta aplicación. A continuación, debe programar las clases definidas en las que, además de los constructores, hay que desarrollar los métodos correspondientes a las siguientes acciones:

    - Cambio del estado civil de una persona.
    - Reasignación de despacho a un empleado.
    - Matriculación de un estudiante en un nuevo curso.
    - Cambio de departamento de un profesor.
    - Traslado de sección de un empleado del personal de servicio.
    - Imprimir toda la información de cada tipo de individuo.

    En el método `main` crear un array de `personas`. Crear diferentes instancias de las subclases e insertarlas en el array. Probar los diferentes métodos desarrollados.

24. Crea una clase `Empleado` y una subclase `Encargado`. Los encargados reciben un 10% más de sueldo base que un empleado normal aunque realicen el mismo trabajo. Implementa dichas clases en el paquete objetos y sobrescribe el método `getSueldo()` para ambas clases.

25. Realiza un método estático que dada la `fecha de nacimiento` de una persona indique si es mayor de edad.

26. Crear la clase `Dado`, la cual desciende de la clase `Sorteo`. La clase `Dado`, en la llamada `lanzar()` mostrará un número aleatorio del 1 al 6. Crear la clase `Moneda`, la cual desciende de la clase `Sorteo`. Esta clase en la llamada al método `lanzar()` mostrará las palabras cara o cruz. Realizar una clase con un método `main` que compruebe todo lo realizado.

27. Realiza una clase `Conversor` que tenga las siguientes características: Toma como parámetro en el constructor un valor entero. Tiene un método `getNumero` que dependiendo del parámetro devolverá el mismo número en el siguiente `B Binario`, `H Hexadecimal`, `O Octal`. Realiza un método `main` en la clase para probar todo lo anterior.

28. Realiza una clase `ConversorFechas` que tenga los siguientes métodos:
    - `String normalToAmericano(String)`. Este método convierte una fecha en formato normal `dd/mm/yyyy` a formato americano `mm/dd/yyyy`
    - `String americanoToNormal(String)`. Este método realiza el paso contrario, convierte fechas en formato americano a formato normal.

29. Realiza una clase `Huevo` con un atributo `tamaño` (`S`, `M`, `L`, `XL`) con el método `toString`. La clase `Huevo` está compuesta por dos clases internas, una `Clara` y otra `Yema`. Ambas clases tiene un atributo `color` y el método `toString`. Realiza un método `main` en el que se cree un objeto de tipo `Huevo`, `Clara` y `Yema`. Se le asigne valor a sus atributos y se muestren dichos valores.


# Fuentes de información

- [Wikipedia](https://es.wikipedia.org)
- [Programación (Grado Superior) - Juan Carlos Moreno Pérez (Ed. Ra-ma)](https://www.ra-ma.es/libro/programacion-grado-superior_48302/)
- Apuntes IES Henri Matisse (Javi García Jimenez?)
- Apuntes AulaCampus
- [Apuntes José Luis Comesaña](https://www.sitiolibre.com/)
- [Apuntes IOC Programació bàsica (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_asx_m03_/web/fp_asx_m03_htmlindex/index.html)
- [Apuntes IOC Programació Orientada a Objectes (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m03_/web/fp_dam_m03_htmlindex/index.html)
