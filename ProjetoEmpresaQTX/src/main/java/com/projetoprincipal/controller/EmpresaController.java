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

import com.projetoprincipal.entities.Empresa;
import com.projetoprincipal.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscaEmpresaControlId(@PathVariable long id) {
        Empresa empresa = empresaService.buscaEmpresaPeloId(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> buscaTodasEmpresasControl() {
        List<Empresa> empresas = empresaService.buscaTodasEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @PostMapping("/")
    public ResponseEntity<Empresa> salvaEmpresaControl(@RequestBody Empresa empresa) {
        Empresa salvaEmpresa = empresaService.salvaEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> alteraEmpresaControl(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa alteraEmpresa = empresaService.alterarEmpresa(id, empresa);
        if (alteraEmpresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaEmpresaControl(@PathVariable Long id) {
        boolean apagar = empresaService.apagarEmpresa(id);
        if (apagar) {
            return ResponseEntity.ok().body("A Empresa foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

