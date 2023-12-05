package com.projetoprincipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprincipal.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Long >{ 

}
