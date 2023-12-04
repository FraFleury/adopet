package br.com.adopet.controller;

import br.com.adopet.domain.tutor.dto.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dados.email(), dados.senha()));
        return ResponseEntity.ok("Usuário logado.");
    }
}
