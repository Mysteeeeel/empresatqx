package com.projetoprincipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoprincipal.entities.Projeto;
import com.projetoprincipal.services.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    private final ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscaProjetoControlId(@PathVariable long id) {
        Projeto projeto = projetoService.buscaProjetoPeloId(id);
        if (projeto != null) {
            return ResponseEntity.ok(projeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> buscaTodosProjetosControl() {
        List<Projeto> projetos = projetoService.buscaTodosProjetos();
        return ResponseEntity.ok(projetos);
    }

    @PostMapping("/")
    public ResponseEntity<Projeto> salvaProjetoControl(@RequestBody Projeto projeto) {
        Projeto salvaProjeto = projetoService.salvaProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaProjeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> alteraProjetoControl(@PathVariable Long id, @RequestBody Projeto projeto) {
        Projeto alteraProjeto = projetoService.alterarProjeto(id, projeto);
        if (alteraProjeto != null) {
            return ResponseEntity.ok(projeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaProjetoControl(@PathVariable Long id) {
        boolean apagar = projetoService.apagarProjeto(id);
        if (apagar) {
            return ResponseEntity.ok().body("O Projeto foi excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
