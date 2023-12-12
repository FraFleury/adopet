package br.com.adopet.domain.abrigo.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAbrigo(
        @NotNull
        Long id,
        String localidade) {
}
