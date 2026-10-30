# ScooterRental

Proyecto Maven para Apache NetBeans (Java 21). CRUD de Scooters y de Alquileres con calculo de monto, pago con
tarjeta y patrones de diseno. La explicacion y justificacion de cada patron esta en **PATRONES.md**.

Flujo: `view -> controller -> service -> repository`

| Paquete (`com.usil.scooter`) | Contenido |
|---|---|
| `singleton` | `Contexto` (**Singleton**): arma y comparte todos los objetos del sistema |
| `builder` | `ScooterBuilder`, `AlquilerBuilder`, `PagoBuilder` (**Builder**) |
| `adapter` | `PasarelaPago`, `PasarelaPagoAdapter` (**Adapter**) y `ServicioPagoExterno` (libreria de terceros simulada) |
| `repository` | `CrudRepository<T, ID>` + `ScooterRepository`, `AlquilerRepository`, `PagoRepository` (**Repository**) |
| `repository.impl` | `ScooterRepositoryImpl`, `AlquilerRepositoryImpl`, `PagoRepositoryImpl` (guardan en una lista) |
| `model` | `Scooter` (tarifa por minuto), `Alquiler` (`LocalDateTime` de inicio y fin, `calcular()`) y `Pago` |
| `service` | `ScooterService`, `AlquilerService`, `PagoService` |
| `controller` | `ScooterController`, `AlquilerController`, `PagoController` |
| `view` | `MainFrame` (menu), `ScooterFrame`, `AlquilerFrame`, `PagoFrame` (JFrame con vista Source y Design) |

Patron de arquitectura: **MVC** (`view` = Vista, `controller` = Controlador, `model` = Modelo), complementado por las capas
`service` y `repository`.

## Guia
- `docs/explicacion_desarrollo_aplicacion_consola.docx`: guia paso a paso en Word (enunciado, patrones, diagramas y todo el codigo por capas), con indice con enlaces.

## Diagramas
- `docs/diagrama_clases_modelo.png`: diagrama de clases UML del modelo (`Scooter`, `Alquiler`, `Pago`).
- `docs/diagrama_arquitectura.png`: arquitectura desde las vistas hasta el repositorio; el color de cada caja indica su grupo de patron.
- `docs/diagrama_clases_modelo.drawio` y `docs/diagrama_arquitectura.drawio`: los mismos diagramas, editables en https://app.diagrams.net (Archivo > Abrir desde > Dispositivo).

## Reglas del alquiler
- El alquiler empieza ahora (`LocalDateTime.now()`) y termina segun los minutos indicados.
- `Alquiler.calcular()`: minutos = `Duration.between(inicio, fin)`; monto = minutos x tarifa del scooter.
- Al actualizar los minutos se recalculan la fecha de fin, los minutos y el monto. Un alquiler pagado no se modifica.
- Pagar (vista **Pagos**): se elige un alquiler pendiente y se escribe una tarjeta de 16 digitos (la pasarela simulada rechaza
  otros valores). Cada pago aprobado genera un `Pago` (monto, fecha y ultimos 4 digitos de la tarjeta) y el alquiler queda pagado.
- Pagos: se pueden listar, buscar por ID y filtrar por rango de fechas. Un pago no se modifica ni se elimina.
- No se elimina un scooter que ya tiene alquileres.
- Filtros: scooters por marca; alquileres y pagos por **rango de fechas** (desde y hasta, `dd/MM/yyyy`, ambas incluidas).

Los datos viven en memoria: se pierden al cerrar la aplicacion.
