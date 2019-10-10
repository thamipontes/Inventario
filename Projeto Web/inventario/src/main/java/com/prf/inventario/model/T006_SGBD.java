package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class T006_SGBD implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T006_ID_SGBD;	
	
	private String T006_NO_SGBD;

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

	
	
	
}
