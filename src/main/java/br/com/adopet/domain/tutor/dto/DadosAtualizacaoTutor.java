package br.com.adopet.domain.tutor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTutor(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String senha,
        String telefone,
        String cidade,
        String sobre
) {
}
