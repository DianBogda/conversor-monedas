package com.aluracursos.conversormonedas.modelos;

public record MonedaAPI(String base_code, double conversion_rate, String target_code, double conversion_result) {
}
