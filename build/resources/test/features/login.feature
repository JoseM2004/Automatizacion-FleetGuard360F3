Feature: Login de pasajero
  Como pasajero registrado, quiero iniciar sesion con correo y contraseña,
  para acceder a mi panel y gestionar mis viajes.

  Scenario: Inicio de sesión con credenciales correctas
    // Given que quiero navegar
    // And que estoy en la página de inicio de sesión
    When intento iniciar sesión
      | username | password |
      | JoseM   | Jose3127674676    |
    Then veo el panel de pasajero

  Scenario: Intento de inicio de sesión con credenciales incorrectas
    // Given que estoy en la página de inicio de sesión
    When intento iniciar sesión con credenciales incorrectas
      | username | password |
      | Jose   | Jose312767467    |
    Then veo "Credenciales inválidas" sin indicar que campo falló