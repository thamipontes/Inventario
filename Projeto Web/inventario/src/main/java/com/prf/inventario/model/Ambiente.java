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

@Entity
@Table(name="T012_AMBIENTE")
public class Ambiente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="T012_ID_AMBIENTE")
	private int idAmbiente;	
	
	@Column(name="T012_NO_AMBIENTE")
	private String nomeAmbiente;
	
	@OneToMany(mappedBy = "ambiente")
	private List <Servidor> servidores=new ArrayList<>();

	// Construtores
	public Ambiente () {
		
	}
	
	public Ambiente(int id_ambiente, String nome_ambiente) {
		super();
		this.idAmbiente = id_ambiente;
		this.nomeAmbiente = nome_ambiente;
	}

	// Métodos
	
	public int getId_ambiente() {
		return idAmbiente;
	}

	public void setId_ambiente(int id_ambiente) {
		this.idAmbiente = id_ambiente;
	}

	public String getNome_ambiente() {
		return nomeAmbiente;
	}

	public void setNome_ambiente(String nome_ambiente) {
		this.nomeAmbiente = nome_ambiente;
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

