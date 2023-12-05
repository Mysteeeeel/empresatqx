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

import com.projetoprincipal.entities.Cliente;
import com.projetoprincipal.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaClienteControlId(@PathVariable long id) {
        Cliente cliente = clienteService.buscaClientePeloId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscaTodosClientesControl() {
        List<Cliente> clientes = clienteService.buscaTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> salvaClienteControl(@RequestBody Cliente cliente) {
        Cliente salvaCliente = clienteService.salvaCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alteraClienteControl(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente alteraCliente = clienteService.alterarCliente(id, cliente);
        if (alteraCliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaClienteControl(@PathVariable Long id) {
        boolean apagar = clienteService.apagarCliente(id);
        if (apagar) {
            return ResponseEntity.ok().body("O Cliente foi excluído com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
