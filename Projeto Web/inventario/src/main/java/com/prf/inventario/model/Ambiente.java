package com.prf.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T012_AMBIENTE")
public class Ambiente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T012_ID_AMBIENTE")
	private int idAmbiente;	
	
	@Column(name="T012_NO_AMBIENTE")
	private String nomeAmbiente;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "ambiente")
	private List <Servidor> servidores=new ArrayList<>();

	// Construtores
	public Ambiente () {
		
	}
	
	public Ambiente(int idAmbiente, String nomeAmbiente) {
		super();
		this.idAmbiente = idAmbiente;
		this.nomeAmbiente = nomeAmbiente;
	}

	// Métodos
	
	public int getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getNomeAmbiente() {
		return nomeAmbiente;
	}

	public void setNomeAmbiente(String nomeAmbiente) {
		this.nomeAmbiente = nomeAmbiente;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}
	
	// HadhCodes and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAmbiente;
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
		Ambiente other = (Ambiente) obj;
		if (idAmbiente != other.idAmbiente)
			return false;
		return true;
	}

}		

