# conversor-monedas
Proyecto para practicar programación orientada a objetos a través de una API, en lenguaje Java.

## Índice
- [Entorno Java](#entorno-java)
- [Descripción del proyecto](#descripción-del-proyecto)
- [Demo](#demo)
- [A Mejorar](#a-mejorar)

## Entorno Java
- Java JDK: versión 11 en adelante
- Biblioteca Gson 2.10.1 en adelante => [Maven Central Repository Search](https://mvnrepository.com/artifact/com.google.code.gson/gson)
- IDE (Entorno de Desarrollo Integrado) IntelliJ IDEA

## Descripción del proyecto
- Se utiliza API para traer los datos de conversión de moneda => https://www.exchangerate-api.com/
- Se consume la API con el formato ejemplo proporcionado en la documentación de la misma.
- Se crea la clase Moneda.java; para configurar el objeto.
- Se crea un record llamado MonedaAPI.java; para acceder a la información y consumirla desde la API.
- Se crea la clase BuscadorDeMonedas.java; donde se realiza la conexión con la API para traer la información requerida a través de biblioteca Gson.
- Se crea la clase GuardadorDeMonedas.java; que realiza la escritura de la información obtenida desde la API en formato json.
- Se crea la clase ControladorDeMonedas.java; donde se utiliza la clase Scanner para interactuar con el usuario, se configura el menú de opciones a través de un loop while para seleccionar opciones con un switch, se imprime la fecha y la hora de la conversión seleccionada utilizando la biblioteca java.time y se obtienen las conversiones deseadas según las opciones establecidas para elegir.
- Se ejecuta el método main para ejecutar el programa.
- Se obtiene un archivo json con el listado de las monedas convertidas, al finalizar el programa.

## Demo
Ver como funciona ahora el mini proyecto en una pequeña demo => [https://drive.google.com/file/d/1lUx3ZaDWe83Wlq34DbgNOXxzUWFvjtz5/view?usp=drive_link](https://drive.google.com/file/d/1hi0ZH2LX436LzhhVFQHn_APYQ10lWUTb/view?usp=sharing)

## A Mejorar
- Problema 1 : A pesar que el ciclo termina con la opción de salir elegida por el usuario, sigue mostrando la línea de elegir el monto.
- Problema 2 : Investigar para poder imprimir el listado de monedas convertidas con sus fechas respectivas, como historial.
