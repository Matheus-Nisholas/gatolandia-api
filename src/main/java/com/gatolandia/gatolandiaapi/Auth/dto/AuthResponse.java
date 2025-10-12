package com.gatolandia.gatolandiaapi.Auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta contendo o token JWT gerado")
public record AuthResponse(
        @Schema(description = "Token JWT que deve ser usado no cabeçalho Authorization", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String token,
        @Schema(description = "Tipo de autenticação a ser utilizado no cabeçalho", example = "Bearer")
        String type) {
}
