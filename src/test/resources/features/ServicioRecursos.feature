Feature: Prueba al servicio recursos

  Scenario: Listar todos los recursos
    Given listar recursos
    When mostrar el listado de recursos
    And validar codigo de respuesta recurso "200"
    Then validar numero de registros recursos

  Scenario: Listar recurso
    Given listar recurso con id "1"
    When mostrar informacion del recurso
    And validar codigo de respuesta recurso "200"
    Then validar informacion de la consulta recurso
      | nombre   | anio | color   |
      | cerulean | 2000 | #98B2D1 |

  Scenario: Recurso no registrado
    Given listar recurso con id "50"
    Then validar codigo de respuesta recurso "404"