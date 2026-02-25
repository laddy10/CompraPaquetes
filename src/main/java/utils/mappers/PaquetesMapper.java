package utils.mappers;

import java.util.HashMap;
import java.util.Map;

import static utils.ConstantsPaquetes.*;

public class PaquetesMapper {

    private static final Map<String, String> MAPEO_CMAX = new HashMap<>();
    private static final Map<String, String> MAPEO_INTERNACIONAL = new HashMap<>();

    static {


        // =======================================================
        // ================== MI CLARO APP =======================
        // =======================================================


        // =========================
        // TODO INCLUIDO CON REDES
        // =========================

        MAPEO_CMAX.put(TODO_INCLUIDO_3DIAS_400MB,
                "Todo Incluido WTF+400MB Vig 3 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_1DIAS_50MIN,
                "Todo Incluido WTF+50MB Vig 1 dia");

        MAPEO_CMAX.put(TODO_INCLUIDO_3DIAS_400MB_4BENEFICIARIOS,
                "Todo Incluido + 400MB + WTF 3 Dias de Salud en Linea 4 beneficiarios");

        MAPEO_CMAX.put(TODO_INCLUIDO_6DIAS_1_4GB_4BENEFICIARIOS,
                "Todo Incluido + 1.4GB + WTF 6 Dias de Salud en Linea 4 beneficiarios");

        MAPEO_CMAX.put(TODO_INCLUIDO_6DIAS_1_4GB,
                "Todo Incluido WTF+1.4GB Vig 6 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_7DIAS_2GB,
                "Todo Incluido WTF+2GB Vig 7 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_3_5GB,
                "Todo Incluido 3.5 GB + Whatsapp Facebook Twitter Vig 10 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_30DIAS_80GB,
                "Todo Incluido Voz ilimitados Whatsapp Facebook Twitter +80GB Vig 30 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_20DIAS_7_5GB,
                "Todo Incluido 7.5 GB + Whatsapp Facebook Twitter Vig 20 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_12GB,
                "Todo Incluido Datos 12GB + WTF Vig 30 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_30DIAS_18GB,
                "Todo Incluido 30 GB Vig 30 dias");


        // =========================
        // TODO INCLUIDO SIN REDES
        // =========================

        MAPEO_CMAX.put(TODO_INCLUIDO_7DIAS_10GB,
                "Todo Incluido 10GB Vig 7 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_15DIAS_20GB,
                "Todo Incluido 20GB Vig 15 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_30DIAS_30GB,
                "Todo Incluido 30 GB Vig 30 dias");


        // =========================
        // PAQUETES DE DATOS
        // =========================

        MAPEO_CMAX.put(NAVEGACION_ILIMITADA_2H,
                "paquete Navegacion ilimitada Vig 2 horas");

        MAPEO_CMAX.put(NAVEGACION_200MB_1DIA,
                "Datos 200MB+WTF Vig 1 dia");

        MAPEO_CMAX.put(NAVEGACION_400MB_1DIA,
                "Datos 400MB+WTF Vig 1 dia");

        MAPEO_CMAX.put(NAVEGACION_800MB_3DIAS,
                "Datos 800MB+WTF Vig 3 dias");

        MAPEO_CMAX.put(NAVEGACION_2GB_7DIAS,
                "Datos 2GB+WTF Vig 7 dias");


        // =========================
        // PAQUETES APPS
        // =========================

        MAPEO_CMAX.put(SALUD_EN_LINEA_30DIAS,
                "Salud en Linea 1 beneficiario Vig 30 Dias");

        MAPEO_CMAX.put(SALUD_EN_LINEA_30DIAS_2BENEFICIARIOS,
                "Salud en Linea 2 beneficiarios Vig 30 Dias");

        MAPEO_CMAX.put(SALUD_EN_LINEA_30DIAS_4BENEFICIARIOS,
                "Salud en Linea 4 beneficiarios Vig 30 Dias");


        // =========================
        // PAQUETES DE VOZ
        // =========================

        MAPEO_CMAX.put(PAQUETE_300M_1DIA,
                "Paquete 300 Minutos Vig 1 dia");

        MAPEO_CMAX.put(PAQUETE_1000M_20DIAS,
                "Paquete 1000 Minutos Vig 20 dias");

        MAPEO_CMAX.put(PAQUETE_300M_2DIAS,
                "Paquete 300 Minutos Vig 2 dias");


        // =========================
        // RELEVO COMUNIDAD SORDA
        // =========================

        MAPEO_CMAX.put(PAQUETE_RELEVO_800MB_7DIAS,
                "Paquete Relevo 800MB Vig 7 dias");

        MAPEO_CMAX.put(PAQUETE_RELEVO_2_5GB_15DIAS,
                "Paquete Relevo 2.5GB Vig 15 dias");

        MAPEO_CMAX.put(PAQUETE_RELEVO_6GB_30DIAS,
                "Paquete Relevo 6GB Vig 30 dias");


        // =======================================================
        // ================== WHATSAPP ===========================
        // =======================================================


        // =========================
        // PAQUETES TODO INCLUIDO
        // =========================

        MAPEO_CMAX.put(TODO_INCLUIDO_50MB_50MIN,
                "Todo Incluido 50 minutos + SMS Ilimitados + W + 50 MB 1 Dia");

        MAPEO_CMAX.put(TODO_INCLUIDO_400MB_WFT_VOZ,
                "Todo Incluido WTF+400MB Vig 3 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_1_4GB_WFT_VOZ, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_2GB_WFT_VOZ, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_3_5GB_WFT_VOZ, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_10GB_VOZ_SMS_ILIM, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_7_5GB_WFT_VOZ, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_20GB_VOZ_SMS_ILIM, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_12GB_WFT_VOZ, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_30GB_VOZ_SMS_ILIM, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_18GB_WFT_VOZ,
                "Todo Incluido Datos 18GB + WTF Vig 30 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_80GB_WFT_VOZ,
                "Todo Incluido Voz Ilimitados Whatsapp Facebook Twitter +80GB Vig 30 dias");

        MAPEO_CMAX.put(TODO_INCLUIDO_400MB_WFT_SALUD_4_BENEFICIARIOS, "");

        MAPEO_CMAX.put(TODO_INCLUIDO_1_4GB_WFT_SALUD_4_BENEFICIARIOS, "");


        // =========================
        // PAQUETES VOZ
        // =========================

        MAPEO_CMAX.put(PQ_VOZ_300_MINUTOS, "");

        MAPEO_CMAX.put(PQ_VOZ_1000_MINUTOS, "");

        // =========================
        // PAQUETES DATOS
        // =========================

        MAPEO_CMAX.put(PQ_DATOS_200MB_WH, "");

        MAPEO_CMAX.put(PQ_DATOS_400MB_WFT, "");

        MAPEO_CMAX.put(PQ_DATOS_800MB_WFT, "");

        MAPEO_CMAX.put(PQ_DATOS_ILIMITADOS, "");

        MAPEO_CMAX.put(PQ_DATOS_2GB_WFT, "");


        // =======================================================
        // =============== INTERNACIONALES WHATSAPP =============
        // =======================================================

        // USA, CAN, PR, MEX
        MAPEO_INTERNACIONAL.put(PRECIO_$5900_60MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$9900_120MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$18900_240MIN,
                "");


        // LDI SIN FRONTERAS
        MAPEO_INTERNACIONAL.put(PRECIO_$18900_50MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$31900_100MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$59900_200MIN,
                "");


        // LDI VENEZUELA
        MAPEO_INTERNACIONAL.put(PRECIO_$2900_12MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$6900_30MIN,
                "");


        // LDI PREFERENCIAL
        MAPEO_INTERNACIONAL.put(PRECIO_$23900_50MIN,
                "PqM LDI Preferencial50MIN");

        MAPEO_INTERNACIONAL.put(PRECIO_$44900_100MIN,
                "PqM LDI Preferencial100MIN");

        MAPEO_INTERNACIONAL.put(PRECIO_$79900_200MIN,
                "PqM LDI Preferencial200MIN");


        // LDI RESTO DEL MUNDO
        MAPEO_INTERNACIONAL.put(PRECIO_$40900_50MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$80900_100MIN,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$150900_200MIN,
                "");


        // ROAMING
        MAPEO_INTERNACIONAL.put(PRECIO_$11900_1GB,
                "");

        MAPEO_INTERNACIONAL.put(PRECIO_$21900_2GB,
                "");


    }

    public static String obtenerNombreCMAX(String paqueteCanal) {

        String resultado = MAPEO_CMAX.get(paqueteCanal);

        if (resultado == null) {
            throw new AssertionError(
                    "No existe mapeo CMAX para el paquete: " + paqueteCanal
            );
        }

        if (resultado.isEmpty()) {
            throw new AssertionError(
                    "El paquete existe en el mapper pero no tiene nombre CMAX configurado: "
                            + paqueteCanal
            );
        }

        return resultado;
    }


    public static String obtenerNombreCmaxInternacional(String precioSeleccionado) {

        String nombre = MAPEO_INTERNACIONAL.get(precioSeleccionado);

        if (nombre == null) {
            throw new AssertionError(
                    "No existe mapping internacional para el precio: " + precioSeleccionado
            );
        }

        if (nombre.isEmpty()) {
            throw new AssertionError(
                    "El precio internacional no tiene nombre CMAX configurado: " + precioSeleccionado
            );
        }

        return nombre;
    }
}