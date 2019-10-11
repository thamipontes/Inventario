package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T008_SCHEMA_USUARIO")
public class SchemaUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="T008_DT_CRIACAO")
	private Date dataCriacao;
	@Column(name="T008_DT_EXPIRACAO")
	private Date dataExpiracao;
	@Column(name="T008_IS_ATIVO")
	private boolean ativo;
	@Column(name="T008_NU_CHAMADO_SOLICITANTE")
	private String chamadoSolicitante;

	@ManyToOne
	@JoinColumn(name = "T007_ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "T009_ID_SCHEMA")
	private Schema schema;
	
	// Construtores
	
	public SchemaUsuario () {
		
	}

	public SchemaUsuario(Date dataCriacao, Date dataExpiracao, boolean ativo,
			String chamadoSolicitante) {
		super();
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
		this.ativo = ativo;
		this.chamadoSolicitante = chamadoSolicitante;
	}
	
	// Getters and Setters


	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getChamadoSolicitante() {
		return chamadoSolicitante;
	}

	public void setChamadoSolicitante(String chamadoSolicitante) {
		this.chamadoSolicitante = chamadoSolicitante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}
	
	// HashCode and Equals


	
}
