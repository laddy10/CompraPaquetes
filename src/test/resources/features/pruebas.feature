Feature: Se requiere tomar evidencias de las consultas realizadas en CMAX

  @Pruebas
  Scenario: Consulta inicial del estado de la linea en CMAX
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
   # When Se valida el resumen de la cuenta para el SC
   # When Se validan las ofertas activas en consulta inicial
   # When Se validan las cuentas dedicadas
   # When Se validan los acumuladores de uso
    ## Se realiza el proceso de compra por WhatsApp
    And   cambia al contexto móvil
    And   abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete
    And Realizar la compra del paquete de voz
   # And Selecciona opcion usa tu saldo
    #Then Validar la notificacion de la compra



  @Whatsapp_Compra_Paquete_Todo_Incluido_PRUEBA
  Scenario: Consulta inicial del estado de la linea en CMAX
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
   # When Se valida el resumen de la cuenta para el SC
   # When Se validan las ofertas activas en consulta inicial
   # When Se validan las cuentas dedicadas
   # When Se validan los acumuladores de uso
    ## Se realiza el proceso de compra por WhatsApp
    And   cambia al contexto móvil
    And   abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete
    And Realizar la compra del paquete todo incluido
     # And Selecciona opcion usa tu saldo
    #Then Validar la notificacion de la compra
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el historial de contrato
    When Se validan los datos de compra



