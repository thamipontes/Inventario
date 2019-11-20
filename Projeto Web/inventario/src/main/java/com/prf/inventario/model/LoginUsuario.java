package com.prf.inventario.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "T013_LOGIN_USUARIO")
public class LoginUsuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "T013_NO_LOGIN_USUARIO")
	private String nomeLogin;

	@Column(name = "T013_PWD_LOGIN_USUARIO", nullable = false)
	private String senhaLogin;

	@Column(name = "T013_ATIVO", nullable = false)
	private boolean ativo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "T015_LOGIN_USUARIO_PERMISSAO", joinColumns = @JoinColumn(name = "T013_NO_LOGIN_USUARIO"), inverseJoinColumns = @JoinColumn(name = "T014_NO_PERMISSAO"))
	private List<Permissao> permissoes = new ArrayList<Permissao>();
	
	public LoginUsuario () {
		
	}
	
	

	public LoginUsuario(String nomeLogin, String senhaLogin, boolean ativo) {
		super();
		this.nomeLogin = nomeLogin;
		this.senhaLogin = senhaLogin;
		this.ativo = ativo;
	}



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

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.permissoes;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senhaLogin;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nomeLogin;

	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
