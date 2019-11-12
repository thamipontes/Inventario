package com.prf.inventario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "T014_LOGIN_PERMISSOES")
public class Permissoes implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "T014_NO_PERMISSAO")
	private String nomePermissao;

	@ManyToOne
	@JsonBackReference	
	@JoinColumn(name = "T013_NO_LOGIN_USUARIO")
	private LoginUsuario loginUsuario;

	// Getter e Setters
	public String getNomePermissao() {
		return nomePermissao;
	}

	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}

	public LoginUsuario getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(LoginUsuario loginUsuario) {
		this.loginUsuario = loginUsuario;
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
		Permissoes other = (Permissoes) obj;
		if (nomePermissao == null) {
			if (other.nomePermissao != null)
				return false;
		} else if (!nomePermissao.equals(other.nomePermissao))
			return false;
		return true;
	}

}