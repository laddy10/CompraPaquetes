Feature: Compras Mi Claro App

  @COMPRAS_MICLARO_01
  Scenario: Realizar la compra de un paquete por Mi Claro APP
    Given Se ingresa a la URL de CMAX


    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE A COMPRAR
    Then SELECCIONAR PAQUETE ESPECIFICO
    Then CLIC EN BOTON CONTRA SALDO
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA


    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador
