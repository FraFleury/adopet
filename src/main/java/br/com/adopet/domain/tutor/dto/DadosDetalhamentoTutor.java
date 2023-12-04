package br.com.adopet.domain.tutor.dto;

import br.com.adopet.domain.tutor.Tutor;

public record DadosDetalhamentoTutor(String nome, String email, String telefone, String cidade, String sobre) {
    public DadosDetalhamentoTutor(Tutor tutor) {
        this(tutor.getNome(), tutor.getEmail(), tutor.getTelefone(), tutor.getCidade(), tutor.getSobre());
    }
}
