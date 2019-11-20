package com.prf.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "T014_PERMISSAO")
public class Permissao implements GrantedAuthority, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "T014_NO_PERMISSAO")
	private String nomePermissao;

	
	@ManyToMany(mappedBy = "permissoes")
	private List <LoginUsuario> loginUsuarios = new ArrayList<LoginUsuario> ();
	
	public Permissao () {
		
	}
	
	public Permissao(String nomePermissao) {
		super();
		this.nomePermissao = nomePermissao;
	}

	// Getter e Setters
	public String getNomePermissao() {
		return nomePermissao;
	}

	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}
	
	public List<LoginUsuario> getLoginUsuarios() {
		return loginUsuarios;
	}

	public void setLoginUsuarios(List<LoginUsuario> loginUsuarios) {
		this.loginUsuarios = loginUsuarios;
	}


	// HashCode e Equals

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePermissao == null) ? 0 : nomePermissao.hashCode());
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
		Permissao other = (Permissao) obj;
		if (nomePermissao == null) {
			if (other.nomePermissao != null)
				return false;
		} else if (!nomePermissao.equals(other.nomePermissao))
			return false;
		return true;
	}

	@Override
	public String getAuthority() {
		
		return this.nomePermissao;
	}

}