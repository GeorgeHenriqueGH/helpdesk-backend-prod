package com.henrique.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.henrique.helpdesk.domain.Chamado;
import com.henrique.helpdesk.domain.Cliente;
import com.henrique.helpdesk.domain.Tecnico;
import com.henrique.helpdesk.domain.enums.Perfil;
import com.henrique.helpdesk.domain.enums.Prioridade;
import com.henrique.helpdesk.domain.enums.Status;
import com.henrique.helpdesk.repositories.ChamadoRepository;
import com.henrique.helpdesk.repositories.ClienteRepository;
import com.henrique.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired 
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "George Henrique", "509.100.700-83", "georgehenrique233@gmail.com", encoder.encode("12345"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Leozinho Vitorio", "309.320.430-10", "leozinhovito@gmail.com", encoder.encode("54321"));
		tec1.addPerfil(Perfil.ADMIN);
		
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "990.504.720-44", "linustorvalds@hotmail.com", encoder.encode("54321"));
		Chamado ch1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

		
		Cliente cli2 = new Cliente(null, "Steve Jobs", "231.432.756-57", "stevejobs@protonmail.com", encoder.encode("54321"));
		Chamado ch2 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		chamadoRepository.saveAll(Arrays.asList(ch1, ch2));	
	}
	
}
