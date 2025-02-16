# Gestión de Tienda - Práctica RA7

Este proyecto es un sistema de gestión de tienda que permite administrar inventarios, ventas, roles de empleados y clientes, con funcionalidades de autenticación y pagos. Desarrollado en Java, sigue los requerimientos especificados en la práctica RA7.

## 📋 Requisitos Funcionales

1. **Eliminar límites en inventario, ventas y productos**:  
   - Las listas de productos, ventas y productos por venta ahora usan `ArrayList` para escalar dinámicamente.

2. **Eliminar productos del inventario**:  
   - Nueva opción de menú (9) para eliminar productos existentes.

3. **Roles de empleado y cliente**:  
   - **Empleado**: Requiere número de empleado y contraseña para acceder al sistema (valores fijos: N° `123`, contraseña `test`).  
   - **Cliente**: Ampliado con número de socio y saldo inicial (valor fijo: N° `456`, saldo `50.00€`).

4. **Login para empleados**:  
   - Autenticación obligatoria antes de acceder al menú principal.

5. **Sistema de pago para clientes**:  
   - El saldo del cliente se descuenta al realizar una compra. Si el saldo es insuficiente, se muestra la deuda pendiente.

## 🛠️ Estructura del Proyecto

### Diagrama de Clases (Resumen)
- **`Shop`**: Administra inventario (`ArrayList<Product>`), ventas (`ArrayList<Sale>`), y métodos para iniciar sesión y realizar ventas.  
- **`Employee`**: Hereda de `Person`, implementa `Logable` para autenticación.  
- **`Client`**: Hereda de `Person`, implementa `Payable` para gestionar pagos.  
- **`Sale`**: Contiene un cliente (`Client`), productos vendidos (`ArrayList<Product>`), y el monto total.  
- **Interfaces**:  
  - `Logable`: Método `login(int user, String password)`.  
  - `Payable`: Método `pay(Amount amount)`.

### Paquetes Principales
- `model`: Contiene clases como `Shop`, `Product`, `Employee`, `Client`, `Sale`, y `Person` (clase abstracta).  
- `main`: Interfaces `Logable` y `Payable`, y lógica de ejecución.

## 🚀 Cómo Ejecutar

1. **Requisitos**:  
   - Java JDK 11+.
   - IDE compatible con Java (Eclipse, IntelliJ, etc.).

2. **Configuración**:  
   - Clonar el repositorio:  
     ```bash
     git clone [URL-del-repositorio]
     ```
   - Importar el proyecto en tu IDE.

3. **Ejecución**:  
   - Iniciar la clase principal `Shop`.  
   - Ingresar credenciales de empleado:  
     - Número de empleado: `123`  
     - Contraseña: `test`

## ✅ Pruebas Unitarias

Se deben verificar los siguientes casos:  
1. Límites de inventario, ventas y productos en venta (más de 10 elementos).  
2. Eliminación de productos (éxito y error si no existe).  
3. Autenticación de empleados (éxito y fallos por credenciales incorrectas).  
4. Pagos de clientes (descuento de saldo y mensaje de deuda).  

Ejecutar las pruebas con JUnit o la herramienta de testing preferida.

## 📝 Notas Adicionales

- **Datos fijos para pruebas**:  
  - Empleado: `123` / `test`.  
  - Cliente: `456` (saldo inicial: 50.00€).  
- El diagrama de clases completo se encuentra en el PDF adjunto (`MP0485RA7P1_Tienda.pdf`).

## 🤝 Contribución

Las contribuciones son bienvenidas. Por favor, abre un *issue* para discutir cambios o mejoras antes de enviar un *pull request*.

## 📄 Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).
