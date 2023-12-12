package br.com.adopet.domain.abrigo;

import br.com.adopet.domain.abrigo.dto.DadosAtualizacaoAbrigo;
import br.com.adopet.domain.abrigo.dto.DadosCadastroAbrigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public Abrigo cadastraNovoAbrigo(DadosCadastroAbrigo dados) {
        Abrigo abrigo = new Abrigo(dados);
        return abrigoRepository.save(abrigo);
    }

    public Abrigo atualizaAbrigo(DadosAtualizacaoAbrigo dados) {
        Abrigo abrigo = abrigoRepository.getReferenceById(dados.id());
        if (dados.localidade() != null) {
            abrigo.setLocalidade(dados.localidade());
        }
        return abrigo;
    }

    public void excluiAbrigo(Long id) {
        Abrigo abrigo = abrigoRepository.getReferenceById(id);
        abrigo.setAtivo(false);
    }
}
