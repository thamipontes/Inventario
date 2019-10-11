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

@Entity
public class SistemaOperacional implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="T010_ID_SISTEMA_OPERACIONAL")
	private int idSistemaOperacional;	
	
	@Column(name="T010_NO_SISTEMA_OPERACIONAL")
	private String noSistemaOperacioanl;
	
	@OneToMany(mappedBy = "sistemaOperacional")
	private List <Servidor> servidores = new ArrayList<>();

	public SistemaOperacional () {
		
	}

	public SistemaOperacional(int id_sistema_operacional, String no_sistema_operacioanl) {
		super();
		this.idSistemaOperacional = id_sistema_operacional;
		this.noSistemaOperacioanl = no_sistema_operacioanl;
	}

	public int getId_sistema_operacional() {
		return idSistemaOperacional;
	}

	public void setId_sistema_operacional(int id_sistema_operacional) {
		this.idSistemaOperacional = id_sistema_operacional;
	}

	public String getNo_sistema_operacioanl() {
		return noSistemaOperacioanl;
	}

	public void setNo_sistema_operacioanl(String no_sistema_operacioanl) {
		this.noSistemaOperacioanl = no_sistema_operacioanl;
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