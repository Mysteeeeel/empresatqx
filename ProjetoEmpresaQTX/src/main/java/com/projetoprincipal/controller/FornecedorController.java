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

import com.projetoprincipal.entities.Fornecedor;
import com.projetoprincipal.services.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    private final FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscaFornecedorControlId(@PathVariable long id) {
        Fornecedor fornecedor = fornecedorService.buscaFornecedorPeloId(id);
        if (fornecedor != null) {
            return ResponseEntity.ok(fornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> buscaTodosFornecedoresControl() {
        List<Fornecedor> fornecedores = fornecedorService.buscaTodosFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    @PostMapping("/")
    public ResponseEntity<Fornecedor> salvaFornecedorControl(@RequestBody Fornecedor fornecedor) {
        Fornecedor salvaFornecedor = fornecedorService.salvaFornecedor(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> alteraFornecedorControl(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Fornecedor alteraFornecedor = fornecedorService.alterarFornecedor(id, fornecedor);
        if (alteraFornecedor != null) {
            return ResponseEntity.ok(fornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaFornecedorControl(@PathVariable Long id) {
        boolean apagar = fornecedorService.apagarFornecedor(id);
        if (apagar) {
            return ResponseEntity.ok().body("O Fornecedor foi excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
