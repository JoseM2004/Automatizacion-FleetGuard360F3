Feature: Creación y gestión de reservas
  Como pasajero registrado, quiero buscar viajes disponibles y reservar, para asegurar mi lugar.

  Scenario: Búsqueda de viajes con filtros válidos
    Given que estoy autenticado como pasajero
    When busco viajes
      |origen|destino|fecha|
      |Medellín|Bogotá|2025-12-01|
    Then veo una lista de viajes que coinciden con su disponibilidad de asientos