package com.projetoprincipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprincipal.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long >{ 

}