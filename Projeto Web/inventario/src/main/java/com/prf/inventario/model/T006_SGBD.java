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
public class T006_SGBD implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T006_ID_SGBD;	
	
	private String T006_NO_SGBD;
	
	@OneToMany(mappedBy = "t006_sgbd")
	private List <T005_INSTANCIA> instancias=new ArrayList<>();

	public long getT006_ID_SGBD() {
		return T006_ID_SGBD;
	}

	public void setT006_ID_SGBD(long t006_ID_SGBD) {
		T006_ID_SGBD = t006_ID_SGBD;
	}

	public String getT006_NO_SGBD() {
		return T006_NO_SGBD;
	}

	public void setT006_NO_SGBD(String t006_NO_SGBD) {
		T006_NO_SGBD = t006_NO_SGBD;
	}

	public List<T005_INSTANCIA> getInstancias() {
		return instancias;
	}

	public void setInstancias(List<T005_INSTANCIA> instancias) {
		this.instancias = instancias;
	}

	
	
	
}
