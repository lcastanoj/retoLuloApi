Feature: API Testing for Employee Endpoints

  @Get
  Scenario: Obtener lista de empleados
    Given que el usuario tiene acceso a la API
    When el usuario realiza una peticion GET a empleados
    Then la respuesta debe tener codigo 200
    And el body debe contener el campo "status" con valor "success"
