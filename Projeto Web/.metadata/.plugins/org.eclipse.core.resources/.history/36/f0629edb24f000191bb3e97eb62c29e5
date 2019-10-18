package com.prf.inventario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prf.inventario.model.Usuario;
import com.prf.inventario.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("usuarios/index");
		Iterable<Usuario> usuarios = usuarioService.listarUsuarios();
		mv.addObject("usuarios", usuarios); 
		return mv;
	}
	
	
	@GetMapping("novoUsuario")
	public ModelAndView novoUsuario(Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("usuarios/novoUsuario");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@PostMapping("salvarUsuario")
	public ModelAndView salvarUsuario(@Valid Usuario usuario , BindingResult result) {
		if(result.hasErrors()) {
			return novoUsuario(usuario);
		}
		usuarioService.salvarUsuario(usuario);
		return listaUsuarios();
	}
	
	@GetMapping("editarUsuario/{id}")
	public ModelAndView editarSistema(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/usuarios/editarUsuario");
		Optional<Usuario> usuario = usuarioService.buscarUsuario(id);
		mv.addObject("usuario", usuario);
		
		return mv;
	}
}
