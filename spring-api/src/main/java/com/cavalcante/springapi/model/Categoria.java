package com.cavalcante.springapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cavalcante.springapi.model.generic.GenericModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Paulo Eduardo
 * @date 12/04/20
 * @version 0.0.1
 */

@Entity
@Table(name="categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Categoria extends GenericModel {

	private static final long serialVersionUID = 3924409541518435165L;

	@NotNull
	@Size(max = 50)
	@Column(name="categoria_nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}