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

@Entity
@Table(name="T011_DISCOS_SERVIDOR")
public class DiscosServidor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="T011_ID_DISCOS_SERVIDOR")
	private int idDiscosServidor;	
	
	@Column(name="T011_PARTICAO_SERVIDOR")
	private String particaoServidor;
	
	@Column(name="T011_TAMANHO_MB")
	private int tamanhoMB;
	
	@ManyToOne
	@JoinColumn(name = "T001_ID_SERVIDOR")
	private Servidor servidor;

	public DiscosServidor () {
		
	}
	
	public DiscosServidor(int idDiscosServidor, String particaoServidor, int tamanhoMB) {
		super();
		this.idDiscosServidor = idDiscosServidor;
		this.particaoServidor = particaoServidor;
		this.tamanhoMB = tamanhoMB;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDiscosServidor;
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
		DiscosServidor other = (DiscosServidor) obj;
		if (idDiscosServidor != other.idDiscosServidor)
			return false;
		return true;
	}	
		

}
