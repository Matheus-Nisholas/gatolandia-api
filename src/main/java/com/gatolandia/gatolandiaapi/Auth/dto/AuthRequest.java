package com.gatolandia.gatolandiaapi.Auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Credenciais utilizadas para autenticação")
public record AuthRequest(
        @Schema(description = "Nome de usuário cadastrado", example = "admin")
        @NotBlank(message = "O usuário é obrigatório")
        String username,
        @Schema(description = "Senha correspondente ao usuário", example = "admin123")
        @NotBlank(message = "A senha é obrigatória")
        String password
) {
}
