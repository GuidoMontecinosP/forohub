CREATE TABLE curso (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       categoria VARCHAR(100) NOT NULL
);

CREATE TABLE perfil (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         correo_electronico VARCHAR(100) UNIQUE NOT NULL,
                         contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE topico (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(100) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(50) DEFAULT 'ABIERTO',
                        autor_id BIGINT NOT NULL,
                        curso_id BIGINT NOT NULL,
                        FOREIGN KEY (autor_id) REFERENCES usuario (id),
                        FOREIGN KEY (curso_id) REFERENCES curso (id)
);

CREATE TABLE respuesta (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           mensaje TEXT NOT NULL,
                           fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           solucion BOOLEAN DEFAULT FALSE,
                           autor_id BIGINT NOT NULL,
                           topico_id BIGINT NOT NULL,
                           FOREIGN KEY (autor_id) REFERENCES usuario (id),
                           FOREIGN KEY (topico_id) REFERENCES topico (id)
);
