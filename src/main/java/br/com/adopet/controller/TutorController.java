package br.com.adopet.controller;

import br.com.adopet.domain.tutor.*;
import br.com.adopet.domain.tutor.dto.DadosAtualizacaoTutor;
import br.com.adopet.domain.tutor.dto.DadosCadastroTutor;
import br.com.adopet.domain.tutor.dto.DadosDetalhamentoTutor;
import br.com.adopet.domain.tutor.dto.DadosListagemTutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados) {
        tutorService.cadastraNovoTutor(dados);
        return ResponseEntity.ok("Tutor criado.");
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTutor>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemTutor> pagina = tutorRepository.findAllByAtivoTrue(paginacao).map(DadosListagemTutor::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Tutor tutor = tutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTutor dados) {
        Tutor tutor = tutorService.atualizaTutor(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        tutorService.excluirTutor(id);
        return ResponseEntity.noContent().build();
    }
}
