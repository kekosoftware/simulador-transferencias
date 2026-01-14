# 💰 Simulador de Transferencias Bancarias

Sistema de transferencias bancarias con validación de saldo, manejo de concurrencia y auditoría completa.

## 🚀 Características

- ✅ Gestión de cuentas bancarias
- ✅ Transferencias entre cuentas con validación de saldo
- ✅ Control de concurrencia con locks pesimistas
- ✅ Auditoría completa de todas las transacciones
- ✅ Manejo de errores con rollback automático
- ✅ API REST completa
- ✅ Tests de concurrencia

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- MySQL 8.0
- Flyway (Migraciones)
- Lombok
- JUnit 5

## 📋 Requisitos Previos

- JDK 17 o superior
- Maven 3.6+
- MySQL 8.0+

## ⚙️ Configuración

### 1. Crear base de datos MySQL

```sql
CREATE DATABASE transferencias_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Configurar credenciales

Editar `src/main/resources/application.properties`:

```properties
spring.datasource.username=tu_usuario
spring.datasource. password=tu_password
```

### 3. Compilar y ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

La aplicación estará disponible en:  `http://localhost:8080`

## 📡 Endpoints API

### Cuentas

```http
# Crear cuenta
POST /api/cuentas
Content-Type: application/json

{
  "numeroCuenta": "CTA-005",
  "titular": "Pedro Gómez",
  "saldoInicial": 15000.00,
  "moneda": "USD"
}

# Consultar cuenta
GET /api/cuentas/{id}

# Consultar saldo
GET /api/cuentas/{id}/saldo

# Listar todas las cuentas
GET /api/cuentas
```

### Transferencias

```http
# Realizar transferencia
POST /api/transferencias
Content-Type: application/json

{
  "cuentaOrigenId": 1,
  "cuentaDestinoId": 2,
  "monto": 500.00,
  "descripcion": "Pago de servicios"
}

# Consultar transferencia
GET /api/transferencias/{id}

# Listar transferencias de una cuenta
GET /api/transferencias/cuenta/{cuentaId}

# Ver historial de auditoría
GET /api/transferencias/{id}/auditoria
```

## 🧪 Tests

```bash
# Ejecutar todos los tests
mvn test

# Test de concurrencia específico
mvn test -Dtest=TransferenciaServiceConcurrencyTest
```

## 🔒 Manejo de Concurrencia

El sistema utiliza **locks pesimistas** (SELECT FOR UPDATE) para garantizar la consistencia de datos en transferencias concurrentes:

```java
@Lock(LockModeType. PESSIMISTIC_WRITE)
@Query("SELECT c FROM Cuenta c WHERE c.id = :id")
Optional<Cuenta> findByIdWithLock(@Param("id") Long id);
```

Además, implementa **control de versiones optimista** con `@Version` como respaldo. 

## 📊 Auditoría

Cada transacción registra:
- Estado inicial y final de las cuentas
- Eventos:  INICIO_TRANSFERENCIA, TRANSFERENCIA_EXITOSA, TRANSFERENCIA_FALLIDA
- Timestamp preciso
- Usuario (extensible para autenticación)
- Datos antes/después en formato JSON

## 🐛 Manejo de Errores

El sistema valida: 
- ✅ Saldo suficiente
- ✅ Cuentas activas
- ✅ Misma moneda
- ✅ Monto mayor a cero
- ✅ Cuenta origen ≠ destino

En caso de error, se hace rollback automático y se registra en auditoría.

## 📈 Escalabilidad

Para producción considerar:
- Pool de conexiones configurado
- Índices en columnas frecuentemente consultadas
- Particionamiento de tabla de auditoría
- Cache distribuido (Redis)
- Circuit breakers para resiliencia

## 👨‍💻 Autor

**KekeOS Software**

## 📄 Licencia

MIT License