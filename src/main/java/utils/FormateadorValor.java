package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormateadorValor {

    public static String aFormatoCmax(String textoPrecio) {

        // Buscar el primer bloque numérico con posible separador de miles
        Pattern pattern = Pattern.compile("\\d{1,3}(?:\\.\\d{3})*");
        Matcher matcher = pattern.matcher(textoPrecio);

        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    "No se pudo extraer valor numérico de: " + textoPrecio);
        }

        String valorEncontrado = matcher.group();

        // Quitar puntos de miles
        String soloNumeros = valorEncontrado.replace(".", "");

        double valor = Double.parseDouble(soloNumeros);

        DecimalFormat formato = new DecimalFormat("#,##0.00");
        formato.setDecimalFormatSymbols(
                new DecimalFormatSymbols(new Locale("es", "CO")));

        return formato.format(valor) + " COP";
    }
}