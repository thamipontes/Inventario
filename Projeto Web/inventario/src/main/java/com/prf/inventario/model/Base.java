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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T002_BASE")
public class Base implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="T002_ID_BASE")
	private int idBase;	
	
	@Column(name="T002_NO_BASE")
	private String nomeBase;
	
	@Column(name="T002_DE_BASE")
	private String descricaoBase;
	
	@Column(name="T002_DT_CRIACAO")
	private Date dataCriacao;
	
	@Column(name="T002_DT_INATIVACAO")
	private Date dataInativacao;
	
	@Column(name="T002_IS_ATIVO")
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "T005_INSTANCIA")
	private Instancia instancia;
	
	@OneToMany(mappedBy = "base")
	private List <Schema> schemas=new ArrayList<>();
	
	public Base () {
		
	}

	public Base(int idBase, String nomeBase, String descricaoBase, Date dataCriacao, Date dataInativacao,
			boolean ativo) {
		super();
		this.idBase = idBase;
		this.nomeBase = nomeBase;
		this.descricaoBase = descricaoBase;
		this.dataCriacao = dataCriacao;
		this.dataInativacao = dataInativacao;
		this.ativo = ativo;
	}

	public int getIdBase() {
		return idBase;
	}

	public void setIdBase(int idBase) {
		this.idBase = idBase;
	}

	public String getNomeBase() {
		return nomeBase;
	}

	public void setNomeBase(String nomeBase) {
		this.nomeBase = nomeBase;
	}

	public String getDescricaoBase() {
		return descricaoBase;
	}

	public void setDescricaoBase(String descricaoBase) {
		this.descricaoBase = descricaoBase;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public void setInstancia(Instancia instancia) {
		this.instancia = instancia;
	}

	public List<Schema> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<Schema> schemas) {
		this.schemas = schemas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBase;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Base other = (Base) obj;
		if (idBase != other.idBase)
			return false;
		return true;
	}
	
	
	

	
	
	
	
	

}