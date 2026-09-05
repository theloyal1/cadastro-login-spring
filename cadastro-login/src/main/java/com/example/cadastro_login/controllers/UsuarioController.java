package com.example.cadastro_login.controllers;

import com.example.cadastro_login.model.Usuario;
import com.example.cadastro_login.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/teste-mongodb")
    public String testeMongoDB() {
        usuarioRepository.count();
        return "MongoDB funcionando!";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody Usuario usuario) {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return "Email já cadastrado.";
        }
        usuarioRepository.save(usuario);
        return "Cadastro realizado com sucesso!";
    }

    @PostMapping("/login")
    public Optional<Usuario> login(@RequestBody Usuario usuario) {
        return usuarioRepository.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
    }
}
