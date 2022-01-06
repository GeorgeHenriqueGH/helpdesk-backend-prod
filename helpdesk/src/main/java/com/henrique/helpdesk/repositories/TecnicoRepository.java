package com.henrique.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
