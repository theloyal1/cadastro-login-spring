package com.example.cadastro_login.repositories;

import com.example.cadastro_login.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndPassword(String email, String password);

}
