package com.gatolandia.gatolandiaapi.common;

/**
 * Representa uma resposta padronizada para mensagens de sucesso ou erro.
 */
public record ApiMessageResponse(String code, String message) {

    public static ApiMessageResponse of(String code, String message) {
        return new ApiMessageResponse(code, message);
    }
}
