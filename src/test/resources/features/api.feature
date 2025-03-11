Feature: API Testing

  @Get
  Scenario: Obtener lista de objetos
    When el usuario realiza una peticion GET
    Then la respuesta debe tener codigo 200
    Then la respuesta del GET debe contener el campo "name" con valor "Google Pixel 6 Pro"

  @Post
  Scenario: Crear un nuevo objeto en la API
    When el usuario crea un nuevo objeto con los siguientes datos:
      """
      {
         "name": "Apple MacBook Pro 20",
         "data": {
            "year": 2026,
            "price": 2331.99,
            "CPU model": "Intel Core i7",
            "Hard disk size": "2 TB"
         }
      }
      """
    Then la respuesta debe tener codigo 200
    Then la respuesta del POST debe contener el campo "name" con valor "Apple MacBook Pro 20"

  @Delete
  Scenario: Eliminar un objeto de la API
    When el usuario elimina el objeto creado
    Then la respuesta debe tener codigo 200
    And el body debe contener el campo mensaje con valor "has been deleted."

