package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String id;
    private String usuario;
    private String contrasena;
    private String numeroWhatsApp;
    private String opcion;
    private String password;
    private String nombreUsuario;
    private String segmentacion;
    private String numero;
    private String documento;
    private String email2;
    private String password2;
    private String email;

    private String tipoPaquete;
    private String paqueteComprar;
    private String nombrePaquete;

    private String paquete;
    private String datos;
    private String minutos;
    private String precio;
    private String fecha;
    private String valorBuscado;
    private String paqueteCMAX;
    private String paqueteVoz;
    private String paqueteDatos;
    private String paqueteSMS;
    private String criterioExtra;
    private String cedula;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumeroWhatsApp() {
        return numeroWhatsApp;
    }

    public void setNumeroWhatsApp(String numeroWhatsApp) {
        this.numeroWhatsApp = numeroWhatsApp;
    }


    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }


    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSegmentacion(String segmentacion) {
        this.segmentacion = segmentacion;
    }

    public String getSegmentacion() {
        return segmentacion;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public String getPaqueteComprar() {
        return paqueteComprar;
    }

    public void setPaqueteComprar(String paqueteComprar) {
        this.paqueteComprar = paqueteComprar;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCriterioExtra() {
        return criterioExtra;
    }

    public void setCriterioExtra(String criterioExtra) {
        this.criterioExtra = criterioExtra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValorBuscado() {
        return valorBuscado;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado;
    }

    public String getPaqueteCMAX() {
        return paqueteCMAX;
    }

    public void setPaqueteCMAX(String paqueteCMAX) {
        this.paqueteCMAX = paqueteCMAX;
    }

    public String getPaqueteVoz() {
        return paqueteVoz;
    }

    public void setPaqueteVoz(String paqueteVoz) {
        this.paqueteVoz = paqueteVoz;
    }

    public String getPaqueteDatos() {
        return paqueteDatos;
    }

    public void setPaqueteDatos(String paqueteDatos) {
        this.paqueteDatos = paqueteDatos;
    }

    public String getPaqueteSMS() {
        return paqueteSMS;
    }

    public void setPaqueteSMS(String paqueteSMS) {
        this.paqueteSMS = paqueteSMS;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
