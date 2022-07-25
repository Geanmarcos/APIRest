Feature: Prueba al servicio de registro

  Scenario: Crear registro
    Given Que no exista un registro
    When Realizar la creacion de registros
    |correo|contrasenia|codigo|
    |eve.holt@reqres.in|Geanmarcos123dasdxd|200|
    And Validar codigo de respuesta "200"
    Then Mostrar los datos del registro