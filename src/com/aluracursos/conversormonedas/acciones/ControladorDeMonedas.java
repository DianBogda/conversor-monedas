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

        while (numOpcion != 23) {
            System.out.println(menu);
            numOpcion = teclado.nextInt();
            System.out.println(mensaje);
            montoAConvertir = teclado.nextDouble();

            switch (numOpcion) {
                case 1:
                    obtenerConversion("USD", "ARS", montoAConvertir);
                    break;
                case 2:
                    obtenerConversion("ARS", "USD", montoAConvertir);
                    break;
                case 3:
                    obtenerConversion("USD", "BRL", montoAConvertir);
                    break;
                case 4:
                    obtenerConversion("BRL", "USD", montoAConvertir);
                    break;
                case 5:
                    obtenerConversion("USD", "CAD", montoAConvertir);
                    break;
                case 6:
                    obtenerConversion("CAD", "USD", montoAConvertir);
                    break;
                case 7:
                    obtenerConversion("USD", "CLP", montoAConvertir);
                    break;
                case 8:
                    obtenerConversion("CLP", "USD", montoAConvertir);
                    break;
                case 9:
                    obtenerConversion("USD", "COP", montoAConvertir);
                    break;
                case 10:
                    obtenerConversion("COP", "USD", montoAConvertir);
                    break;
                case 11:
                    obtenerConversion("USD", "MXN", montoAConvertir);
                    break;
                case 12:
                    obtenerConversion("MXN", "USD", montoAConvertir);
                    break;
                case 13:
                    obtenerConversion("USD", "EUR", montoAConvertir);
                    break;
                case 14:
                    obtenerConversion("EUR", "USD", montoAConvertir);
                    break;
                case 15:
                    obtenerConversion("USD", "GBP", montoAConvertir);
                    break;
                case 16:
                    obtenerConversion("GBP", "USD", montoAConvertir);
                    break;
                case 17:
                    obtenerConversion("USD", "GBP", montoAConvertir);
                    break;
                case 18:
                    obtenerConversion("GBP", "USD", montoAConvertir);
                    break;
                case 19:
                    obtenerConversion("CAD", "EUR", montoAConvertir);
                    break;
                case 20:
                    obtenerConversion("EUR", "CAD", montoAConvertir);
                    break;
                case 21:
                    obtenerConversion("GBP", "EUR", montoAConvertir);
                    break;
                case 22:
                    obtenerConversion("EUR", "GBP", montoAConvertir);
                    break;
                case 23:
                    teclado.close();
                    System.out.println("Conversor de Monedas finalizado. Gracias por utilizar nuestro programa.");
                    break;
                default:
                    System.out.println("La opción ingresada no es válida. Por favor ingrese nuevamente la opción deseada." + "\n");
            }
        }
    }

    private List<Moneda> obtenerConversion(String monedaBase, String monedaNueva, double montoAConvertir) {
        List<Moneda> monedas = new ArrayList<>();
        List<Moneda> listaMonedas = buscadorMonedas.buscarMonedas(monedaBase, monedaNueva, montoAConvertir);
        monedas.addAll(listaMonedas);
        //System.out.println("Lista de monedas: " + listaMonedas);

        guardadorMonedas.guardarMonedas(listaMonedas);
        //System.out.println("Lista de monedas guardadas en 'monedasConvertidas.json'");
        return monedas;
    }
}