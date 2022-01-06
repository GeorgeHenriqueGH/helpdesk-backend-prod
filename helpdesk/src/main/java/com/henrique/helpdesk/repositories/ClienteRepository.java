package com.henrique.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
