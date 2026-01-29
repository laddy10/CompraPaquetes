Feature: Se requiere tomar evidencias de las consultas realizadas en CMAX


  @Whatsapp_Compra_Paquete_Todo_Incluido_01
  Scenario: Consultar estado de linea CMAX y comprar paquete todo incluido
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


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
    And Selecciona opcion usa tu saldo


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


  @Whatsapp_Compra_Paquete_Voz_02
  Scenario: Consultar estado de linea CMAX y comprar paquete voz
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


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
    And Selecciona opcion usa tu saldo

  ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



    #############################################################################################


  @Whatsapp_Compra_Paquete_Datos_03
  Scenario: Consultar estado de linea CMAX y comprar paquete datos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


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
    And Realizar la compra de paquetes datos
    And Selecciona opcion usa tu saldo


 ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


   #############################################################################################


  @Whatsapp_Compra_Paquete_Internacional_04
  Scenario: Consultar estado de linea CMAX y comprar paquete internacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


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
    And Seleccionar el paquete internacional
    And Seleccionar el paquete de compra
    And Selecciona opcion usa tu saldo


## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


     #############################################################################################


  @Whatsapp_Compra_Paquete_Relevo_05
  Scenario: Consultar estado de linea CMAX y comprar paquete relevo
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


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
    And Ingresar al boton Selecciona paquete Relevo
    And Seleccionar el paquete de compra
    And Selecciona opcion usa tu saldo


  ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador
