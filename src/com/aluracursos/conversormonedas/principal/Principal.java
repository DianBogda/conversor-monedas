package com.aluracursos.conversormonedas.principal;

import com.aluracursos.conversormonedas.acciones.ControladorDeMonedas;

public class Principal {
    public static void main(String[] args) {
        ControladorDeMonedas controlador = new ControladorDeMonedas();
        controlador.iniciar();
    }
}