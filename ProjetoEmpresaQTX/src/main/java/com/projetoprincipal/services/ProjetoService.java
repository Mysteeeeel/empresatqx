package com.projetoprincipal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoprincipal.entities.Projeto;
import com.projetoprincipal.repository.ProjetoRepository;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> buscaTodosProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto buscaProjetoPeloId(Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        return projeto.orElse(null);
    }

    public Projeto salvaProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto alterarProjeto(Long id, Projeto alterarProjeto) {
        Optional<Projeto> existeProjeto = projetoRepository.findById(id);
        if (existeProjeto.isPresent()) {
            alterarProjeto.setId(id);
            return projetoRepository.save(alterarProjeto);
        }
        return null;
    }

    public boolean apagarProjeto(Long id) {
        Optional<Projeto> existeProjeto = projetoRepository.findById(id);
        if (existeProjeto.isPresent()) {
            projetoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
