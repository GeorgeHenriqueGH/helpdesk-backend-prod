package com.henrique.helpdesk.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.henrique.helpdesk.domain.Chamado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("serial")
public class ChamadoDTO implements Serializable {

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;

	@NotNull(message = "O campo PRIORIDADE é requerido")
	private Integer prioridade;
	
	@NotNull(message = "O campo STATUS é requerido")
	private Integer status;
	
	@NotNull(message = "O campo TÍTULO é requerido")
	private String titulo;
	
	@NotNull(message = "O campo OBSERVAÇÕES é requerido")
	private String observacoes;

	private String nomeTecnico;
	private String nomeCliente;
	
	@NotNull(message = "O campo TÉCNICO é requerido")
	private Integer tecnico;
	
	@NotNull(message = "O campo CLIENTE é requerido")
	private Integer cliente;
	

	public ChamadoDTO(Chamado obj) {
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeCliente = obj.getCliente().getNome();
		this.nomeTecnico = obj.getTecnico().getNome();
	}
	
	public ChamadoDTO() {
		super();
	}
	
}
