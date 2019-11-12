package com.prf.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T013_LOGIN_USUARIO")
public class LoginUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "T013_NO_LOGIN_USUARIO")
	private String nomeLogin;

	@Column(name = "T013_PWD_LOGIN_USUARIO", nullable = false)
	private String senhaLogin;

	@Column(name = "T013_ATIVO", nullable = false)
	private boolean ativo;

	@JsonManagedReference
	@OneToMany(mappedBy = "loginUsuario")
	private List<Permissoes> permissoes = new ArrayList<>();

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public String getSenhaLogin() {
		return senhaLogin;
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	// HashCode e Equals

	public List<Permissoes> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissoes> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeLogin == null) ? 0 : nomeLogin.hashCode());
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
		LoginUsuario other = (LoginUsuario) obj;
		if (nomeLogin == null) {
			if (other.nomeLogin != null)
				return false;
		} else if (!nomeLogin.equals(other.nomeLogin))
			return false;
		return true;
	}

}
