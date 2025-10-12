package com.gatolandia.gatolandiaapi.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

@Configuration
public class DatabaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource(DataSourceProperties properties) {
        applyDatabaseUrlFromEnvironment(properties);
        return properties.initializeDataSourceBuilder().build();
    }

    private void applyDatabaseUrlFromEnvironment(DataSourceProperties properties) {
        if (StringUtils.hasText(properties.getUrl()) && properties.getUrl().startsWith("jdbc:")) {
            return;
        }

        String rawDatabaseUrl = StringUtils.hasText(properties.getUrl())
                ? properties.getUrl()
                : System.getenv("DATABASE_URL");
        if (!StringUtils.hasText(rawDatabaseUrl)) {
            return;
        }

        String fallbackUsername = StringUtils.hasText(properties.getUsername())
                ? properties.getUsername()
                : System.getenv("DATABASE_USERNAME");
        String fallbackPassword = StringUtils.hasText(properties.getPassword())
                ? properties.getPassword()
                : System.getenv("DATABASE_PASSWORD");

        try {
            DatabaseConnectionDetails connectionDetails = parseDatabaseUrl(rawDatabaseUrl, fallbackUsername, fallbackPassword);
            properties.setUrl(connectionDetails.jdbcUrl());
            if (!StringUtils.hasText(properties.getUsername()) && connectionDetails.username() != null) {
                properties.setUsername(connectionDetails.username());
            }
            if (!StringUtils.hasText(properties.getPassword()) && connectionDetails.password() != null) {
                properties.setPassword(connectionDetails.password());
            }
        } catch (IllegalArgumentException ex) {
            LOGGER.warn("Não foi possível interpretar o valor de DATABASE_URL. Usando configuração padrão.", ex);
        }
    }

    private DatabaseConnectionDetails parseDatabaseUrl(String databaseUrl, String fallbackUsername, String fallbackPassword) {
        String normalizedUrl = databaseUrl;
        if (databaseUrl.startsWith("postgres://")) {
            normalizedUrl = "postgresql://" + databaseUrl.substring("postgres://".length());
        } else if (databaseUrl.startsWith("postgresql://")) {
            normalizedUrl = databaseUrl;
        } else if (databaseUrl.startsWith("jdbc:")) {
            return new DatabaseConnectionDetails(databaseUrl, fallbackUsername, fallbackPassword);
        }

        URI uri;
        try {
            uri = new URI(normalizedUrl);
        } catch (URISyntaxException ex) {
            throw new IllegalArgumentException("DATABASE_URL inválida", ex);
        }

        String userInfo = uri.getUserInfo();
        String[] userInfoParts = null;
        if (StringUtils.hasText(userInfo)) {
            userInfoParts = userInfo.split(":", 2);
            if (userInfoParts.length != 2) {
                throw new IllegalArgumentException("DATABASE_URL precisa conter usuário e senha separados por ':'");
            }
        }

        String host = Objects.requireNonNull(uri.getHost(), "DATABASE_URL precisa conter o host");
        int port = uri.getPort() > -1 ? uri.getPort() : 5432;
        String path = uri.getPath();
        if (!StringUtils.hasText(path)) {
            throw new IllegalArgumentException("DATABASE_URL precisa conter o nome do banco de dados");
        }

        StringBuilder jdbcUrl = new StringBuilder("jdbc:postgresql://")
                .append(host)
                .append(":")
                .append(port)
                .append(path);

        if (StringUtils.hasText(uri.getQuery())) {
            jdbcUrl.append("?").append(uri.getQuery());
        }

        String username = userInfoParts != null ? userInfoParts[0] : fallbackUsername;
        String password = userInfoParts != null ? userInfoParts[1] : fallbackPassword;

        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            throw new IllegalArgumentException("Credenciais do banco de dados não foram definidas");
        }

        return new DatabaseConnectionDetails(jdbcUrl.toString(), username, password);
    }

    private record DatabaseConnectionDetails(String jdbcUrl, String username, String password) {
    }
}
