package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T004_SISTEMA")
public class Sistema implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T004_ID_SISTEMA")
	private int idSistema;	
	
	@NotBlank(message = "O campo nome do sistema não pode ser vazio.")
	@Length(min = 2)
	@Column(name="T004_NO_SISTEMA")
	private String nomeSistema;
	
	@Column(name="T004_DE_SISTEMA",  nullable = false, length = 100)
	@NotBlank(message = "O campo descrição do sistema não pode ser vazio")
	@Length(min = 10, max = 255)
	private String descricaoSistema;
	
	@Column(name="T004_DT_PRODUCAO")
	private Date dataCriacao;
	
	@Column(name="T004_DT_DESATIVACAO")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataInativacao;
	
	@Column(name="T004_IS_ATIVO")
	private boolean ativo;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "sistemas",fetch = FetchType.EAGER)
	private List<Schema> schemas = new ArrayList<>();
	
	public Sistema () {
		
	}

	public Sistema(int idSistema, String nomeSistema, String descricaoSistema, Date dataCriacao, Date dataInativacao,
			boolean ativo) {
		super();
		this.idSistema = idSistema;
		this.nomeSistema = nomeSistema;
		this.descricaoSistema = descricaoSistema;
		this.dataCriacao = dataCriacao;
		this.dataInativacao = dataInativacao;
		this.ativo = ativo;
	}

	public int getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public String getNomeSistema() {
		return nomeSistema;
	}

	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}

	public String getDescricaoSistema() {
		return descricaoSistema;
	}

	public void setDescricaoSistema(String descricaoSistema) {
		this.descricaoSistema = descricaoSistema;
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
		result = prime * result + (int) (idSistema ^ (idSistema >>> 32));
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
		Sistema other = (Sistema) obj;
		if (idSistema != other.idSistema)
			return false;
		return true;
	}
	
	
	
	
}