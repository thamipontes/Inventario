package com.prf.inventario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Faz a classe DiscosServidor ser uma entidade do banco de dados.
@Entity

@Table(name="T011_DISCOS_SERVIDOR")
public class DiscosServidor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//"Chave Primária"
	@Id 
	//"Autoincremento"
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//"Mapeamento, ou seja, qual é a coluna no banco.
	@Column(name="T011_ID_DISCOS_SERVIDOR")
	private int idDiscosServidor; //Campo idDiscosServidor na tabela DiscosServidor.
	
	@Column(name="T011_PARTICAO_SERVIDOR")
	private String particaoServidor; //Campo particaoServidor na tabela DiscosServidor.
	
	@Column(name="T011_TAMANHO_MB")
	private int tamanhoMB; //Campo tamanhoMb na tabela DiscosServidor.
	
	//Vários servidores para "um" valor de disco.
	@ManyToOne
	//"Chave estrangeira"
	@JoinColumn(name = "T001_ID_SERVIDOR")
	private Servidor servidor;
	
	//Construtor Padrão (instanciar a classe)
	public DiscosServidor () {
		
	}
	
	//Construtor para já atribuir os valores no momento de instanciar.
	public DiscosServidor(int idDiscosServidor, String particaoServidor, int tamanhoMB) {
		super();
		this.idDiscosServidor = idDiscosServidor;
		this.particaoServidor = particaoServidor;
		this.tamanhoMB = tamanhoMB;
	}
	
	
	//Getters e Setters.
	public int getIdDiscosServidor() {
		return idDiscosServidor;
	}

	public void setIdDiscosServidor(int idDiscosServidor) {
		this.idDiscosServidor = idDiscosServidor;
	}

	public String getParticaoServidor() {
		return particaoServidor;
	}

	public void setParticaoServidor(String particaoServidor) {
		this.particaoServidor = particaoServidor;
	}

	public int getTamanhoMB() {
		return tamanhoMB;
	}

	public void setTamanhoMB(int tamanhoMB) {
		this.tamanhoMB = tamanhoMB;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	//HashCode e Equals.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDiscosServidor;
		return result;
	}
	
	//Sobrescrever um método.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscosServidor other = (DiscosServidor) obj;
		if (idDiscosServidor != other.idDiscosServidor)
			return false;
		return true;
	}	
		

}
