# ms-notificaciones — Microservicio de Notificaciones

Microservicio correspondiente al **caso NovaBank** (Banca digital / fintech) de la **Evaluación Parcial N°2**.

| | |
|---|---|
| **Asignatura** | JVY0101 — Java: Diseño y Construcción de Soluciones Nativas en Nube |
| **Stack** | Spring Boot 3.2.5 · Java 17 · Maven Wrapper · Spring Data JPA · H2 Database |
| **Arquitectura** | Capas (Controller, Service, Repository, Model) |
| **Puerto** | 8086 |

## Responsabilidad (SRP)

Gestiona el envío y la consulta de notificaciones a los clientes de NovaBank, registrando el RUT destinatario, el canal, el mensaje, la fecha de envío y el estado (ENVIADO). Permite listar notificaciones por destinatario. Su base de datos es una **H2 en memoria** (`jdbc:h2:mem:novabank_notifications_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`), cumpliendo aislamiento de datos por dominio.

## Consola y Persistencia

Al ejecutar el servicio en el puerto `8086`, se puede acceder a la consola de persistencia H2:

- **H2 Console**: `http://localhost:8086/h2-console`
- **JDBC URL**: `jdbc:h2:mem:novabank_notifications_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`
- **Usuario**: `sa`
- **Contraseña**: *(en blanco)*

## Endpoints Principales (`/api/notificaciones`)

| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/api/notificaciones/enviar` | Registra y envía una notificación validando RUT destinatario, canal y mensaje; asigna fecha de envío y estado ENVIADO, y responde 201. |
| GET | `/api/notificaciones` | Lista todas las notificaciones registradas. |
| GET | `/api/notificaciones/{id}` | Obtiene una notificación por id; responde 404 si no existe. |
| GET | `/api/notificaciones/destinatario/{rut}` | Lista todas las notificaciones de un RUT destinatario. |

## Instrucciones de Clonación, Compilación y Ejecución Local

1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd ms-notificaciones
   ```

2. **Compilar y empaquetar con Maven Wrapper:**
   ```bash
   .\mvnw.cmd clean package -DskipTests
   ```

3. **Ejecutar el ejecutable .jar generado:**
   ```bash
   java -jar target/ms-notificaciones-1.0.0.jar
   ```

## Cómo ejecutar las pruebas

```bash
.\mvnw.cmd test
```
