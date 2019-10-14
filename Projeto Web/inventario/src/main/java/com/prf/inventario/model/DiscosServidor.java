package com.prf.inventario.model;

import java.io.Serializable;
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
@Table(name="T011_DISCOS_SERVIDOR")
public class DiscosServidor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public DiscosServidor(int id_discos_servidor, String particao_servidor, int tamanho_MB) {
		super();
		this.idDiscosServidor = id_discos_servidor;
		this.particaoServidor = particao_servidor;
		this.tamanhoMB = tamanho_MB;
	}

	public int getId_discos_servidor() {
		return idDiscosServidor;
	}

	public void setId_discos_servidor(int id_discos_servidor) {
		this.idDiscosServidor = id_discos_servidor;
	}

	public String getParticao_servidor() {
		return particaoServidor;
	}

	public void setParticao_servidor(String particao_servidor) {
		this.particaoServidor = particao_servidor;
	}

	public int getTamanho_MB() {
		return tamanhoMB;
	}

	public void setTamanho_MB(int tamanho_MB) {
		this.tamanhoMB = tamanho_MB;
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
