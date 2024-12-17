package com.aluracursos.conversormonedas.modelos;

public class Moneda {
    private String codigoMonedaBase;
    private double valorDeMoneda;
    private String codigoMonedaNueva;
    private double montoConvertido;

    public Moneda(MonedaAPI miMoneda) {
        this.codigoMonedaBase = miMoneda.base_code();
        this.valorDeMoneda = miMoneda.conversion_rate();
        this.codigoMonedaNueva = miMoneda.target_code();
        this.montoConvertido = miMoneda.conversion_result();
    }

    @Override
    public String toString() {
        return "***" + "\n" +
                "- Valor de conversión: $ " + valorDeMoneda + " " + codigoMonedaBase + "\n" +
                "- Monto final de: $ " + montoConvertido + " " + codigoMonedaNueva + "\n" +
                "************************" + "\n";
    }
}
