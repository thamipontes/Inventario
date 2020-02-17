package com.prf.Chamado.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T016_TIPO_CHAMADO")
public class TipoChamado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	//Atributos ou campos da tabela
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T016_ID_TIPO_CHAMADO")
	private int idTipoChamado;	
	
	@Column(name="T016_NO_TIPO_CHAMADO")
	private String nomeTipoChamado;


	// Construtores
	public TipoChamado () {
		
	}
	
	public TipoChamado(int idTipoChamado, String nomeTipoChamado) {
		super();
		this.idTipoChamado = idTipoChamado;
		this.nomeTipoChamado = nomeTipoChamado;
	}

	// Métodos ou função
	
	public int getIdTipoChamado() {
		return idTipoChamado;
	}

	public void setIdTipoChamado(int idTipoChamado) {
		this.idTipoChamado = idTipoChamado;
	}

	public String getNomeTipoChamado() {
		return nomeTipoChamado;
	}

	public void setNomeTipoChamado(String nomeTipoChamado) {
		this.nomeTipoChamado = nomeTipoChamado;
	}

	
	// HadhCodes and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoChamado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoChamado other = (TipoChamado) obj;
		if (idTipoChamado != other.idTipoChamado)
			return false;
		return true;
	}

}		