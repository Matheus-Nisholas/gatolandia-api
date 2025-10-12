package com.gatolandia.gatolandiaapi.Usuarios;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra um novo usuário com role padrão de {@code ROLE_USER}.
     *
     * @param username nome do usuário
     * @param senha    senha em texto plano que será codificada
     * @return usuário persistido
     */
    public UsuarioModel registrarUsuario(String username, String senha) {
        return registrarUsuarioComRole(username, senha, "ROLE_USER");
    }

    /**
     * Registra um usuário permitindo definir a role desejada.
     *
     * @param username nome do usuário
     * @param senha    senha em texto plano que será codificada
     * @param role     permissão que o usuário terá na aplicação
     * @return usuário persistido
     */
    public UsuarioModel registrarUsuarioComRole(String username, String senha, String role) {
        if (usuarioRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Usuário já cadastrado");
        }

        UsuarioModel usuario = UsuarioModel.builder()
                .username(username)
                .password(passwordEncoder.encode(senha))
                .role(role)
                .build();

        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
