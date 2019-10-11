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
public class T012_AMBIENTE implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T012_ID_AMBIENTE;	
	
	private String T012_NO_AMBIENTE;
	
	@OneToMany(mappedBy = "t012_ambiente")
	private List <T001_SERVIDOR> servidores=new ArrayList<>();

	public long getT012_ID_AMBIENTE() {
		return T012_ID_AMBIENTE;
	}

	public void setT012_ID_AMBIENTE(long t012_ID_AMBIENTE) {
		T012_ID_AMBIENTE = t012_ID_AMBIENTE;
	}

	public String getT012_NO_AMBIENTE() {
		return T012_NO_AMBIENTE;
	}

	public void setT012_NO_AMBIENTE(String t012_NO_AMBIENTE) {
		T012_NO_AMBIENTE = t012_NO_AMBIENTE;
	}

	public List<T001_SERVIDOR> getServidores() {
		return servidores;
	}

	public void setServidores(List<T001_SERVIDOR> servidores) {
		this.servidores = servidores;
	}		

	
}
