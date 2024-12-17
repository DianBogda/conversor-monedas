package com.aluracursos.conversormonedas.acciones;

import com.aluracursos.conversormonedas.modelos.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardadorDeMonedas {
    public void guardarMonedas(List<Moneda> monedas) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter listaMonedas = new FileWriter("monedasConvertidas.json")) {
            listaMonedas.write(gson.toJson(monedas));
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            System.out.println("Monedas guardadas en 'monedasConvertidas.json'" + "\n");
            //System.out.println("La ejecución del programa ha finalizado.");
        }
    }
}