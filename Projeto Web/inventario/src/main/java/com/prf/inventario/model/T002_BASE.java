package com.prf.inventario.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class T002_BASE implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T002_ID_BASE;	
	
	private String T002_NO_BASE;
	private String T002_DE_BASE;
	
	
	public long getT002_ID_BASE() {
		return T002_ID_BASE;
	}
	public void setT002_ID_BASE(long t002_ID_BASE) {
		T002_ID_BASE = t002_ID_BASE;
	}
	public String getT002_NO_BASE() {
		return T002_NO_BASE;
	}
	public void setT002_NO_BASE(String t002_NO_BASE) {
		T002_NO_BASE = t002_NO_BASE;
	}
	public String getT002_DE_BASE() {
		return T002_DE_BASE;
	}
	public void setT002_DE_BASE(String t002_DE_BASE) {
		T002_DE_BASE = t002_DE_BASE;
	}	

}