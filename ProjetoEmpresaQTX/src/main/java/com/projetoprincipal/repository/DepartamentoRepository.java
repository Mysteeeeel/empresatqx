package com.projetoprincipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprincipal.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository <Departamento, Long >{ 

}