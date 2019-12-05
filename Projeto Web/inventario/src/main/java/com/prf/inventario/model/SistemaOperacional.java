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
@Table(name="T010_SISTEMA_OPERACIONAL")
public class SistemaOperacional implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T010_ID_SISTEMA_OPERACIONAL")
	private int idSistemaOperacional;	
	
	@Column(name="T010_NO_SISTEMA_OPERACIONAL")
	private String nomeSistemaOperacional;
	
	
	@OneToMany(mappedBy = "sistemaOperacional")
	private List <Servidor> servidores = new ArrayList<>();

	public SistemaOperacional () {
		
	}

	public SistemaOperacional(int idSistemaOperacional, String nomeSistemaOperacional) {
		super();
		this.idSistemaOperacional = idSistemaOperacional;
		this.nomeSistemaOperacional = nomeSistemaOperacional;
	}


	public int getIdSistemaOperacional() {
		return idSistemaOperacional;
	}

	public void setIdSistemaOperacional(int idSistemaOperacional) {
		this.idSistemaOperacional = idSistemaOperacional;
	}

	public String getNomeSistemaOperacional() {
		return nomeSistemaOperacional;
	}

	public void setNomeSistemaOperacional(String nomeSistemaOperacional) {
		this.nomeSistemaOperacional = nomeSistemaOperacional;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSistemaOperacional;
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
		SistemaOperacional other = (SistemaOperacional) obj;
		if (idSistemaOperacional != other.idSistemaOperacional)
			return false;
		return true;
	}
	
	
	

}