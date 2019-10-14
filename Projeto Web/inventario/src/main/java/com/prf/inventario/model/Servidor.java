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
@Table(name="T001_SERVIDOR")
public class Servidor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="T001_ID_SERVIDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServidor;	
	@Column(name="T001_NO_SERVIDOR")
	private String nomeServidor;
	@Column(name="T001_DT_CRIACAO")
	private Date dataCriacao;
	@Column(name="T001_DT_INATIVACAO")
	private Date dataInativacao;
	@Column(name="T001_IS_ATIVO")
	private boolean ativo;
	@Column(name="T001_IP_HOST")
	private String ipHost;
	@Column(name="T001_NU_VERSAO_SO")
	private String versaoSo;
	@Column(name="T001_NU_VERSAO_KERNEL")
	private String versaoKernel;
	@Column(name="T001_NU_CPU")
	private int cpus;
	@Column(name="T001_NU_NUCLEOS")
	private int nucleos;
	@Column(name="T001_NU_CORES")
	private int cores;
	@Column(name="T001_NU_MEMORIA_MB")
	private int memoriaMb;	
	
	@ManyToOne
	@JoinColumn(name = "T010_ID_SISTEMA_OPERACIONAL")
	private SistemaOperacional sistemaOperacional;
		
	@ManyToOne
	@JoinColumn(name = "T012_ID_AMBIENTE")
	private Ambiente ambiente;
	
	@OneToMany(mappedBy = "servidor")
	private List <Instancia> instancias = new ArrayList<>();
	
	@OneToMany(mappedBy = "servidor")
	private List <DiscosServidor> discosServidor=new ArrayList<>();
	
	public Servidor () {
		
	}

	public Servidor(int idServidor, String nomeServidor, Date dataCriacao, Date dataInativacao, boolean ativo,
			String ipHost, String versaoSo, String versaoKernel, int cpus, int nucleos, int cores, int memoriaMb) {
		super();
		this.idServidor = idServidor;
		this.nomeServidor = nomeServidor;
		this.dataCriacao = dataCriacao;
		this.dataInativacao = dataInativacao;
		this.ativo = ativo;
		this.ipHost = ipHost;
		this.versaoSo = versaoSo;
		this.versaoKernel = versaoKernel;
		this.cpus = cpus;
		this.nucleos = nucleos;
		this.cores = cores;
		this.memoriaMb = memoriaMb;
	}

	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
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

	public String getIpHost() {
		return ipHost;
	}

	public void setIpHost(String ipHost) {
		this.ipHost = ipHost;
	}

	public String getVersaoSo() {
		return versaoSo;
	}

	public void setVersaoSo(String versaoSo) {
		this.versaoSo = versaoSo;
	}

	public String getVersaoKernel() {
		return versaoKernel;
	}

	public void setVersaoKernel(String versaoKernel) {
		this.versaoKernel = versaoKernel;
	}

	public int getCpus() {
		return cpus;
	}

	public void setCpus(int cpus) {
		this.cpus = cpus;
	}

	public int getNucleos() {
		return nucleos;
	}

	public void setNucleos(int nucleos) {
		this.nucleos = nucleos;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public int getMemoriaMb() {
		return memoriaMb;
	}

	public void setMemoriaMb(int memoriaMb) {
		this.memoriaMb = memoriaMb;
	}

	public SistemaOperacional getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public List<DiscosServidor> getDiscosServidor() {
		return discosServidor;
	}

	public void setDiscosServidor(List<DiscosServidor> discosServidor) {
		this.discosServidor = discosServidor;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public List<Instancia> getInstancias() {
		return instancias;
	}

	public void setInstancias(List<Instancia> instancias) {
		this.instancias = instancias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idServidor;
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
		Servidor other = (Servidor) obj;
		if (idServidor != other.idServidor)
			return false;
		return true;
	}
	
	
}