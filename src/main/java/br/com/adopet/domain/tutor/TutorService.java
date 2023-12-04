package br.com.adopet.domain.tutor;

import br.com.adopet.domain.ValidacaoException;
import br.com.adopet.domain.tutor.dto.DadosAtualizacaoTutor;
import br.com.adopet.domain.tutor.dto.DadosCadastroTutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor cadastraNovoTutor(DadosCadastroTutor dados) {
        if (emailExiste(dados.email())) {
            throw new ValidacaoException("Email já cadastrado.");
        }

        Tutor tutor = new Tutor();
        tutor.setNome(dados.nome());
        tutor.setEmail(dados.email());
        tutor.setSenha(passwordEncoder.encode(dados.senha()));
        tutor.setAtivo(true);

        return tutorRepository.save(tutor);
    }

    public Tutor atualizaTutor(DadosAtualizacaoTutor dados) {
        Tutor tutor = tutorRepository.getReferenceById(dados.id());
        if (dados.nome() != null) {
            tutor.setNome(dados.nome());
        }
        if (dados.email() != null) {
            tutor.setEmail(dados.email());
        }
        if (dados.senha() != null) {
            tutor.setSenha(passwordEncoder.encode(dados.senha()));
        }
        if (dados.telefone() != null) {
            tutor.setTelefone(dados.telefone());
        }
        if (dados.cidade() != null) {
            tutor.setCidade(dados.cidade());
        }
        if (dados.sobre() != null) {
            tutor.setCidade(dados.cidade());
        }

        return tutor;
    }

    public void excluirTutor(Long id) {
        Tutor tutor = tutorRepository.getReferenceById(id);
        tutor.setAtivo(false);
    }

    private boolean emailExiste(String email) {
        return tutorRepository.existsByEmail(email);
    }
}
