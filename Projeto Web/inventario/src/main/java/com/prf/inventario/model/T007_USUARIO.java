package com.prf.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class T007_USUARIO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T007_ID_USUARIO;	
	
	private String T007_NO_USUARIO;
	private String T007_LOTACAO_USUARIO;
	
	public long getT007_ID_USUARIO() {
		return T007_ID_USUARIO;
	}
	public void setT007_ID_USUARIO(long t007_ID_USUARIO) {
		T007_ID_USUARIO = t007_ID_USUARIO;
	}
	public String getT007_NO_USUARIO() {
		return T007_NO_USUARIO;
	}
	public void setT007_NO_USUARIO(String t007_NO_USUARIO) {
		T007_NO_USUARIO = t007_NO_USUARIO;
	}
	public String getT007_LOTACAO_USUARIO() {
		return T007_LOTACAO_USUARIO;
	}
	public void setT007_LOTACAO_USUARIO(String t007_LOTACAO_USUARIO) {
		T007_LOTACAO_USUARIO = t007_LOTACAO_USUARIO;
	}	
	
}