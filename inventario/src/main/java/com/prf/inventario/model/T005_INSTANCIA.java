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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class T005_INSTANCIA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long T005_ID_INSTANCIA;	
	
	private String T005_NO_INSTANCIA;
	private String T005_DE_INSTANCIA;
	private Date T005_DT_CRIACAO;
	private Date T005_DT_INATIVACAO;
	private boolean T005_IS_ATIVO;
	private String T005_NU_VERSAO_SGBD;
	private int T005_NU_PORTA;
	private String T005_LOCAL_INSTALACAO;
	
	@ManyToOne
	@JoinColumn(name = "T006_SGBD")
	private T006_SGBD t006_sgbd;
	
	@ManyToOne
	@JoinColumn(name = "T001_SERVIDOR")
	private T001_SERVIDOR t001_servidor;
	
	@OneToMany(mappedBy = "t005_instancia")
	private List <T002_BASE> bases=new ArrayList<>();
	
	
	public long getT005_ID_INSTANCIA() {
		return T005_ID_INSTANCIA;
	}
	public void setT005_ID_INSTANCIA(long t005_ID_INSTANCIA) {
		T005_ID_INSTANCIA = t005_ID_INSTANCIA;
	}
	public String getT005_NO_INSTANCIA() {
		return T005_NO_INSTANCIA;
	}
	public void setT005_NO_INSTANCIA(String t005_NO_INSTANCIA) {
		T005_NO_INSTANCIA = t005_NO_INSTANCIA;
	}
	public String getT005_DE_INSTANCIA() {
		return T005_DE_INSTANCIA;
	}
	public void setT005_DE_INSTANCIA(String t005_DE_INSTANCIA) {
		T005_DE_INSTANCIA = t005_DE_INSTANCIA;
	}
	public Date getT005_DT_CRIACAO() {
		return T005_DT_CRIACAO;
	}
	public void setT005_DT_CRIACAO(Date t005_DT_CRIACAO) {
		T005_DT_CRIACAO = t005_DT_CRIACAO;
	}
	public Date getT005_DT_INATIVACAO() {
		return T005_DT_INATIVACAO;
	}
	public void setT005_DT_INATIVACAO(Date t005_DT_INATIVACAO) {
		T005_DT_INATIVACAO = t005_DT_INATIVACAO;
	}
	public boolean isT005_IS_ATIVO() {
		return T005_IS_ATIVO;
	}
	public void setT005_IS_ATIVO(boolean t005_IS_ATIVO) {
		T005_IS_ATIVO = t005_IS_ATIVO;
	}
	public String getT005_NU_VERSAO_SGBD() {
		return T005_NU_VERSAO_SGBD;
	}
	public void setT005_NU_VERSAO_SGBD(String t005_NU_VERSAO_SGBD) {
		T005_NU_VERSAO_SGBD = t005_NU_VERSAO_SGBD;
	}
	public int getT005_NU_PORTA() {
		return T005_NU_PORTA;
	}
	public void setT005_NU_PORTA(int t005_NU_PORTA) {
		T005_NU_PORTA = t005_NU_PORTA;
	}
	public String getT005_LOCAL_INSTALACAO() {
		return T005_LOCAL_INSTALACAO;
	}
	public void setT005_LOCAL_INSTALACAO(String t005_LOCAL_INSTALACAO) {
		T005_LOCAL_INSTALACAO = t005_LOCAL_INSTALACAO;
	}
	public T006_SGBD getT006_sgbd() {
		return t006_sgbd;
	}
	public void setT006_sgbd(T006_SGBD t006_sgbd) {
		this.t006_sgbd = t006_sgbd;
	}
	public T001_SERVIDOR getT001_servidor() {
		return t001_servidor;
	}
	public void setT001_servidor(T001_SERVIDOR t001_servidor) {
		this.t001_servidor = t001_servidor;
	}
	public List<T002_BASE> getBases() {
		return bases;
	}
	public void setBases(List<T002_BASE> bases) {
		this.bases = bases;
	}	
	
	

}