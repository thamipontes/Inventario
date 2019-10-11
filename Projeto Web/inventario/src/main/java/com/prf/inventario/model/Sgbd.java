package com.prf.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T006_SGBD")
public class Sgbd implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="T006_ID_SGBD")
	private int idSgbd;	
	
	@Column(name="T006_NO_SGBD")
	private String nomeSgbd;
	
	@OneToMany(mappedBy = "sgbd")
	private List <Instancia> instancias= new ArrayList<>();

	public Sgbd () {
		
	}
	
	public Sgbd(int idSgbd, String nomeSgbd) {
		super();
		this.idSgbd = idSgbd;
		this.nomeSgbd = nomeSgbd;
	}

	public int getIdSgbd() {
		return idSgbd;
	}

	public void setIdSgbd(int idSgbd) {
		this.idSgbd = idSgbd;
	}

	public String getNomeSgbd() {
		return nomeSgbd;
	}

	public void setNomeSgbd(String nomeSgbd) {
		this.nomeSgbd = nomeSgbd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSgbd;
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
		Sgbd other = (Sgbd) obj;
		if (idSgbd != other.idSgbd)
			return false;
		return true;
	}	
	
}
