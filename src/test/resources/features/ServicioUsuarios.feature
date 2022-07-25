@todoslosservicios
Feature: Pruebas al servicio usuarios

  @metodoget
  Scenario: Listar todos los usuarios
    Given listar usuarios
    When mostrar el listado de usuarios
    And validar codigo de respuesta "200"
    Then validar numero de registros
  @metodoget
  Scenario: Mostrar Usuario
    Given listar usuario con id "3"
    When mostrar informacion del usuario
    And validar codigo de respuesta "200"
    Then validar informacion de la consulta
      | email               | nombre | apellido |
      | emma.wong@reqres.in | Emma   | Wong     |

  @metodoget
  Scenario: Usuario no registrado
    Given listar usuario con id "50"
    Then validar codigo de respuesta "404"

  @metodopost
  Scenario: Crear usuario
    Given que no existe usuario registrado
    When registrar datos del usuario
      | nombre     | puesto | codigo |
      | Geanmarcos | QA     | 201    |
      | Antonio    | QA     | 201    |
    And validar codigo de respuesta "201"
    Then mostrar los datos del registro

  @metodoput
  Scenario: Actualizar usuario
    Given que el usuario este registrado
    When actualizar datos del usuario
      | id | nombre     | puesto | codigo |
      | 3  | Geanmarcos | QA     | 200    |
    And validar codigo de respuesta "200"
    Then mostrar los datos del registro

  @metodopatch
  Scenario: Actualizar usuario con patch
    Given que el usuario este registrado
    When actualizar datos del usuario Vdos
      | id | nombre  | puesto | codigo |
      | 4  | Antonio | QA     | 200    |
    And validar codigo de respuesta "200"
    Then mostrar los datos del registro
