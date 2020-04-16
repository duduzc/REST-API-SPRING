package com.cavalcante.springapi.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cavalcante.springapi.model.generic.GenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Paulo Eduardo
 * @date 16/04/20
 * @version 0.0.1
 */

@Entity
@Table(name="pessoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Pessoa extends GenericModel {

	private static final long serialVersionUID = -4926460822144236502L;
	
	@NotNull(message = "Nome da pessoa é obrigatório!")
	@Size(max = 50, message = "O tamanho do nome dever ser entre 1 e 60")
	@Column(name="pessoa_nome")
	private String nome;
	
	@NotNull(message = "Status é obrigatório!")
	@Column(name="pessoa_ativo")
	private Boolean ativo;

	@Embedded
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}