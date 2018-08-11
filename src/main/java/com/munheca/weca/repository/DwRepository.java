package com.munheca.weca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.munheca.weca.domain.Cliente;

public interface DwRepository extends JpaRepository<Cliente, Long>{

}
