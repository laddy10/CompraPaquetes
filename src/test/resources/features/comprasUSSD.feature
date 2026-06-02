Feature: Compra de paquetes de datos por USSD


  ### Paquete de Datos ###

  @Compras_USSD_01
  Scenario: Realizar la compra del paquete de datos 1Dia 200MB Nav WhatsAPP
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar el tipo de paquete datos
    Then Compra del paquete datos 1Dia 200MB nav WhatsAPP
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_02
  Scenario: Realizar la compra del paquete de datos 1Dia 400MB Nav WFX
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar el tipo de paquete datos
    Then Compra del paquete datos 1Dia 400MB nav WFX
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_03
  Scenario: Realizar la compra del paquete de datos 3 Dias 800MB Nav WFX
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar el tipo de paquete datos
    Then Compra del paquete datos 3 dias 800MB nav WFX
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_04
  Scenario: Realizar la compra del paquete de datos 2 Horas Nav Ilimitada
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar el tipo de paquete datos
    Then Compra del paquete datos 2 horas nav ilimitada
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_05
  Scenario: Realizar la compra del paquete de datos 7 Dias 2GB Nav WFX
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar el tipo de paquete datos
    Then Compra del paquete datos 7 dias 2GB nav WFX
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


    ### Paquete Todo Incluido ###


  @Compras_USSD_06
  Scenario: Realizar la compra del paquete todo incluido 3 Dias 400MB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 3 dias 400MB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_07
  Scenario: Realizar la compra del paquete todo incluido 6 Dias 1.4GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 6 dias 1.4GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  @Compras_USSD_08
  Scenario: Realizar la compra del paquete todo incluido 7 Dias 2GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 7 dias 2GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_09
  Scenario: Realizar la compra del paquete todo incluido 7 Dias 10GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 7 dias 10GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_10
  Scenario: Realizar la compra del paquete todo incluido 20 Dias 7.5GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 20 dias 7.5GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_11
  Scenario: Realizar la compra del paquete todo incluido 10 Dias 3.5GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 10 dias 3.5GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_12
  Scenario: Realizar la compra del paquete todo incluido 30 Dias 12GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 30 dias 12GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_13
  Scenario: Realizar la compra del paquete todo incluido 30 Dias 18GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 30 dias 18GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_14
  Scenario: Realizar la compra del paquete todo incluido 15 Dias 20GB Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 15 dias 20GB Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_15
  Scenario: Realizar la compra del paquete todo incluido 30 Dias 30GB Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 30 dias 30GB Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_16
  Scenario: Realizar la compra del paquete todo incluido 30 Dias 80GB WFX Voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 30 dias 80GB WFX Voz
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_17
  Scenario: Realizar la compra del paquete todo incluido 6 Dias 1.4GB WFX Salud en linea 4 beneficiarios
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 6 dias 1.4GB WFX Salud en linea 4 beneficiarios
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_18
  Scenario: Realizar la compra del paquete todo incluido 3 Dias 400MB WFX Salud en linea 4 beneficiarios
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 3 dias 400MB WFX Salud en linea 4 beneficiarios
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


    ###Paquetes WIN ####


  @Compras_USSD_19
  Scenario: Realizar la compra del paquete todo incluido 7 dias 2GB Win+
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 7 dias 2GB Win
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_20
  Scenario: Realizar la compra del paquete todo incluido 10 dias 3.5GB Win
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 10 dias 3.5GB Win
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_21
  Scenario: Realizar la compra del paquete todo incluido 7 dias 10GB Win
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete todo incluido
    Then Compra del paquete todo incluido 7 dias 10GB Win
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



    ####  Paquetes de Voz ####


  @Compras_USSD_22
  Scenario: Realizar la compra del paquete de voz 1 dia 300 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete de voz
    Then Compra del paquete de voz 1 dia 300 Minutos
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_23
  Scenario: Realizar la compra del paquete de voz 2 dias 300 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete de voz
    Then Compra del paquete de voz 2 dias 300 Minutos
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  @Compras_USSD_24
  Scenario: Realizar la compra del paquete de voz 20 dias 1000 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    ## Se realiza el proceso de compra por USSD
    And cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    Then Seleccionar paquete de voz
    Then Compra del paquete de voz 20 dias 1000 Minutos
    When Se confirma el pago de la compra

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador

