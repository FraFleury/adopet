package br.com.adopet.domain.tutor.dto;

import br.com.adopet.domain.tutor.Tutor;

public record DadosListagemTutor(Long id, String nome, String email) {

    public DadosListagemTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}
