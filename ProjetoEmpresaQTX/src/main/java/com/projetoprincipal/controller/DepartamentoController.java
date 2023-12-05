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

import com.projetoprincipal.entities.Departamento;
import com.projetoprincipal.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscaDepartamentoControlId(@PathVariable long id) {
        Departamento departamento = departamentoService.buscaDepartamentoPeloId(id);
        if (departamento != null) {
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> buscaTodosDepartamentosControl() {
        List<Departamento> departamentos = departamentoService.buscaTodosDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @PostMapping("/")
    public ResponseEntity<Departamento> salvaDepartamentoControl(@RequestBody Departamento departamento) {
        Departamento salvaDepartamento = departamentoService.salvaDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> alteraDepartamentoControl(@PathVariable Long id, @RequestBody Departamento departamento) {
        Departamento alteraDepartamento = departamentoService.alterarDepartamento(id, departamento);
        if (alteraDepartamento != null) {
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaDepartamentoControl(@PathVariable Long id) {
        boolean apagar = departamentoService.apagarDepartamento(id);
        if (apagar) {
            return ResponseEntity.ok().body("O Departamento foi excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
