Feature: Se requiere tomar evidencias de las consultas realizadas en CMAX


  @Compra_Paquete_USSD_01
  Scenario: Consultar estado de linea CMAX y comprar paquete todo incluido
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


   ## Se realiza el proceso de compra por USSD
    And   cambia al contexto movil USSD
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    When Se selecciona el tipo de paquete a comprar
    When Se realiza la compra del paquete
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


  ############################################################################################
