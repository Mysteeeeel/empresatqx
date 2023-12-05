package com.projetoprincipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoprincipal.entities.Cliente;
import com.projetoprincipal.entities.Departamento;
import com.projetoprincipal.entities.Empresa;
import com.projetoprincipal.entities.Fornecedor;
import com.projetoprincipal.entities.Funcionario;
import com.projetoprincipal.entities.Projeto;
import com.projetoprincipal.services.ClienteService;
import com.projetoprincipal.services.DepartamentoService;
import com.projetoprincipal.services.EmpresaService;
import com.projetoprincipal.services.FornecedorService;
import com.projetoprincipal.services.FuncionarioService;
import com.projetoprincipal.services.ProjetoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name ="APIExterna")
@RestController
@RequestMapping("/APIExterna")
@CrossOrigin(origins = "*")

public class APIExterna {
	
	private final ClienteService clienteService;
	private final DepartamentoService departamentoService;
	private final EmpresaService empresaService;
	private final FornecedorService fornecedorService;
	private final FuncionarioService funcionarioService;
	private final ProjetoService projetoService;
	
	@Autowired
	public APIExterna(ClienteService clienteService, DepartamentoService departamentoservice,
			EmpresaService empresaService, FornecedorService fornecedorService, FuncionarioService funcionarioService,
			ProjetoService projetoService) {
		super();
		this.clienteService = clienteService;
		this.departamentoService = departamentoservice;
		this.empresaService = empresaService;
		this.fornecedorService = fornecedorService;
		this.funcionarioService = funcionarioService;
		this.projetoService = projetoService;
	}

	@GetMapping("/apicliente")
    public ResponseEntity<List<Cliente>> buscaTodosClientesControl() {
        List<Cliente> clientes = clienteService.buscaTodosClientes();
        return ResponseEntity.ok(clientes);
    }
	
	@GetMapping("/apidepartamento")
    public ResponseEntity<List<Departamento>> buscaTodosDepartamentosControl() {
        List<Departamento> departamentos = departamentoService.buscaTodosDepartamentos();
        return ResponseEntity.ok(departamentos);
    }
	
	@GetMapping("/apiempresa")
    public ResponseEntity<List<Empresa>> buscaTodasEmpresasControl() {
        List<Empresa> empresas = empresaService.buscaTodasEmpresas();
        return ResponseEntity.ok(empresas);
    }
	
	@GetMapping("/apifornecedor")
    public ResponseEntity<List<Fornecedor>> buscaTodosFornecedoresControl() {
        List<Fornecedor> fornecedores = fornecedorService.buscaTodosFornecedores();
        return ResponseEntity.ok(fornecedores);
    }
	
	@GetMapping("/apifuncionario")
    public ResponseEntity<List<Funcionario>> buscaTodosFuncionariosControl() {
        List<Funcionario> funcionarios = funcionarioService.buscaTodosFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }
	
	@GetMapping("/apiprojeto")
    public ResponseEntity<List<Projeto>> buscaTodosProjetosControl() {
        List<Projeto> projetos = projetoService.buscaTodosProjetos();
        return ResponseEntity.ok(projetos);
    }

}
