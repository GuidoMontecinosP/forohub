CREATE TABLE usuario_perfil (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                usuario_id BIGINT,
                                perfil_id BIGINT,
                                CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
                                CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);
