package com.projetoprincipal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoprincipal.entities.Empresa;
import com.projetoprincipal.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> buscaTodasEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa buscaEmpresaPeloId(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.orElse(null);
    }

    public Empresa salvaEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa alterarEmpresa(Long id, Empresa alterarEmpresa) {
        Optional<Empresa> existeEmpresa = empresaRepository.findById(id);
        if (existeEmpresa.isPresent()) {
            alterarEmpresa.setId(id);
            return empresaRepository.save(alterarEmpresa);
        }
        return null;
    }

    public boolean apagarEmpresa(Long id) {
        Optional<Empresa> existeEmpresa = empresaRepository.findById(id);
        if (existeEmpresa.isPresent()) {
            empresaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
