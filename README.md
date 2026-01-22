# TaskHive - Spring Boot Task Manager

Aplicación web para la gestión de tareas (To-Do List) desarrollada con Spring Boot. El sistema permite el registro de usuarios, gestión de tareas personales y un panel de administración para moderar contenidos, usuarios y categorías. Creada para el curso de OpenWebinars del siguiente enlace https://academia.openwebinars.net/aprende/primera-web-app-spring-boot/

El proyecto implementa una arquitectura MVC clásica, seguridad basada en roles y persistencia en base de datos MySQL.

Destacar que he hecho varias modificaciones sobre el proyecto del curso, para mejorar su diseño y añadir funcionalidades adicionales que consideraba necesarias para el proyecto.

## Capturas de Pantalla

**Pantalla de Login**
<img width="1917" height="943" alt="image" src="https://github.com/user-attachments/assets/af43e2f3-d521-463f-b311-a38225887fd8" />

**Pantalla de Registro de usuarios**
<img width="1919" height="942" alt="image" src="https://github.com/user-attachments/assets/4ae8de16-fd3f-4b4e-bff9-213b6c6b2a3d" />

**Lista de Tareas - Con tareas creadas**
<img width="1916" height="940" alt="image" src="https://github.com/user-attachments/assets/638065d8-1c2d-4baa-9004-2fd95bb05725" />

**Lista de Tareas - Sin tareas creadas**
<img width="1919" height="940" alt="image" src="https://github.com/user-attachments/assets/41149c5d-615f-4c55-8642-31067eefc2ef" />

**Administrador - Ver y modificar todas las tareas de todos los usuarios**
<img width="1918" height="942" alt="image" src="https://github.com/user-attachments/assets/762e8de3-0ca3-44a3-849b-af3a734a22f6" />

**Administrador - Ver, crear y eliminar las categorías**
<img width="1918" height="941" alt="image" src="https://github.com/user-attachments/assets/4c8fab3a-017c-48ba-84ca-cc77a8d5c29d" />

**Administrador - Información de los usuarios y permitir su cambio de rol (ADMIN o USER)**
<img width="1919" height="941" alt="image" src="https://github.com/user-attachments/assets/7dbc65b5-6d51-4dc8-ac39-8fd8af463d4f" />


## Funcionalidades

El sistema cuenta con dos roles principales: **USER** y **ADMIN**.

### Funcionalidades de Usuario
- **Registro e Inicio de Sesión:** Diseño moderno con seguridad Spring Security.
- **Gestión de Tareas:** Crear, editar y eliminar tareas propias.

- **Estado de Tareas:** Marcar tareas como pendientes o completadas.
<img width="885" height="184" alt="image" src="https://github.com/user-attachments/assets/ec9dad62-6cf6-4cda-b643-222d25dead21" />
<img width="887" height="188" alt="image" src="https://github.com/user-attachments/assets/940f7396-ac14-414e-8892-081b011fda65" />

- **Categorización:** Asignar categorías y etiquetas a las tareas.

### Funcionalidades de Administrador
- **Gestión de Usuarios:** Listar todos los usuarios y gestionar sus roles.
- **Gestión Global de Tareas:** Visualización de todas las tareas del sistema con un buscador.
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
