package com.gatolandia.gatolandiaapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração central do SpringDoc para gerar a documentação do Swagger.
 * <p>
 * Aqui são definidas as informações básicas da API e o esquema de autenticação
 * utilizado (Bearer Token com JWT). Estas informações aparecem automaticamente
 * na interface do Swagger UI e permitem que os consumidores da API realizem
 * chamadas autenticadas diretamente pela documentação.
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Gatolândia API",
                version = "1.0",
                description = "API para gerenciamento de gatos e seus donos na plataforma Gatolândia.",
                contact = @Contact(
                        name = "Equipe Gatolândia",
                        email = "contato@gatolandia.com"
                )
        ),
        security = {@SecurityRequirement(name = "bearerAuth")}
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
    // A configuração é declarativa; não são necessários beans adicionais neste momento.
}

