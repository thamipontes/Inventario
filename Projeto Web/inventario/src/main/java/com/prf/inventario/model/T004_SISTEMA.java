package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class T004_SISTEMA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T004_ID_SISTEMA;	
	
	private String T004_NO_SISTEMA;
	private String T004_DE_SISTEMA;
	private Date T004_DT_PRODUCAO;
	private Date T004_DT_DESATIVACAO;
	private boolean T004_IS_ATIVO;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "sistemas")
	private List<T009_SCHEMA> schemas = new ArrayList<>();
	
	public Date getT004_DT_PRODUCAO() {
		return T004_DT_PRODUCAO;
	}
	public void setT004_DT_PRODUCAO(Date t004_DT_PRODUCAO) {
		T004_DT_PRODUCAO = t004_DT_PRODUCAO;
	}
	public Date getT004_DT_DESATIVACAO() {
		return T004_DT_DESATIVACAO;
	}
	public void setT004_DT_DESATIVACAO(Date t004_DT_DESATIVACAO) {
		T004_DT_DESATIVACAO = t004_DT_DESATIVACAO;
	}
	public List<T009_SCHEMA> getSchemas() {
		return schemas;
	}
	public void setSchemas(List<T009_SCHEMA> schemas) {
		this.schemas = schemas;
	}
	public long getT004_ID_SISTEMA() {
		return T004_ID_SISTEMA;
	}
	public void setT004_ID_SISTEMA(long t004_ID_SISTEMA) {
		T004_ID_SISTEMA = t004_ID_SISTEMA;
	}
	public String getT004_NO_SISTEMA() {
		return T004_NO_SISTEMA;
	}
	public void setT004_NO_SISTEMA(String t004_NO_SISTEMA) {
		T004_NO_SISTEMA = t004_NO_SISTEMA;
	}
	public String getT004_DE_SISTEMA() {
		return T004_DE_SISTEMA;
	}
	public void setT004_DE_SISTEMA(String t004_DE_SISTEMA) {
		T004_DE_SISTEMA = t004_DE_SISTEMA;
	}
	public Date getT004_DT_PRODUCAO_SISTEMA() {
		return T004_DT_PRODUCAO;
	}
	public void setT004_DT_PRODUCAO_SISTEMA(Date t004_DT_PRODUCAO) {
		T004_DT_PRODUCAO = t004_DT_PRODUCAO;
	}
	public Date getT004_DT_DESATIVACAO_SISTEMA() {
		return T004_DT_DESATIVACAO;
	}
	public void setT004_DT_DESATIVACAO_SISTEMA(Date t004_DT_DESATIVACAO) {
		T004_DT_DESATIVACAO = t004_DT_DESATIVACAO;
	}
	public boolean isT004_IS_ATIVO() {
		return T004_IS_ATIVO;
	}
	public void setT004_IS_ATIVO(boolean t004_IS_ATIVO) {
		T004_IS_ATIVO = t004_IS_ATIVO;
	}	
	
	
}