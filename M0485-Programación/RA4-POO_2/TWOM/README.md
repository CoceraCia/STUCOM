# README: This War Of Mine - Proyecto de Simulación

## Descripción

Este proyecto tiene como objetivo desarrollar un programa que simule la experiencia del videojuego *This War of Mine*. Los jugadores deben sobrevivir en un entorno de guerra, gestionando recursos, enfrentándose a enfermedades y combatiendo el hambre. Utilizaremos las estructuras y clases mencionadas a continuación para lograr una simulación realista.

## Requisitos

- Conocimiento de `ArrayList`.
- Creación de un proyecto llamado **ThisWarOfMine** con los paquetes `main` y `modelo`.
- Lenguaje: Java.

## Estructura del Proyecto

### Clase Principal: `ThisWarOfMine.java`

- **Variable Global:**

  - Una única instancia de `Casa` (global).
  - Opcional: una instancia de `Scanner`.

- **Funciones Principales:**

  1. `generateCharacters()`: Genera 4 personajes jugables con valores predefinidos.
  2. `getCharacters(jugadores)`: Muestra los personajes con índices para que el jugador elija con cuáles quiere jugar.
  3. `nuevaPartida(jugadores)`: Inicia una nueva partida. La partida termina cuando un civil muere, evaluado mediante `checkSalud(jugadores)`.
     - Subfunciones dentro de un turno:
       - `mostrarObjetos()`: Muestra los objetos de la casa.
       - `generateUbicacion()`: Genera una ubicación.
       - `escogerRoles(jugadores)`: Asigna roles a los personajes (ver apartado Turno).

### Clases

#### 1. `Personaje.java`

Atributos:

- `nombre`
- `salud` (inicia en 10).
- `hambre` (inicia en 1).
- `sueño` (inicia en 1).
- `habilidad`.
- `ArrayList<Objeto>`.

**Personajes Jugables:**

1. Arica: habilidad: **"SIGILO"**.
2. Bruno: habilidad: **"COCINERO"**.
3. Katia: habilidad: **"ELOCUENCIA"**.
4. Pavel: habilidad: **"RAPIDEZ"**.

#### 2. `Objeto.java`

Atributos:

- `tipo` (arma, comida, medicamento o componente).
- `cantidad` (cantidad del objeto).

**Sobreescribir el método ********`toString()`********:**

- Formato: `Objeto → tipo (cantidad)`.

#### 3. `Casa.java`

Atributos:

- `cama` (booleano, indica si hay una cama construida).
- `ArrayList<Objeto>` (objetos de los personajes).

Funciones privadas recomendadas:

- Mostrar los objetos disponibles en la casa.

#### 4. `Ubicacion.java`

Atributos:

- `ArrayList<Objeto>` (objetos disponibles en la ubicación).
- `peligrosidad` (1 = baja).

**Lógica:**

- Determinar la peligrosidad con un aleatorio entre 1 y el nivel del turno.
- Determinar los recursos disponibles en la ubicación:
  - Número de objetos: aleatorio entre 1 y (10 - nivel).
  - Tipos de objetos:
    - Armas: 10%.
    - Comida: 30%.
    - Medicamentos: 15%.
    - Componentes: 45%.

#### 5. Turno

En cada turno se asignan roles a los personajes mediante `escogerRoles(jugadores)`, distribuidos así:

1. **Vigilancia:** Sueño +1.
2. **Descanso:** Sueño -2.
3. **Exploración:** Sueño +2, Hambre +1.

**Lógica del Turno:**

- Elegir qué personaje realiza cada rol.
- Funciones del personaje:
  - `dormir()`: Modifica el sueño.
  - `vigilar(nivel)`: Simula eventos de asalto o comercio.
  - `explorar(ubicación)`: Selección de recursos y cálculo de daños basados en peligrosidad.

#### 6. Fin del Día

- Mover recursos recolectados a la casa.
- Incrementar en 1 el hambre de todos los personajes.
- Acciones posibles (opcional):
  - Gastar comida para reducir hambre.
  - Generar comida o medicamentos gastando componentes.
  - Crear una cama con 10 componentes.
  - Curar salud con medicamentos.
- Restar salud por hambre o sueño extremo.

### Extras

1. **Habilidades Especiales:**
   - **ELOCUENCIA:** Mejora los intercambios con comerciantes.
   - **SIGILO:** Reduce los daños por peligrosidad al explorar.
   - **RAPIDEZ:** Permite recoger hasta 7 recursos al explorar.
   - **COCINERO:** Reduce el hambre en 2 al comer.

## Instrucciones de Uso

1. Implementar las clases según las especificaciones descritas.
2. Ejecutar `ThisWarOfMine.java` como clase principal.
3. Seguir las instrucciones en consola para jugar.
