Feature: Compras Mi Claro App


   #---------- Paquetes todo incluido con redes ------------#

  @COMPRAS_MICLARO_01
  Scenario: Realizar la compra del paquete Todo incluido 3 Días con Minutos Ilimitados + 400MB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 3 DÍAS CON MINUTOS ILIMITADOS  400MB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_02
  Scenario: Realizar la compra del paquete Todo Incluido 50 minutos + SMS Ilimitados + W + 50 MB 1 Dia
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 50 MINUTOS SMS ILIMITADOS W 50 MB 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_03
  Scenario: Realizar la compra del paquete Todo Incluido + WTF + 400MB+ Salud en Línea con 4 beneficiarios Vig 3 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO WTF 400MB SALUD EN LINEA CON 4 BENEFICIARIOS VIG 3 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_04
  Scenario: Realizar la compra del paquete Todo Incluido 1.4GB + WhatsApp, Facebook y Twitter + Salud en Linea 4 beneficiarios por 6 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 1.4GB WHATSAPP FACEBOOK Y TWITTER SALUD EN LINEA 4 BENEFICIARIOS POR 6 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

     ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_05
  Scenario: Realizar la compra del paquete Todo Incluido 6 Dias con Minutos Ilimitados + 1.4GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 6 DIAS CON MINUTOS ILIMITADOS 1.4GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

     ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_06
  Scenario: Realizar la compra del paquete Todo Incluido 7 Dias con Minutos Ilimitados + 2GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 7 DIAS CON MINUTOS ILIMITADOS 2GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

     ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_07
  Scenario: Realizar la compra del paquete Todo incluido 10 Dias con Minutos Ilimitados + 3.5GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 10 DIAS CON MINUTOS ILIMITADOS 3.5GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_08
  Scenario: Realizar la compra del paquete Todo incluido Voz Ilimitado + 80GB + WhatsApp Facebook Twitter,Vig 30 dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO VOZ ILIMITADO 80GB WHATSAPP FACEBOOK TWITTER VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

     ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_09
  Scenario: Realizar la compra del paquete Todo Incluido 20 Dias con Minutos Ilimitados + 7.5GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 20 DIAS CON MINUTOS ILIMITADOS 7.5GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_10
  Scenario: Realizar la compra del paquete Todo Incluido 30 Días con Minutos Ilimitados + 12GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 12GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_11
  Scenario: Realizar la compra del paquete Todo incluido 30 Días con Minutos Ilimitados + 18GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO CON REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 18GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

  ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



   #---------- Paquetes todo incluido ------------#


  @COMPRAS_MICLARO_12
  Scenario: Realizar la compra del paquete Todo Incluido 7 Dias con Minutos Ilimitados 10GB No incluye redes
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO SIN REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 7 DIAS CON MINUTOS ILIMITADOS 10GB NO INCLUYE REDES
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

     ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_13
  Scenario: Realizar la compra del paquete Todo Incluido 15 Dias con Minutos Ilimitados 20GB No incluye redes
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO SIN REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 15 DIAS CON MINUTOS ILIMITADOS 20GB NO INCLUYE REDES
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_14
  Scenario: Realizar la compra del paquete Todo Incluido 30 Dias con Minutos Ilimitados 30GB No incluye redes
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL TIPO DE PAQUETE TODO INCLUIDO SIN REDES
    Then COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 30GB NO INCLUYE REDES
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #---------- Paquetes de datos ------------#


  @COMPRAS_MICLARO_15
  Scenario: Realizar la compra del paquete Navegacion Ilimitada 2 horas
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE DATOS
    Then COMPRA DEL PAQUETE NAVEGACION ILIMITADA 2 HORAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_16
  Scenario: Realizar la compra del paquete Navegación 200MB WhatsApp 1 dia
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE DATOS
    Then COMPRA DEL PAQUETE NAVEGACION 200MB WHATSAPP 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_17
  Scenario: Realizar la compra del paquete Navegación 400MB+WhatsApp Facebook Twitter 1 dia
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE DATOS
    Then COMPRA DEL PAQUETE NAVEGACIÓN 400MB WHATSAPP FACEBOOK TWITTER 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_18
  Scenario: Realizar la compra del paquete Navegación 800MB+WhatsApp Facebook Twitter 3 Días
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE DATOS
    Then COMPRA DEL PAQUETE NAVEGACIÓN 800MB WHATSAPP FACEBOOK TWITTER 3 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_19
  Scenario: Realizar la compra del paquete Navegación 2GB+WhatsApp Facebook Twitter 7 Días
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE DATOS
    Then COMPRA DEL PAQUETE NAVEGACIÓN 2GB WHATSAPP FACEBOOK TWITTER 7 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



     #---------- Paquetes apps ------------#

  @COMPRAS_MICLARO_20
  Scenario: Realizar la compra del paquete Salud en Linea 1 beneficiario Vig 30 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE APPS
    Then COMPRA DEL PAQUETE SALUD EN LINEA 1 BENEFICIARIO VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_21
  Scenario: Realizar la compra del paquete Salud en Linea 2 beneficiario Vig 30 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE APPS
    Then COMPRA DEL PAQUETE SALUD EN LINEA 2 BENEFICIARIO VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_22
  Scenario: Realizar la compra del paquete Salud en Linea 4 beneficiario Vig 30 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE APPS
    Then COMPRA DEL PAQUETE SALUD EN LINEA 4 BENEFICIARIOS VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



    #---------- Paquetes de voz ------------#

  @COMPRAS_MICLARO_23
  Scenario: Realizar la compra del Paquete 300 Minutos 1 día
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE VOZ
    Then COMPRA DEL PAQUETE 300 MINUTOS 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_24
  Scenario: Realizar la compra del Paquete 1000 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE VOZ
    Then COMPRA DEL PAQUETE 1000 MINUTOS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_25
  Scenario: Realizar la compra del Paquete 300 Minutos 2 días
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE DE VOZ
    Then COMPRA DEL PAQUETE 300 MINUTOS 2 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



     #---------- Paquetes Relevo comunidad sorda ------------#


  @COMPRAS_MICLARO_26_INHABILITADO
  Scenario: Realizar la compra del Paquete Relevo SMS Ilimitados + WTF + 800MB 7 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE RELEVO COMUNIDAD SORDA
    Then COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 800MB 7 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @COMPRAS_MICLARO_27_INHABILITADO
  Scenario: Realizar la compra del Paquete Relevo SMS Ilimitados + WTF + 2.5GB 15 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE RELEVO COMUNIDAD SORDA
    Then COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 2.5GB 15 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @COMPRAS_MICLARO_28_INHABILITADO
  Scenario: Realizar la compra del Paquete Relevo SMS Ilimitados + WTF + 6GB 30 Dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra en la Super App
    And cambia al contexto movil mi claro app
    And ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
    Then VERIFICA VERSION DE LA SUPER APP
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
    Then SELECCIONAR EL PAQUETE RELEVO COMUNIDAD SORDA
    Then COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 6GB 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then CONFIRMACION DE LA COMPRA

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador
