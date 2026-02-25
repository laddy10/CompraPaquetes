Feature: Se requiere tomar evidencias de las consultas realizadas en CMAX


  #---------- Paquetes todo incluido ------------#


  @Compras_Whatsapp_01
  Scenario: Comprar el paq. Todo incluido 50MB + WhatsApp + 50 minutos a destinos nacionales
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 50MB WhatsApp 50 minutos a destinos nacionales
    And Selecciona opcion usa tu saldo
    And Vaciar chat

   ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_02
  Scenario: Comprar el paq. Todo incluido 400 MB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 400MB WFT Voz ilimitada nacional
    And Selecciona opcion usa tu saldo
    And Vaciar chat

   ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_03
  Scenario: Comprar el paq. Todo incluido 1.4 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 1.4 GB WFT Voz ilimitada nacional
    And Selecciona opcion usa tu saldo
    And Vaciar chat

   ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_04
  Scenario: Comprar el paq. Todo incluido 2 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional + SMS
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 2GB WFT Voz ilimitada nacional SMS
    And Selecciona opcion usa tu saldo
    And Vaciar chat

   ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_05
  Scenario: Comprar el paq. Todo incluido 3.5 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 3.5 GB WFT Voz ilimitada nacional
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_06
  Scenario: Comprar el paq. Todo incluido 10GB + Voz y SMS Ilimitados a todo destino nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 10GB Voz y SMS ilimitada nacional
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_07
  Scenario: Comprar el paq. Todo incluido 7.5 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional + SMS
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 7.5 GB WFT Voz y SMS ilimitada nacional
    And Selecciona opcion usa tu saldo
    And Vaciar chat

   ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_08
  Scenario: Comprar el paq. Todo incluido 20GB de Navegacion + Voz y SMS Ilimitados a todo destino nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 20GB de Navegacion Voz y SMS Ilimitados
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_09
  Scenario: Comprar el paq. Todo incluido 12 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 12 GB WFT Voz nacional
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_10
  Scenario: Comprar el paq. Todo incluido 30GB de Navegacion + Voz y SMS Ilimitados a todo destino nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 30 GB Voz y SMS Ilimitados
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_11
  Scenario: Comprar el paq. Todo incluido 18 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 18 GB WFT Voz ilimitada
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_12
  Scenario: Comprar el paq. Todo incluido 80 GB + WhatsApp, Facebook, Twitter + Voz ilimitada nacional
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 80 GB WFT Voz ilimitada
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_13
  Scenario: Comprar el paq. Todo incluido 400 MB + WhatsApp, Facebook, Twitter + Salud en línea 4 beneficiarios
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 400 MB WFT salud 4 beneficiarios
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_14
  Scenario: Comprar el paq. Todo incluido 1.4 GB + WhatsApp, Facebook, Twitter + Salud en línea 4 beneficiarios
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete todo incluido
    And Comprar paq todo incluido 1.4 GB WFT salud 4 beneficiarios
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador




    #---------- Paq. de Voz------------#


  @Compras_Whatsapp_15
  Scenario: Comprar el paq. Voz 300 minutos a todo operador nacional x 1 dia
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de voz
    And Comprar paq voz 300 minutos a todo operador nacional x 1 dia
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_16
  Scenario: Comprar el paq. Voz 300 minutos a todo operador nacional x 2 dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de voz
    And Comprar paq voz 300 minutos a todo operador nacional x 2 dias
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_17
  Scenario: Comprar el paq. Voz 1000 minutos a todo operador nacional x 20 dias
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de voz
    And Comprar paq voz 1000 minutos a todo operador nacional x 20 dias
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



    #---------- Paq. de datos ------------#


  @Compras_Whatsapp_18
  Scenario: Comprar el Paquete de datos de 200MB + WhatsApp
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de datos
    And Comprar paq de datos 200MB WhatsApp
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_19
  Scenario: Comprar el Paquete de datos 400MB navegación + WhatsApp, Facebook, Twitter
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de datos
    And Comprar paq de datos 400MB navegación WhatsApp Facebook Twitter
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_20
  Scenario: Comprar el Paquete de datos 800MB navegación WhatsApp Facebook Twitter
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de datos
    And Comprar paq de datos 800MB navegación WhatsApp Facebook Twitter
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_21
  Scenario: Comprar el Paquete Datos ilimitados
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de datos
    And Comprar paq datos ilimitados
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_22
  Scenario: Comprar el Paquete de datos 2 GB navegación + WhatsApp, Facebook, Twitter
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete de datos
    And Comprar paq datos 2 GB navegación WhatsApp Facebook Twitter
    And Selecciona opcion usa tu saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



    #---------- Paq. Internacionales ------------#


  @Compras_Whatsapp_23
  Scenario: Comprar el Paq. internacional LDI USA CAN PR MEX 60 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI USA CAN PR MEX
    And Comprar paq LDI USA CAN PR MEX 60 Minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_24
  Scenario: Comprar el Paq. internacional LDI USA CAN PR MEX 120 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI USA CAN PR MEX
    And Comprar paq LDI USA CAN PR MEX 120 Minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_25
  Scenario: Comprar el Paq. internacional LDI USA CAN PR MEX 240 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI USA CAN PR MEX
    And Comprar paq LDI USA CAN PR MEX 240 Minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_26
  Scenario: Comprar el Paq. LDI Sin Fronteras 50 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Sin Fronteras
    And Comprar Paq LDI Sin Fronteras 50 Minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_27
  Scenario: Comprar el Paq. LDI Sin Fronteras 100 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Sin Fronteras
    And Comprar Paq LDI Sin Fronteras 100 Minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_28
  Scenario: Comprar el Paq. LDI Sin Fronteras 200 Minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Sin Fronteras
    And Comprar Paq LDI Sin Fronteras 200 Minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_29
  Scenario: Comprar el Paq. LDI Venezuela 12 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Venezuela
    And Comprar Paq LDI Venezuela 12 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_30
  Scenario: Comprar el Paq. LDI Venezuela 30 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Venezuela
    And Comprar Paq LDI Venezuela 30 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_31
  Scenario: Comprar el Paq. LDI Preferencial 50 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Preferencial
    And Comprar Paq LDI Preferencial 50 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_32
  Scenario: Comprar el Paq. LDI Preferencial 100 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Preferencial
    And Comprar Paq LDI Preferencial 100 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_33
  Scenario: Comprar el Paq. LDI Preferencial 200 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Preferencial
    And Comprar Paq LDI Preferencial 200 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_34
  Scenario: Comprar el Paq. LDI Resto del Mundo 50 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Resto del Mundo
    And Comprar Paq LDI  Resto del Mundo 50 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_35
  Scenario: Comprar el Paq. LDI Resto del Mundo 100 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Resto del Mundo
    And Comprar Paq LDI  Resto del Mundo 100 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador



  #***************************************************************************************************

  @Compras_Whatsapp_36
  Scenario: Comprar el Paq. LDI Resto del Mundo 200 minutos
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq LDI Resto del Mundo
    And Comprar Paq LDI  Resto del Mundo 200 minutos
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


  #***************************************************************************************************

  @Compras_Whatsapp_37
  Scenario: Comprar el Paq. Roaming 1GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq. Roaming
    And Comprar Paq Roaming 1GB
    And Seleccionar opcion usar saldo
    And Vaciar chat

     ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador


     #***************************************************************************************************

  @Compras_Whatsapp_38
  Scenario: Comprar el Paq. Roaming 2GB
    Given Se ingresa a la URL de CMAX
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

   ## Se realiza el proceso de compra por WhatsApp
    And  cambia al contexto móvil
    And  abre WhatsApp
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
    And Seleccionar el tipo de paquete internacionales
    And Seleccionar Paq. Roaming
    And Comprar Paq Roaming 2GB
    And Seleccionar opcion usar saldo
    And Vaciar chat

    ## Se realiza la consulta de la compra en CMAX
    And cambia al contexto web
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador
