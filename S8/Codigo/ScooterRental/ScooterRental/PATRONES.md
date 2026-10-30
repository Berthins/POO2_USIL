# Patrones de diseno aplicados

Proyecto: alquiler de scooters (Java, Swing, Maven). El criterio fue aplicar un patron **solo donde resuelve un problema
real** y no forzar los que no encajan. Los paquetes que contienen un patron llevan su nombre.

## Resumen

| Patron | Tipo | Paquete / clases | Problema que resuelve |
|---|---|---|---|
| MVC | **Arquitectura** | `view` (Vista), `controller` (Controlador), `model` (Modelo) | Separar la interfaz, el control y los datos |
| Singleton | Creacional | `singleton.Contexto` | Debe existir una sola instancia que cree y comparta repositorios, services y controllers |
| Builder | Creacional | `builder.ScooterBuilder`, `builder.AlquilerBuilder`, `builder.PagoBuilder` | Construir objetos validados paso a paso |
| Adapter | Estructural | `adapter.PasarelaPagoAdapter` | Usar una libreria de pago externa con una API distinta a la del sistema |
| Repository | Acceso a datos | `repository.CrudRepository`, `...Repository`, `repository.impl.*` | Separar la logica de negocio de donde se guardan los datos |

Cumple el requisito del curso: creacionales (**Singleton**, **Builder**) y estructural (**Adapter**), mas **Repository**.
**MVC** es un patron de **arquitectura** (organiza todo el sistema), no un patron de diseno de clases como los demas.

## Arquitectura
Diagramas en `docs/`: `diagrama_arquitectura.png` (componentes y patrones agrupados en creacionales, estructurales y Repository) y `diagrama_clases_modelo.png` (UML del modelo), ambos tambien en formato `.drawio` para editarlos en diagrams.net.


```
Main --> MainFrame (menu) --> Contexto (Singleton)

 V  VISTA          ScooterFrame       AlquilerFrame       PagoFrame
 C  CONTROLADOR    ScooterController  AlquilerController  PagoController
    SERVICIO       ScooterService     AlquilerService     PagoService  ------>  [ ZONA ADAPTER ]
    BUILDERS       ScooterBuilder     AlquilerBuilder     PagoBuilder          PasarelaPago
    REPOSITORIO    ScooterRepository  AlquilerRepository  PagoRepository       PasarelaPagoAdapter
                   (+ Impl)           (+ Impl)            (+ Impl)             ServicioPagoExterno
                           todas extienden CrudRepository                      (libreria de terceros)
 M  MODELO         Scooter            Alquiler            Pago

V, C, M = partes del patron de arquitectura MVC. Contexto (Singleton) crea y conecta todo y lo entrega por constructor.
Un controller puede usar el service de otra entidad para cargar datos: AlquilerController usa ScooterService (lista de scooters) y
PagoController usa AlquilerService (lista de alquileres pendientes de pago).
```

---

## MVC (patron de arquitectura)

**Que es.** Un patron de **arquitectura**: divide la aplicacion en tres partes con responsabilidades distintas. Modelo (los datos y
sus reglas), Vista (lo que ve el usuario) y Controlador (recibe lo que hace el usuario y coordina).

**Donde esta.**
- **Modelo (M):** paquete `model` (`Scooter`, `Alquiler`, `Pago`).
- **Vista (V):** paquete `view` (`MainFrame`, `ScooterFrame`, `AlquilerFrame`, `PagoFrame`), ventanas Swing.
- **Controlador (C):** paquete `controller` (`ScooterController`, `AlquilerController`, `PagoController`). Cada uno trabaja con el service de
  su entidad y, si necesita cargar datos relacionados, con el de otra (`AlquilerController` + `ScooterService`, `PagoController` + `AlquilerService`).

**Por que se justifica.** Las ventanas no contienen logica de negocio ni acceden a los datos: le piden todo a su controller. Se puede cambiar una
ventana sin tocar las reglas, y las reglas se pueden probar sin abrir una ventana.

**Complemento: arquitectura en capas.** MVC solo define V, C y M. La logica de negocio vive en `service` y el acceso a datos en `repository`
(patron Repository), de modo que el flujo completo es vista -> controller -> service -> repository.

---

## 1. Singleton (creacional)

**Que es.** Garantiza que una clase tenga una unica instancia y ofrece un punto de acceso a ella.

**Donde esta.** `singleton.Contexto`: constructor privado, instancia `static final` y `getInstancia()`.

**Por que se justifica.** Los repositorios guardan los datos en una lista. Si cada vista creara su propio repositorio, cada una veria
datos distintos. `Contexto` crea **una sola vez** cada repositorio, service y controller, y las vistas comparten esos mismos
objetos. Simula el contenedor de Spring (scope singleton) con inyeccion de dependencias por constructor.

```java
private static final Contexto INSTANCIA = new Contexto();
public static Contexto getInstancia() { return INSTANCIA; }
```

**Limitacion.** El Singleton es estado global y dificulta las pruebas. Se acepta porque `Contexto` es el unico punto de acceso y
solo lo usa `MainFrame`; el resto de las clases recibe lo que necesita por constructor.

---

## 2. Builder (creacional)

**Que es.** Construye un objeto con llamadas encadenadas y valida los datos antes de crearlo.

**Donde esta.** `builder.ScooterBuilder`, `builder.AlquilerBuilder` y `builder.PagoBuilder` (uno por entidad del modelo).

**Por que se justifica.** Un `Alquiler` necesita scooter, cliente y minutos, y calcula su fecha de fin. Un `Pago` toma el monto del
alquiler, la fecha actual y guarda solo los ultimos 4 digitos de la tarjeta. Cada builder concentra esas reglas y validaciones
(cliente vacio, minutos menores o iguales a cero, tarifa invalida, alquiler o tarjeta ausentes) en un solo lugar, y el codigo que lo
usa se lee claro.

