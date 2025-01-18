# **Foro Hub**

## **Descripción del Proyecto**

Foro Hub es una aplicación de foro en línea diseñada para gestionar tópicos relacionados con diferentes cursos. Este sistema permite registrar, listar, actualizar y eliminar tópicos, con una capa de seguridad basada en Spring Security y JWT. Los datos se almacenan en una base de datos MySQL, y las migraciones se manejan mediante Flyway.

Este proyecto forma parte del desafío final del programa de formación de Spring Boot del programa Oracle One de Alura LATAM. A través de este proyecto, se busca implementar una API REST con funcionalidades clave que cumplen con las mejores prácticas en desarrollo web backend.

---

## **Características Principales**

1. **Gestión de Tópicos**
   - **Registrar Tópicos:** Crear nuevos tópicos con título, mensaje, autor y curso.
   - **Listar Tópicos:** Obtener todos los tópicos registrados.
   - **Detalles de un Tópico:** Visualizar información específica de un tópico.
   - **Actualizar Tópicos:** Modificar datos de un tópico existente.
   - **Eliminar Tópicos:** Eliminar un tópico específico.

2. **Autenticación y Autorización**
   - Autenticación de usuarios con credenciales (correo electrónico y contraseña).
   - Generación y uso de tokens JWT para proteger las solicitudes.

3. **Persistencia de Datos**
   - MySQL como base de datos principal.
   - Migraciones automatizadas con Flyway para mantener el esquema actualizado.

4. **Migraciones**
   - Migraciones de base de datos configuradas automáticamente desde los scripts definidos en `src/main/resources/db/migration`.

---

## **Requisitos Previos**

Para ejecutar este proyecto necesitas tener instalado lo siguiente:

- **JDK 17 o superior:** Para compilar y ejecutar el código Java.
- **MySQL:** Base de datos para almacenar información.
- **Maven:** Herramienta para la gestión de dependencias y construcción del proyecto.
- **Postman/Insomnia:** Herramientas para probar los endpoints de la API.

---

## **Configuración del Proyecto**

### **1. Configuración de la Base de Datos**

Antes de ejecutar el proyecto, asegúrate de que tu base de datos MySQL esté configurada correctamente. Para este proyecto, el archivo `application.properties` se encuentra configurado de la siguiente forma:

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=root
spring.datasource.password=sql2
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración de Flyway
spring.flyway.locations=classpath:db/migration

# Configuración de JWT
jwt.secret=mySecretKey
jwt.expiration=3600000
