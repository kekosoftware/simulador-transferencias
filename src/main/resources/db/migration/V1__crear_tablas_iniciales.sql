-- Tabla de Cuentas
CREATE TABLE cuentas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
    titular VARCHAR(100) NOT NULL,
    saldo DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    moneda VARCHAR(3) DEFAULT 'USD',
    activa BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT DEFAULT 0,
    INDEX idx_numero_cuenta (numero_cuenta),
    INDEX idx_activa (activa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de Transacciones
CREATE TABLE transacciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL,
    cuenta_origen_id BIGINT,
    cuenta_destino_id BIGINT,
    monto DECIMAL(15,2) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    descripcion TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMP NULL,
    FOREIGN KEY (cuenta_origen_id) REFERENCES cuentas(id),
    FOREIGN KEY (cuenta_destino_id) REFERENCES cuentas(id),
    INDEX idx_estado (estado),
    INDEX idx_created_at (created_at),
    INDEX idx_cuenta_origen (cuenta_origen_id),
    INDEX idx_cuenta_destino (cuenta_destino_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de Auditoría
CREATE TABLE auditoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaccion_id BIGINT,
    evento VARCHAR(50) NOT NULL,
    datos_antes JSON,
    datos_despues JSON,
    usuario VARCHAR(100),
    ip_address VARCHAR(45),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (transaccion_id) REFERENCES transacciones(id),
    INDEX idx_transaccion (transaccion_id),
    INDEX idx_evento (evento),
    INDEX idx_timestamp (timestamp)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Datos de prueba
INSERT INTO cuentas (numero_cuenta, titular, saldo, moneda) VALUES
('CTA-001', 'Juan Pérez', 10000.00, 'USD'),
('CTA-002', 'María García', 5000.00, 'USD'),
('CTA-003', 'Carlos López', 15000.00, 'USD'),
('CTA-004', 'Ana Martínez', 20000.00, 'USD');