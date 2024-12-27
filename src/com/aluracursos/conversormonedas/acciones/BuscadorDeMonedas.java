package com.aluracursos.conversormonedas.acciones;

import com.aluracursos.conversormonedas.modelos.Moneda;
import com.aluracursos.conversormonedas.modelos.MonedaAPI;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BuscadorDeMonedas {
    public List<Moneda> buscarMonedas(String codigoMonedaBase, String codigoNuevaMoneda, double montoAConvertir) {
        List<Moneda> monedas = new ArrayList<>();
        Gson gson = new Gson();

        String api_key = "254874dacb01081a3d604222";
        String direccionURL = "https://v6.exchangerate-api.com/v6/" + api_key + "/pair/" + codigoMonedaBase + "/" +
                              codigoNuevaMoneda + "/" + montoAConvertir;

        LocalDateTime fecha_hora_local = LocalDateTime.now();
        String formato_fecha_hora  = fecha_hora_local
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .withLocale(Locale.CANADA));

        try {
            URL url = new URL(direccionURL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            //System.out.println("Json: " + jsonobj);

            String req_result = jsonobj.get("result").getAsString();
            String moneda_base = jsonobj.get("base_code").getAsString();
            String moneda_nueva = jsonobj.get("target_code").getAsString();
            double valor_de_conversion = jsonobj.get("conversion_rate").getAsDouble();
            double valor_convertido = jsonobj.get("conversion_result").getAsDouble();
            //System.out.println("Valor de conversión: $" + valor_de_conversion + ", de '" + moneda_base + "' a '" + moneda_nueva + "'");

            MonedaAPI miMonedaAPI = gson.fromJson(jsonobj, MonedaAPI.class);
            //System.out.println("Mi moneda API: " + miMonedaAPI);

            Moneda miMoneda = new Moneda(miMonedaAPI);
            //System.out.println("Mi moneda equivale a: " + miMoneda);
            monedas.add(miMoneda);

            System.out.println(formato_fecha_hora);
            System.out.println(
                    "El valor $" + montoAConvertir + " [" + moneda_base + "] corresponde al valor final de =>>> $" +
                            valor_convertido + " [" + moneda_nueva + "]" + "\n"
            );

        } catch (UnsupportedOperationException | IOException e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }
        //System.out.println("Monedas encontradas: " + monedas);
        return monedas;
    }
}