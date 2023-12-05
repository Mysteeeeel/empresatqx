package com.projetoprincipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprincipal.entities.Projeto;

public interface ProjetoRepository extends JpaRepository <Projeto, Long >{ 

}