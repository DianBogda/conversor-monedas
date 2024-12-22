package com.aluracursos.conversormonedas.acciones;

import com.aluracursos.conversormonedas.modelos.Moneda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorDeMonedas {
    private BuscadorDeMonedas buscadorMonedas;
    private GuardadorDeMonedas guardadorMonedas;

    public ControladorDeMonedas() {
        buscadorMonedas = new BuscadorDeMonedas();
        guardadorMonedas = new GuardadorDeMonedas();
    }

    public void iniciar() {
        Scanner teclado = new Scanner(System.in);

        String menu = """
                **********************************************
                Sea bienvenida/o al Conversor de Monedas :)
                
                1) Dólar Americano =>> Peso Argentino
                2) Peso Argentino =>> Dólar Americano
                3) Dólar Americano =>> Real Brasileño
                4) Real Brasileño =>> Dólar Americano
                5) Dólar Americano =>> Dólar Canadiense
                6) Dólar Canadiense =>> Dólar Americano
                7) Dólar Americano =>> Peso Chileno
                8) Peso Chileno =>> Dólar Americano
                9) Dólar Americano =>> Peso Colombiano
                10) Peso Colombiano =>> Dólar Americano
                11) Dólar Americano =>> Peso Mexicano
                12) Peso Mexicano  =>> Dólar Americano
                13) Dólar Americano =>> Euro
                14) Euro =>> Dólar Americano
                15) Dólar Americano =>> Libras Esterlinas
                16) Libras Esterlinas =>> Dólar Americano
                17) Dólar Canadiense =>> Libras Esterlinas
                18) Libras Esterlinas =>> Dólar Canadiense
                19) Dólar Canadiense =>> Euro
                20) Euro =>> Dólar Canadiense
                21) Libras Esterlinas =>> Euro
                22) Euro =>> Libras Esterlinas
                23) Salir
                
                Elija una opción válida:
                **********************************************
                """;
        String mensaje = "Ingrese el valor que desea convertir: ";
        int numOpcion = 0;
        double montoAConvertir;
        List<Moneda> monedasObtenidas = new ArrayList<>();

        while (numOpcion != 23) {
            System.out.println(menu);
            numOpcion = teclado.nextInt();
            System.out.println(mensaje);
            montoAConvertir = teclado.nextDouble();

            switch (numOpcion) {
                case 1:
                    List<Moneda> monedaObtenida1 = obtenerConversion("USD", "ARS", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida1);
                    break;
                case 2:
                    List<Moneda> monedaObtenida2 = obtenerConversion("ARS", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida2);
                    break;
                case 3:
                    List<Moneda> monedaObtenida3 = obtenerConversion("USD", "BRL", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida3);
                    break;
                case 4:
                    List<Moneda> monedaObtenida4 = obtenerConversion("BRL", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida4);
                    break;
                case 5:
                    List<Moneda> monedaObtenida5 = obtenerConversion("USD", "CAD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida5);
                    break;
                case 6:
                    List<Moneda> monedaObtenida6 = obtenerConversion("CAD", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida6);
                    break;
                case 7:
                    List<Moneda> monedaObtenida7 = obtenerConversion("USD", "CLP", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida7);
                    break;
                case 8:
                    List<Moneda> monedaObtenida8 = obtenerConversion("CLP", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida8);
                    break;
                case 9:
                    List<Moneda> monedaObtenida9 = obtenerConversion("USD", "COP", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida9);
                    break;
                case 10:
                    List<Moneda> monedaObtenida10 = obtenerConversion("COP", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida10);
                    break;
                case 11:
                    List<Moneda> monedaObtenida11 = obtenerConversion("USD", "MXN", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida11);
                    break;
                case 12:
                    List<Moneda> monedaObtenida12 = obtenerConversion("MXN", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida12);
                    break;
                case 13:
                    List<Moneda> monedaObtenida13 = obtenerConversion("USD", "EUR", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida13);
                    break;
                case 14:
                    List<Moneda> monedaObtenida14 = obtenerConversion("EUR", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida14);
                    break;
                case 15:
                    List<Moneda> monedaObtenida15 = obtenerConversion("USD", "GBP", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida15);
                    break;
                case 16:
                    List<Moneda> monedaObtenida16 = obtenerConversion("GBP", "USD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida16);
                    break;
                case 17:
                    List<Moneda> monedaObtenida17 = obtenerConversion("CAD", "GBP", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida17);
                    break;
                case 18:
                    List<Moneda> monedaObtenida18 = obtenerConversion("GBP", "CAD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida18);
                    break;
                case 19:
                    List<Moneda> monedaObtenida19 = obtenerConversion("CAD", "EUR", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida19);
                    break;
                case 20:
                    List<Moneda> monedaObtenida20 = obtenerConversion("EUR", "CAD", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida20);
                    break;
                case 21:
                    List<Moneda> monedaObtenida21 = obtenerConversion("GBP", "EUR", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida21);
                    break;
                case 22:
                    List<Moneda> monedaObtenida22 = obtenerConversion("EUR", "GBP", montoAConvertir);
                    monedasObtenidas.addAll(monedaObtenida22);
                    break;
                case 23:
                    teclado.close();
                    System.out.println("Conversor de Monedas finalizado. Gracias por utilizar nuestro programa.");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida. Por favor ingrese nuevamente la opción deseada." + "\n");
            }
        }
        //System.out.println(monedasObtenidas);
        guardadorMonedas.guardarMonedas(monedasObtenidas);
        //System.out.println("Lista de monedas guardadas en 'monedasConvertidas.json'.");
    }

    private List<Moneda> obtenerConversion(String monedaBase, String monedaNueva, double montoAConvertir) {
        List<Moneda> listaMonedas = buscadorMonedas.buscarMonedas(monedaBase, monedaNueva, montoAConvertir);
        //System.out.println("Lista de monedas: " + listaMonedas);
        return listaMonedas;
    }
}