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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int T001_ID_SERVIDOR;
	
	@Column(name="T001_NO_SERVIDOR")
	private String T001_NO_SERVIDOR;
	@Column(name="T001_DT_CRIACAO")
	private Date T001_DT_CRIACAO;
	@Column(name="T001_DT_INATIVACAO")
	private Date T001_DT_INATIVACAO;
	@Column(name="T001_IS_ATIVO")
	private boolean T001_IS_ATIVO;
	@Column(name="T001_IP_HOST")
	private String T001_IP_HOST;
	@Column(name="T001_NU_VERSAO_SO")
	private String T001_NU_VERSAO_SO;
	@Column(name="T001_NU_VERSAO_KERNEL")
	private String T001_NU_VERSAO_KERNEL;
	@Column(name="T001_NU_CPU")
	private int T001_NU_CPU;
	@Column(name="T001_NU_NUCLEOS")
	private int T001_NU_NUCLEOS;
	@Column(name="T001_NU_CORES")
	private int T001_NU_CORES;
	@Column(name="T001_MEMORIA_MB")
	private int T001_MEMORIA_MB;	
	
	@ManyToOne
	@JoinColumn(name = "T010_SISTEMA_OPERACIONAL")
	private SistemaOperacional sistemaOperacional;
	
	@ManyToOne
	@JoinColumn(name = "T011_DISCOS_SERVIDOR")
	private DiscosServidor discosServidor;
	
	@ManyToOne
	@JoinColumn(name = "T012_AMBIENTE")
	private Ambiente ambiente;
	
	
	@OneToMany(mappedBy = "servidor")
	private List <Instancia> instancias = new ArrayList<>();
	
	
	
	
	
}