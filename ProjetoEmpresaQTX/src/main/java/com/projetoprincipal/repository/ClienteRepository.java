package com.projetoprincipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoprincipal.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}