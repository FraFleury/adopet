package br.com.adopet.domain.abrigo.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAbrigo(
        @NotBlank
        String localidade) {
}
