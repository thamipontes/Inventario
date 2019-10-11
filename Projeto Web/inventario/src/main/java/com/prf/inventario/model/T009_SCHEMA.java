package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class T009_SCHEMA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T009_ID_SCHEMA;
	
	private String T009_NO_SCHEMA;
	private Date T009_DE_SCHEMA;
	private Date T009_DT_CRIACAO;
	
	@ManyToOne
	@JoinColumn(name = "T002_BASE")
	private T002_BASE t002_base;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="T003_SISTEMA_SCHEMA", joinColumns = 
		{@JoinColumn(name="T009_ID_SCHEMA")},inverseJoinColumns = 
			{@JoinColumn(name="T004_ID_SISTEMA")})
	private List<T004_SISTEMA> sistemas = new ArrayList<>();
			
	public List<T004_SISTEMA> getSistemas() {
		return sistemas;
	}
	public void setSistemas(List<T004_SISTEMA> sistemas) {
		this.sistemas = sistemas;
	}
	public long getT009_ID_SCHEMA() {
		return T009_ID_SCHEMA;
	}
	public void setT009_ID_SCHEMA(long t009_ID_SCHEMA) {
		T009_ID_SCHEMA = t009_ID_SCHEMA;
	}
	public String getT009_NO_SCHEMA() {
		return T009_NO_SCHEMA;
	}
	public void setT009_NO_SCHEMA(String t009_NO_SCHEMA) {
		T009_NO_SCHEMA = t009_NO_SCHEMA;
	}
	public Date getT009_DE_SCHEMA() {
		return T009_DE_SCHEMA;
	}
	public void setT009_DE_SCHEMA(Date t009_DE_SCHEMA) {
		T009_DE_SCHEMA = t009_DE_SCHEMA;
	}
	public Date getT009_DT_CRIACAO() {
		return T009_DT_CRIACAO;
	}
	public void setT009_DT_CRIACAO(Date t009_DT_CRIACAO) {
		T009_DT_CRIACAO = t009_DT_CRIACAO;
	}
	public T002_BASE getT002_base() {
		return t002_base;
	}
	public void setT002_base(T002_BASE t002_base) {
		this.t002_base = t002_base;
	}
	
	
	
}