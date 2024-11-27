package com.maratonaApi.util;

public class PassosVelocidade {

    public static float Calcula_velocidadeKm(String tempo, int distancia) {
        // Divide o tempo em partes (minutos, segundos e milissegundos)
        String[] partes = tempo.split(":");
        if (partes.length != 3) {
            throw new IllegalArgumentException("Formato de tempo inválido. Use o formato '00:00:000'.");
        }

        // Converte cada parte para números inteiros
        int minutos = Integer.parseInt(partes[0]);
        int segundos = Integer.parseInt(partes[1]);
        int milissegundos = Integer.parseInt(partes[2]);

        // Converte o tempo total para horas
        float tempoHoras = (minutos * 60 + segundos + milissegundos / 1000.0f) / 3600.0f;

        // Calcula a velocidade em km/h
        return (float) distancia / tempoHoras;
    }

    public static float Calcula_velocidadeMs(String tempo, int distancia) {
        // Divide o tempo em partes (minutos, segundos e milissegundos)
        String[] partes = tempo.split(":");
        if (partes.length != 3) {
            throw new IllegalArgumentException("Formato de tempo inválido. Use o formato '00:00:000'.");
        }

        // Converte cada parte para números inteiros
        int minutos = Integer.parseInt(partes[0]);
        int segundos = Integer.parseInt(partes[1]);
        int milissegundos = Integer.parseInt(partes[2]);

        // Converte o tempo total para segundos
        float tempoSegundos = minutos * 60 + segundos + milissegundos / 1000.0f;

        // Converte a distância de quilômetros para metros
        float distanciaMetros = distancia * 1000.0f;

        // Calcula a velocidade em m/s
        return distanciaMetros / tempoSegundos;
    }
    public static int calculaPassos(float velocidadeMs, int distanciaKm) {
        // Converte a distância de quilômetros para metros
        float distanciaMetros = distanciaKm * 1000.0f;

        // Comprimento médio de um passo humano
        final float comprimentoPasso = 0.82f;

        // Calcula o número total de passos
        int passos = Math.round(distanciaMetros / comprimentoPasso);

        return passos;
    }

}
