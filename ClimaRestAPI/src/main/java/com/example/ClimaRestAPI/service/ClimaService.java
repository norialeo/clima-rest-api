package com.example.ClimaRestAPI.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ClimaService {

    private final RestTemplate restTemplate;

    public ClimaService() {
        this.restTemplate = new RestTemplate();
    }

    public Map<String, Object> obterClimaBeloHorizonte() {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=-19.9208&longitude=-43.9378&current=temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m,weather_code&daily=temperature_2m_max,temperature_2m_min&timezone=America/Sao_Paulo";

        try {
            JsonNode response = restTemplate.getForObject(url, JsonNode.class);

            if (response == null) {
                throw new RuntimeException("Não foi possível obter resposta da API externa.");
            }

            JsonNode current = response.get("current");
            JsonNode daily = response.get("daily");

            Map<String, Object> dadosClima = new LinkedHashMap<>();
            dadosClima.put("cidade", "Belo Horizonte - MG");
            dadosClima.put("temperaturaAtual", current.get("temperature_2m").asDouble());
            dadosClima.put("umidadeAr", current.get("relative_humidity_2m").asInt());
            dadosClima.put("velocidadeVento", current.get("wind_speed_10m").asDouble());
            dadosClima.put("direcaoVento", current.get("wind_direction_10m").asInt());
            dadosClima.put("temperaturaMaxima", daily.get("temperature_2m_max").get(0).asDouble());
            dadosClima.put("temperaturaMinima", daily.get("temperature_2m_min").get(0).asDouble());
            dadosClima.put("descricaoCondicao", mapearCondicaoTempo(current.get("weather_code").asInt()));
            dadosClima.put("dataHoraConsulta", LocalDateTime.now().toString());

            return dadosClima;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar serviço de clima: " + e.getMessage());
        }
    }

    private String mapearCondicaoTempo(int code) {
        switch (code) {
            case 0: return "Céu limpo";
            case 1: case 2: case 3: return "Parcialmente nublado";
            case 45: case 48: return "Nevoeiro";
            case 51: case 53: case 55: return "Garoa";
            case 61: case 63: case 65: return "Chuva";
            case 80: case 81: case 82: return "Pancadas de chuva";
            case 95: case 96: case 99: return "Trovoada";
            default: return "Condição desconhecida";
        }
    }
}