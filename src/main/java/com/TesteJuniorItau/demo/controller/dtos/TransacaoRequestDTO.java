package com.TesteJuniorItau.demo.controller.dtos;


import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}