Feature: Creación y gestión de reservas
  Como pasajero registrado, quiero buscar viajes disponibles y reservar, para asegurar mi lugar.

  Scenario: Búsqueda de viajes con filtros válidos
    Given que estoy autenticado como pasajero
    When busco viajes
      |origen|destino|fecha|
      |Medellín|Bogotá|2025-12-02|
    Then veo una lista de viajes que coinciden con su disponibilidad de asientos


  Scenario: Reserva de un viaje con cupo disponible
    Given que selecciono un viaje con cupo
      |origen|destino|fecha|
      |Medellín|Bogotá|2025-11-29|
    When confirmo la reserva
    Then el sistema verifica cupos, bloquea asientos y crea la reserva

  Scenario: Visualización de viaje sin cupo en resultados
    Given un viaje sin cupo
      |origen|destino|fecha|
      |Cali|Montería|2025-12-05|
    When aparece en resultados
    Then se muestra con estado Agotado y el botón Reservar deshabilitado