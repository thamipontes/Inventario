package com.prf.inventario.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//Faz a classe SchemaUsuario ser uma entidade do banco de dados.
@Entity

//"Mapeamento", ou seja,qual a tabela no banco de dados
@Table(name="T008_SCHEMA_USUARIO")

public class SchemaUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Chave primária composta
	@EmbeddedId
	//Instanciando 
	private IdSchemaUsuario id = new IdSchemaUsuario();
	
	
	//"Mapeamento", ou seja, qual é a coluna no banco
	@Column(name="T008_DT_CRIACAO")		
	private Date dataCriacao;

	@Column(name="T008_DT_EXPIRACAO")
	private Date dataExpiracao;
	
	@Column(name="T008_IS_ATIVO")
	private boolean ativo;
	
	@Column(name="T008_NU_CHAMADO_SOLICITANTE")
	private String chamadoSolicitante;
	
	
	//Construtor Padrão (instanciar a classe)
	public SchemaUsuario () {
		
	}
	
	//Construtor para já atribuir os valores no momento de instanciar.
	public SchemaUsuario(Schema schema, Usuario usuario, Date dataCriacao, Date dataExpiracao, boolean ativo,
			String chamadoSolicitante) {
		super();
		this.id.setSchema(schema);
		this.id.setUsuario(usuario);
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
		this.ativo = ativo;
		this.chamadoSolicitante = chamadoSolicitante;
	}
	
	
	// Getters and Setters
	
	public Schema getSchema() {
		return id.getSchema();
	}
	
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	public IdSchemaUsuario getId() {
		return id;
	}

	public void setId(IdSchemaUsuario id) {
		this.id = id;
	}
	
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

	// HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SchemaUsuario other = (SchemaUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
