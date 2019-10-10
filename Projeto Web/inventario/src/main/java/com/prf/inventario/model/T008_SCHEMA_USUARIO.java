package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class T008_SCHEMA_USUARIO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T009_ID_SCHEMA;
	private long T007_ID_USUARIO;
	
	private Date T008_DT_CRIACAO;
	private Date T008_DT_EXPIRACAO;
	private boolean T008_IS_ATIVO;
	private String T008_NU_CHAMADO_SOLICITANTE;
	
	public long getT009_ID_SCHEMA() {
		return T009_ID_SCHEMA;
	}
	public void setT009_ID_SCHEMA(long t009_ID_SCHEMA) {
		T009_ID_SCHEMA = t009_ID_SCHEMA;
	}
	public long getT007_ID_USUARIO() {
		return T007_ID_USUARIO;
	}
	public void setT007_ID_USUARIO(long t007_ID_USUARIO) {
		T007_ID_USUARIO = t007_ID_USUARIO;
	}
	public Date getT008_DT_CRIACAO() {
		return T008_DT_CRIACAO;
	}
	public void setT008_DT_CRIACAO(Date t008_DT_CRIACAO) {
		T008_DT_CRIACAO = t008_DT_CRIACAO;
	}
	public Date getT008_DT_EXPIRACAO() {
		return T008_DT_EXPIRACAO;
	}
	public void setT008_DT_EXPIRACAO(Date t008_DT_EXPIRACAO) {
		T008_DT_EXPIRACAO = t008_DT_EXPIRACAO;
	}
	public boolean isT008_IS_ATIVO() {
		return T008_IS_ATIVO;
	}
	public void setT008_IS_ATIVO(boolean t008_IS_ATIVO) {
		T008_IS_ATIVO = t008_IS_ATIVO;
	}
	public String getT008_NU_CHAMADO_SOLICITANTE() {
		return T008_NU_CHAMADO_SOLICITANTE;
	}
	public void setT008_NU_CHAMADO_SOLICITANTE(String t008_NU_CHAMADO_SOLICITANTE) {
		T008_NU_CHAMADO_SOLICITANTE = t008_NU_CHAMADO_SOLICITANTE;
	}	
	
}
