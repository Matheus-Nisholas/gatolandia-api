package com.gatolandia.gatolandiaapi.Auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "O usuário é obrigatório")
        @Size(min = 3, max = 100, message = "O usuário deve conter entre 3 e 100 caracteres")
        String username,
        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
        String password
) {
}
