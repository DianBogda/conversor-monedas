package com.aluracursos.conversormonedas.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Moneda {
    private String fechaConversion;
    private String codigoMonedaBase;
    private double valorDeMoneda;
    private String codigoMonedaNueva;
    private double montoConvertido;

    public Moneda(MonedaAPI miMoneda) {
        this.fechaConversion = miMoneda.time_last_update_utc();
        fechaConversion = obtenerFechaConversion();
        this.codigoMonedaBase = miMoneda.base_code();
        this.valorDeMoneda = miMoneda.conversion_rate();
        this.codigoMonedaNueva = miMoneda.target_code();
        this.montoConvertido = miMoneda.conversion_result();
    }

    public String obtenerFechaConversion() {
        LocalDateTime fecha_hora_local = LocalDateTime.now();
        this.fechaConversion = fecha_hora_local
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .withLocale(Locale.CANADA));
        return fechaConversion;
    }

    @Override
    public String toString() {
        return "***" + "\n" +
                "- Fecha de conversión: " + obtenerFechaConversion() + "\n" +
                "- Valor de conversión: $ " + valorDeMoneda + " " + codigoMonedaBase + "\n" +
                "- Monto final de: $ " + montoConvertido + " " + codigoMonedaNueva + "\n" +
                "************************" + "\n";
    }
}