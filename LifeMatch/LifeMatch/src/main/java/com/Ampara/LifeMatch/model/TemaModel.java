package com.Ampara.LifeMatch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table (name = "tb_tema")
public class TemaModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_tema;
	
	@Column
	@NotNull
	private String categoria_ajuda;
	
	@Column
	@NotNull
	@Size (min = 10 ,max = 500)
	private String decricao;

	public Long getId_tema() {
		return id_tema;
	}

	public void setId_tema(Long id_tema) {
		this.id_tema = id_tema;
	}

	public String getCategoria_ajuda() {
		return categoria_ajuda;
	}

	public void setCategoria_ajuda(String categoria_ajuda) {
		this.categoria_ajuda = categoria_ajuda;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	
	
	
	
	
}
