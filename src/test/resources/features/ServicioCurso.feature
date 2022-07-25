Feature: Servicio de cursos

  Scenario: Registro de Curso
    Given debe estar logeado "alexander@gmail.com"
    When registrar datos del curso
      | titulo                    | descripcion                            |
      | Automatizacion de pruebas | Automatizacion de pruebas con cucumber |
    Then mostrar la respuesta
    And mostrar todos los cursos
