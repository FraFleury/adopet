package br.com.adopet.domain.abrigo.dto;

import br.com.adopet.domain.abrigo.Abrigo;
import br.com.adopet.domain.pet.Pet;

import java.util.List;

public record DadosListagemAbrigo(Long id, String localidade, List<Pet> pets) {

    public DadosListagemAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getLocalidade(), abrigo.getPets());
    }
}
