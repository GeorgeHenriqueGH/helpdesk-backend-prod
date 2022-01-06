package com.henrique.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henrique.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
