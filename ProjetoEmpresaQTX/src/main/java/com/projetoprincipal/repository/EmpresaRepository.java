package com.projetoprincipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprincipal.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}