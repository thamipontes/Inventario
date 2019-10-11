package com.prf.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class T010_SISTEMA_OPERACIONAL implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T010_ID_SISTEMA_OPERACIONAL;	
	
	private String T010_NO_SISTEMA_OPERACIONAL;
	
	@OneToMany(mappedBy = "t010_sistema_operacional")
	private List <T001_SERVIDOR> servidores=new ArrayList<>();

	public long getT010_ID_SISTEMA_OPERACIONAL() {
		return T010_ID_SISTEMA_OPERACIONAL;
	}

	public void setT010_ID_SISTEMA_OPERACIONAL(long t010_ID_SISTEMA_OPERACIONAL) {
		T010_ID_SISTEMA_OPERACIONAL = t010_ID_SISTEMA_OPERACIONAL;
	}

	public String getT010_NO_SISTEMA_OPERACIONAL() {
		return T010_NO_SISTEMA_OPERACIONAL;
	}

	public void setT010_NO_SISTEMA_OPERACIONAL(String t010_NO_SISTEMA_OPERACIONAL) {
		T010_NO_SISTEMA_OPERACIONAL = t010_NO_SISTEMA_OPERACIONAL;
	}

	public List<T001_SERVIDOR> getServidores() {
		return servidores;
	}

	public void setServidores(List<T001_SERVIDOR> servidores) {
		this.servidores = servidores;
	}
	
	
	
	
	

}