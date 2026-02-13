package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JsonDataProvider {

    private static JsonObject datosJson;
    private static List<User> usuarios;
    private static int indiceActual = 0;
    private static final String JSON_PATH = "src/test/resources/config/datos.json";

    public static void cargarDatos() {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(JSON_PATH)));
            datosJson = new Gson().fromJson(contenido, JsonObject.class);
            usuarios = new ArrayList<>();

            if (datosJson.has("usuarios")) {
                // Múltiples usuarios
                JsonArray arrayUsuarios = datosJson.getAsJsonArray("usuarios");
                for (int i = 0; i < arrayUsuarios.size(); i++) {
                    usuarios.add(mapearUsuario(arrayUsuarios.get(i).getAsJsonObject()));
                }
                System.out.println("✅ JSON cargado: " + usuarios.size() + " usuarios");
            } else {
                // Usuario único
                usuarios.add(mapearUsuario(datosJson));
                System.out.println("✅ JSON cargado: 1 usuario");
            }
        } catch (IOException e) {
            throw new RuntimeException("❌ Error JSON: " + JSON_PATH, e);
        }
    }

    /**
     * Obtiene el usuario actual
     */
    public static User getUser() {
        if (usuarios == null || usuarios.isEmpty()) cargarDatos();
        return usuarios.get(indiceActual);
    }

    /**
     * Obtiene usuario por índice
     */
    public static User getUser(int indice) {
        if (usuarios == null || usuarios.isEmpty()) cargarDatos();
        if (indice >= usuarios.size()) {
            System.out.println("⚠️ Índice " + indice + " fuera de rango, usando 0");
            indice = 0;
        }
        indiceActual = indice;
        return usuarios.get(indice);
    }

    /**
     * Obtiene usuario para consulta inicial
     */
    public static User getUserConsultaInicial() {
        return getUser(0);
    }

    /**
     * Obtiene usuario para compra (puede ser el mismo u otro)
     */
    public static User getUserCompra() {
        return usuarios.size() > 1 ? getUser(1) : getUser(0);
    }

    /**
     * Total de usuarios disponibles
     */
    public static int totalUsuarios() {
        if (usuarios == null) cargarDatos();
        return usuarios.size();
    }

    private static User mapearUsuario(JsonObject datos) {
        User user = new User();

        user.setUsuario(get(datos, "usuario"));
        user.setContrasena(get(datos, "contrasena"));
        user.setNumero(get(datos, "numero"));
        user.setEmail(get(datos, "email"));
        user.setCedula(get(datos, "cedula"));
        user.setPassword(get(datos, "password"));
        user.setNombreUsuario(get(datos, "nombreUsuario"));
        user.setNumeroWhatsApp(get(datos, "numeroWhatsApp"));
        user.setTipoPaquete(get(datos, "tipoPaquete"));
        user.setPaqueteComprar(get(datos, "paqueteComprar"));
        user.setNombrePaquete(get(datos, "nombrePaquete"));
        user.setPrecio(get(datos, "precio"));
        user.setPaquete(get(datos, "paquete"));

        // Fecha siempre HOY
        user.setFecha(obtenerFechaHoy());

        user.setValorBuscado(get(datos, "valorBuscado"));
        user.setPaqueteCMAX(get(datos, "paqueteCMAX"));
        user.setCriterioExtra(get(datos, "criterioExtra"));

        return user;
    }

    /**
     * Genera fecha HOY en formato CMAX: dd-MMM-yyyy (Ej: 09-feb-2026)
     */
    public static String obtenerFechaHoy() {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MMM-yyyy", new Locale("es", "ES"));
        return LocalDate.now().format(formatter).toLowerCase();
    }

    private static String get(JsonObject obj, String key) {
        return obj.has(key) && !obj.get(key).isJsonNull()
                ? obj.get(key).getAsString() : "";
    }

    public static void recargar() {
        datosJson = null;
        usuarios = null;
        indiceActual = 0;
        cargarDatos();
    }
}