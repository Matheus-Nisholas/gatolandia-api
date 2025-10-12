package com.gatolandia.gatolandiaapi.Auth;

import com.gatolandia.gatolandiaapi.Usuarios.UsuarioService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Responsável por garantir que exista um usuário administrador padrão.
 * <p>
 * Os dados de acesso podem ser configurados pelas propriedades
 * {@code admin.default-username} e {@code admin.default-password}. Caso não
 * existam usuários com o nome informado, um novo registro com a role
 * {@code ROLE_ADMIN} será criado durante o start da aplicação.
 */
@Component
public class AdminUserInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserInitializer.class);

    private final UsuarioService usuarioService;
    private final String defaultAdminUsername;
    private final String defaultAdminPassword;

    public AdminUserInitializer(UsuarioService usuarioService,
                                @Value("${admin.default-username:admin}") String defaultAdminUsername,
                                @Value("${admin.default-password:admin123}") String defaultAdminPassword) {
        this.usuarioService = usuarioService;
        this.defaultAdminUsername = defaultAdminUsername;
        this.defaultAdminPassword = defaultAdminPassword;
    }

    /**
     * Método executado após a inicialização do contexto Spring para criar o
     * usuário administrador quando ele ainda não estiver cadastrado.
     */
    @PostConstruct
    public void ensureDefaultAdminUserExists() {
        usuarioService.buscarPorUsername(defaultAdminUsername)
                .orElseGet(() -> {
                    LOGGER.info("Criando usuário administrador padrão '{}'.", defaultAdminUsername);
                    return usuarioService.registrarUsuarioComRole(defaultAdminUsername, defaultAdminPassword, "ROLE_ADMIN");
                });
    }
}

