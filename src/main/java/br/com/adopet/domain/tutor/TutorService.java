package br.com.adopet.domain.tutor;

import br.com.adopet.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
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

    private boolean emailExiste(String email) {
        return tutorRepository.existsByEmail(email);
    }
}
