package com.mateusrangel.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigApiKey {

    private final Properties properties = new Properties();

    private String getKeyFromProperties() {
        try (InputStream dados = ConfigApiKey.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (dados == null) {
                throw new IOException("Arquivo application.properties não encontrado no classpath.");
            }

            properties.load(dados);

            String apiKey = properties.getProperty("weather.api.key");

            if (apiKey == null || apiKey.trim().isEmpty()) {
                throw new IllegalStateException("A propriedade 'weather.api.key' não está configurada ou está vazia.");
            }

            return apiKey.trim();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo de configuração.", e);
        }
    }

    public String getApiKey() {
        return getKeyFromProperties();
    }
}