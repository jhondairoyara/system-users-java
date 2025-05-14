# Módulo CRUD de Usuarios en Java con MySQL

Este proyecto implementa un módulo de gestión de usuarios que realiza operaciones CRUD (crear, leer, actualizar y eliminar) conectadas a una base de datos MySQL mediante JDBC. Está desarrollado en Java con una arquitectura estructurada que separa responsabilidades entre las capas de datos, lógica y presentación.

---

## 🚀 Funcionalidades

- Listar todos los usuarios registrados.
- Insertar nuevos usuarios en la base de datos.
- Actualizar los datos de un usuario existente.
- Eliminar usuarios por ID.
- Buscar usuarios por ID.

---

## 🧱 Estructura y arquitectura

El sistema está organizado por capas:

- **Modelo (`modelo`)**: Define la entidad `Usuario`.
- **DAO (`dao`)**: Contiene la clase `UsuarioDAO` con toda la lógica de acceso a datos.
- **Presentación (`principal`)**: Clase `Main.java` con un menú interactivo para operar el sistema vía consola.

---

## 🗃️ Base de datos

El script SQL (`database.sql`) crea y relaciona las siguientes tablas:

- `departamento`: contiene los 32 departamentos de Colombia.
- `ciudad`: contiene las capitales departamentales, relacionadas con `departamento`.
- `usuario`: tabla principal del módulo, con clave foránea hacia `ciudad`.

---

## 🛠 Tecnologías utilizadas

- Java (JDK 17+)
- JDBC (Conector MySQL)
- MySQL
- IntelliJ IDEA
- Git

---

## ⚙️ Instrucciones de uso

1. Ejecutar el archivo `database.sql` en MySQL para crear la base de datos y poblarla.
2. Configurar correctamente los datos de conexión en `Conexion.java`.
3. Ejecutar `Main.java` desde un entorno como IntelliJ para acceder al menú del módulo.

---

## 📂 Contenido del repositorio

El repositorio contiene la implementación del módulo de gestión de usuarios para una aplicación de escritorio desarrollada en Java, como parte del proceso formativo del SENA. Este módulo permite realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre la tabla `usuario` en una base de datos MySQL, aplicando principios de programación orientada a objetos y acceso a datos con JDBC.

A continuación, se describen los elementos incluidos:

📁 src/ → Código fuente del proyecto (Java)
│
├── 📁 dao/ → Lógica de acceso a datos (clases DAO)
│ └── UsuarioDAO.java → Implementa operaciones CRUD con JDBC
│
├── 📁 modelo/ → Clases del modelo de datos
│ └── Usuario.java → Representa la entidad usuario
│
├── 📁 principal/ → Punto de entrada y menú del sistema
│ └── Main.java → Contiene el menú interactivo
│
├── 📁 conexion/ → Configuración de conexión a la BD
│ └── Conexion.java → Clase que establece conexión con MySQL
│
📄 database.sql → Script para crear y poblar la base de datos con usuarios, ciudades y departamentos
📄 README.md → Documento con información y guía del proyecto
📁 mysql-connector/ → Librería JDBC (MySQL Connector/J)

