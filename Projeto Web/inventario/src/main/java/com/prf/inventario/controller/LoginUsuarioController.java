package com.prf.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prf.inventario.model.LoginUsuario;
import com.prf.inventario.model.Permissao;
import com.prf.inventario.service.LoginUsuarioService;

@Controller
@RequestMapping("/login")
public class LoginUsuarioController {
	
	@Autowired
	private LoginUsuarioService loginUsuarioService;

	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@GetMapping("index")
	public ModelAndView listaLogins() {
		ModelAndView mv = new ModelAndView("login/index");
		Iterable<LoginUsuario> loginUsuarios = loginUsuarioService.listarLoginUsuarios();
		mv.addObject("loginUsuarios", loginUsuarios); 
		return mv;
	}
	
	
	@GetMapping("novoLoginUsuario")
	public ModelAndView novoLoginUsuario(LoginUsuario loginUsuario) {
		
		ModelAndView mv = new ModelAndView("login/novoLoginUsuario");
		mv.addObject("loginUsuario", loginUsuario);		
		return mv;
	}
	
	@PostMapping("salvarLoginUsuario")
	public ModelAndView salvarUsuario(@Valid LoginUsuario loginUsuario , BindingResult result) {
		if(result.hasErrors()) {
			return novoLoginUsuario(loginUsuario);
		}
		loginUsuario.setSenhaLogin(PasswordEncoder.encode(loginUsuario.getPassword()));
		loginUsuarioService.salvarLoginUsuario(loginUsuario);
		return listaLogins();
	}
	
	@GetMapping("editarLoginUsuario/{nomeLogin}")
	public ModelAndView editarLoginUsuario(@PathVariable("nomeLogin") String nomeLogin, HttpSession sessao) {
		ModelAndView mv = new ModelAndView("/login/editarLoginUsuario");
		Optional<LoginUsuario> loginUsuario = loginUsuarioService.buscarLoginUsuario(nomeLogin);
		mv.addObject("loginUsuario", loginUsuario);
		
		sessao.setAttribute("loginUsuario", loginUsuario.get());
		
		Permissao permissao = new Permissao ();		
		mv.addObject("permissao",permissao);
		
		Iterable <Permissao> todasPermissoes = loginUsuarioService.listarPermissao();
		List <Permissao> permissoesUsuario = loginUsuario.get().getPermissoes();
		List <Permissao> permissoesRestantes = new ArrayList<>();
		for (Permissao permissaoIterable : todasPermissoes) {
			if(!permissoesUsuario.contains(permissaoIterable)){
				permissoesRestantes.add(permissaoIterable);
			}
		}
		mv.addObject("permissoesRestantes",permissoesRestantes);
		mv.addObject("permissoes",permissoesUsuario);
		//O nome não muda porque ele é um ID, apenas pode trocar a senha.
				
		return mv;
	}	
	
	
	@PostMapping("salvarPermissao")
	public ModelAndView salvarPermissao(@Valid Permissao permissao , BindingResult result, HttpSession sessao) {
		LoginUsuario  loginUsuario = (LoginUsuario) sessao.getAttribute("loginUsuario");
		List <Permissao> permissoes = loginUsuario.getPermissoes();
		
		if(result.hasErrors()) {
			return editarLoginUsuario(loginUsuario.getNomeLogin(),sessao);
		}
		
		permissoes.add(permissao);
		loginUsuario.setPermissoes(permissoes);
		loginUsuarioService.salvarLoginUsuario(loginUsuario);
		return editarLoginUsuario(loginUsuario.getNomeLogin(),sessao);
	}
	
}