```java
Alquiler alquiler = new AlquilerBuilder().scooter(scooter).cliente(cliente).minutos(30).build();
Pago pago = new PagoBuilder().alquiler(alquiler).tarjeta("4111111111111111").build();   // tarjeta: **** 1111
```

---

## 3. Adapter (estructural)

**Que es.** Convierte la interfaz de una clase existente en la interfaz que el sistema espera.

**Donde esta.** Paquete `adapter`:
- `PasarelaPago` (interfaz objetivo): `cobrar(double monto, String tarjeta)`.
- `ServicioPagoExterno` (clase adaptada): simula una libreria de terceros que **no se puede modificar**. Su API es distinta:
  recibe centimos (`long`) y responde con un codigo (`0` aprobado, `1` tarjeta invalida, `2` monto invalido).
- `PasarelaPagoAdapter`: implementa `PasarelaPago` y traduce hacia `ServicioPagoExterno`.

**Por que se justifica.** El sistema quiere decir `cobrar(15.50, tarjeta)` y obtener una excepcion si falla. La libreria externa habla en
centimos y codigos. El adapter hace esa traduccion en una sola clase; si manana se cambia de proveedor de pagos, solo se escribe
otro adapter y `PagoService` no cambia.

**En el diagrama** el Adapter se dibuja en una **zona propia** (a la derecha) porque no es una capa de la aplicacion: es la frontera con una
libreria externa y solo `PagoService` lo usa. Por eso no se confunde con los services ni con los builders.

```java
int codigo = servicioExterno.procesarTransaccion(tarjeta.trim(), Math.round(monto * 100));
if (codigo == 1) throw new IllegalArgumentException("Tarjeta invalida: escriba 16 digitos.");
```

---

## 4. Repository

**Que es.** Un objeto que oculta como se guardan y se leen los datos. El resto del sistema pide y guarda entidades sin saber si estan en
una lista, un archivo o una base de datos.

**Donde esta.**
- `CrudRepository<T, ID>`: operaciones generales `crear`, `buscarPorId`, `existePorId`, `listar`, `actualizar`, `eliminar`.
- `ScooterRepository` y `AlquilerRepository`: extienden el CRUD y agregan solo su consulta propia
  (`buscarPorMarca`, `buscarPorFecha(desde, hasta)`, `existePorScooterId`), como en Spring Data. `PagoRepository` agrega `buscarPorFecha`.
- `repository.impl.*`: una clase por entidad que implementa todo y guarda en una lista.

**Por que se justifica.** Los services dependen de la interfaz, no de la lista. Si luego se quiere guardar en un archivo o en MySQL se
escribe otra clase que implemente la misma interfaz, y los services, controllers y vistas no cambian.

```java
public interface ScooterRepository extends CrudRepository<Scooter, Integer> {
    List<Scooter> buscarPorMarca(String marca);
}
```

---

## Flujo completo: pagar un alquiler

1. `PagoFrame` carga el combo con los alquileres pendientes: `PagoController` se los pide a `AlquilerService.listarPendientes()`.
   El usuario elige uno, escribe la tarjeta y pulsa **Pagar**.
2. `PagoFrame` llama a `PagoController.pagar`, que llama a `PagoService.pagar`.
3. `PagoService` busca el alquiler con `AlquilerService` (que usa `AlquilerRepository`, **Repository**) y verifica que no este pagado.
4. `PagoService` cobra con `PasarelaPago`, cuya implementacion es `PasarelaPagoAdapter` (**Adapter**), que llama a `ServicioPagoExterno`.
5. Si el cobro es aprobado, guarda el `Pago` (construido con `PagoBuilder`) en `PagoRepository` y le pide a `AlquilerService` que marque el alquiler como pagado.
6. Todos esos objetos fueron creados por `Contexto` (**Singleton**); el alquiler se construyo con `AlquilerBuilder` y el pago con `PagoBuilder` (**Builder**).

## Patrones evaluados y descartados (para no forzarlos)

| Patron | Por que se descarto | Cuando si tendria sentido |
|---|---|---|
| **Factory Method** | Solo hay una implementacion de cada repositorio y de la pasarela, asi que no hay nada que decidir. Un metodo `crear...()` que siempre devuelve la misma clase solo agregaria codigo. | Si hubiera varias implementaciones (lista, archivo, MySQL) y se eligiera una segun la configuracion. |
| **Facade** | Cada controller usa uno o dos services. Un facade seria una clase que reenvia llamadas sin simplificar nada. | Si una operacion coordinara tres o mas subsistemas en orden y con rollback (por ejemplo alquilar con cliente, promocion, comprobante y notificacion). |
| **Decorator** | Fuera del alcance acordado para el curso. | Para apilar descuentos o recargos sobre la tarifa. |

## Guion corto para exponer
1. Mostrar la arquitectura (diagrama de arriba): MVC como patron de arquitectura y los paquetes que llevan el nombre del patron.
2. Repository: `CrudRepository` y `ScooterRepositoryImpl`; la lista se puede cambiar sin tocar el resto.
3. Builder: `AlquilerBuilder` y sus validaciones.
4. Singleton: abrir `Contexto` y mostrar que las vistas comparten los mismos objetos.
5. Adapter: comparar `PasarelaPago` con `ServicioPagoExterno` y mostrar la traduccion en `PasarelaPagoAdapter`.
6. Mencionar los patrones descartados y por que.
7. Demo: registrar un scooter, alquilarlo, ir a **Gestionar pagos**, pagar con una tarjeta invalida (rechazo) y con 16 digitos (aprobado), y ver el pago en la tabla.
