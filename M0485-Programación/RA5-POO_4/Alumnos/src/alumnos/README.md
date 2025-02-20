# Registro de Alumnos - Java

## Descripción

Este proyecto es un programa en Java que funciona como un administrador de archivos y directorios para gestionar el registro de alumnos de un instituto. Utiliza Streams y Buffers para la lectura y escritura de información, permitiendo realizar las siguientes acciones:

- Agregar un nuevo alumno al registro.
- Mostrar la lista de alumnos registrados.
- Eliminar un alumno del registro por su DNI.
- Buscar un alumno por su DNI.
- Salir del programa.

## Requisitos

- Java 8 o superior.
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse o NetBeans.

## Estructura del Proyecto

```
📂 RegistroAlumnos
│── 📄 Alumno.java       # Clase que representa a un alumno
│── 📄 RegistroAlumnos.java  # Clase principal con el menú de opciones
│── 📄 FileManager.java  # Libreria para la gestion de archivos
│── 📄 register/register.txt  # Archivo donde se almacenan los datos de los alumnos
```

## Implementación

### Clase `Alumno`

La clase `Alumno` representa a un estudiante y contiene los siguientes atributos:

- `nombre`: String
- `apellido`: String
- `edad`: int
- `curso`: String
- `dni`: String

### Clase `RegistroAlumnos`

La clase `RegistroAlumnos` contiene el método `main` y maneja la interacción con el usuario a través de un menú de opciones.

## Funcionalidades

### 1. Agregar un nuevo alumno

- Se solicita al usuario ingresar los datos del alumno.
- Se valida que el DNI no esté duplicado.
- Se almacena la información en el archivo `registro.txt`.

### 2. Mostrar la lista de alumnos

- Se lee el contenido de `registro.txt`.
- Se muestran los datos de cada alumno en pantalla.

### 3. Eliminar un alumno

- Se muestra el listado de alumnos.
- Se solicita el DNI del alumno a eliminar.
- Se actualiza el archivo `registro.txt`, eliminando la entrada correspondiente.

### 4. Buscar un alumno por DNI

- Se solicita el DNI del alumno.
- Se busca en `registro.txt` y se muestran sus datos si existe.

### 5. Salir del programa

- Se asegura el correcto cierre del archivo.

## Validaciones y Gestión de Errores

- Manejo de archivos con `BufferedReader` y `BufferedWriter`.
- Validación de entradas para evitar duplicados.
- Gestión de excepciones para evitar fallos en la lectura y escritura.

## Ejecución

Compila y ejecuta el programa con:

```
javac RegistroAlumnos.java
java RegistroAlumnos
```

## Contribuciones

Si deseas contribuir, haz un **fork** del repositorio, crea una rama con tus cambios y envía un **pull request**.

## Licencia

Este proyecto está bajo la licencia MIT.

