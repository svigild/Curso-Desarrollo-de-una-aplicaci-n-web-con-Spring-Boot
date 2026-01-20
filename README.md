# TaskHive - Spring Boot Task Manager

Aplicación web para la gestión de tareas (To-Do List) desarrollada con Spring Boot. El sistema permite el registro de usuarios, gestión de tareas personales y un panel de administración para moderar contenidos, usuarios y categorías.

El proyecto implementa una arquitectura MVC clásica, seguridad basada en roles y persistencia en base de datos MySQL.

## Capturas de Pantalla

**Pantalla de Login**
![Login Split Screen](ruta/a/tu_imagen_login.png)

**Lista de Tareas (Responsive)**
![Lista Tareas](ruta/a/tu_imagen_lista.png)

## Funcionalidades

El sistema cuenta con dos roles principales: **USER** y **ADMIN**.

### Funcionalidades de Usuario
- **Registro e Inicio de Sesión:** Diseño moderno con seguridad Spring Security.
- **Gestión de Tareas:** Crear, editar y eliminar tareas propias.
- **Estado de Tareas:** Marcar tareas como pendientes o completadas.
- **Categorización:** Asignar categorías y etiquetas a las tareas.

### Funcionalidades de Administrador
- **Gestión de Usuarios:** Listar todos los usuarios y gestión de roles.
- **Gestión Global de Tareas:** Visualización de todas las tareas del sistema con buscador avanzado.
- **Gestión de Categorías:** Crear y eliminar las categorías del sistema.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security:** Autenticación y autorización.
- **Spring Data JPA:** Hibernate y MySQL.
- **Thymeleaf:** Motor de plantillas (Server-side rendering).
- **Bootstrap 5.3:** Diseño responsive y moderno.
- **Bootstrap Icons:** Iconografía vectorial.

## Configuración e Instalación

### 1. Requisitos Previos
- JDK 17 o superior.
- Maven instalado (o usar el wrapper `mvnw`).
- Servidor MySQL en ejecución.

### 2. Configuración de Base de Datos
Crea una base de datos en MySQL llamada `task_db`.
Edita `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update