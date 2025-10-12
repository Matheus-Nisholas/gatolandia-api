package com.gatolandia.gatolandiaapi.Auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados necessários para registrar um novo usuário")
public record RegisterRequest(
        @Schema(description = "Nome de usuário desejado", example = "novo_usuario")
        @NotBlank(message = "O usuário é obrigatório")
        @Size(min = 3, max = 100, message = "O usuário deve conter entre 3 e 100 caracteres")
        String username,
        @Schema(description = "Senha que será utilizada para autenticação", example = "senhaSegura123")
        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
        String password
) {
}
