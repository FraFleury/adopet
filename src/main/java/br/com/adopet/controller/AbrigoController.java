package br.com.adopet.controller;

import br.com.adopet.domain.abrigo.Abrigo;
import br.com.adopet.domain.abrigo.AbrigoRepository;
import br.com.adopet.domain.abrigo.AbrigoService;
import br.com.adopet.domain.abrigo.dto.DadosAtualizacaoAbrigo;
import br.com.adopet.domain.abrigo.dto.DadosCadastroAbrigo;
import br.com.adopet.domain.abrigo.dto.DadosDetalhamentoAbrigo;
import br.com.adopet.domain.abrigo.dto.DadosListagemAbrigo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados) {
        abrigoService.cadastraNovoAbrigo(dados);
        return ResponseEntity.ok("Abrigo criado.");
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAbrigo>> listar(@PageableDefault(size = 10, sort = {"localidade"}) Pageable paginacao) {
        Page<DadosListagemAbrigo> pagina = abrigoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemAbrigo::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Abrigo abrigo = abrigoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAbrigo(abrigo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAbrigo dados) {
        Abrigo abrigo = abrigoService.atualizaAbrigo(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAbrigo(abrigo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        abrigoService.excluiAbrigo(id);
        return ResponseEntity.noContent().build();
    }
}
