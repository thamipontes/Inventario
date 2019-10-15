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
@Table(name="T005_INSTANCIA")
public class Instancia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T005_ID_INSTANCIA")
	private int idInstancia;		
	@Column(name="T005_NO_INSTANCIA")
	private String nomeInstancia;
	@Column(name="T005_DE_INSTANCIA")
	private String descricaoInstancia;
	@Column(name="T005_DT_CRIACAO")
	private Date dataCriacao;
	@Column(name="T005_DT_INATIVACAO")
	private Date dataInativacao;
	@Column(name="T005_IS_ATIVO")
	private boolean ativo;
	@Column(name="T005_NU_VERSAO_SGBD")
	private String versaoSgbd;
	@Column(name="T005_NU_PORTA")
	private int porta;
	@Column(name="T005_LOCAL_INSTALACAO")
	private String localInstalacao;
	
	@ManyToOne
	@JoinColumn(name = "T006_ID_SGBD")
	private Sgbd sgbd;
	
	@ManyToOne
	@JoinColumn(name = "T001_ID_SERVIDOR")
	private Servidor servidor;
	
	@OneToMany(mappedBy = "instancia")
	private List <Base> bases=new ArrayList<>();
	
	public Instancia () {
		
	}

	public Instancia(int idInstancia, String nomeInstancia, String descricaoInstancia, Date dataCriacao,
			Date dataInativacao, boolean ativo, String versaoSgbd, int porta, String localInstalacao) {
		super();
		this.idInstancia = idInstancia;
		this.nomeInstancia = nomeInstancia;
		this.descricaoInstancia = descricaoInstancia;
		this.dataCriacao = dataCriacao;
		this.dataInativacao = dataInativacao;
		this.ativo = ativo;
		this.versaoSgbd = versaoSgbd;
		this.porta = porta;
		this.localInstalacao = localInstalacao;
	}

	public int getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(int idInstancia) {
		this.idInstancia = idInstancia;
	}

	public String getNomeInstancia() {
		return nomeInstancia;
	}

	public void setNomeInstancia(String nomeInstancia) {
		this.nomeInstancia = nomeInstancia;
	}

	public String getDescricaoInstancia() {
		return descricaoInstancia;
	}

	public void setDescricaoInstancia(String descricaoInstancia) {
		this.descricaoInstancia = descricaoInstancia;
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

	public String getVersaoSgbd() {
		return versaoSgbd;
	}

	public void setVersaoSgbd(String versaoSgbd) {
		this.versaoSgbd = versaoSgbd;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getLocalInstalacao() {
		return localInstalacao;
	}

	public void setLocalInstalacao(String localInstalacao) {
		this.localInstalacao = localInstalacao;
	}

	public Sgbd getSgbd() {
		return sgbd;
	}

	public void setSgbd(Sgbd sgbd) {
		this.sgbd = sgbd;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<Base> getBases() {
		return bases;
	}

	public void setBases(List<Base> bases) {
		this.bases = bases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idInstancia;
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
		Instancia other = (Instancia) obj;
		if (idInstancia != other.idInstancia)
			return false;
		return true;
	}
	
	
	
	
	

}