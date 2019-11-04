package com.prf.inventario.controller;

import java.sql.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prf.inventario.model.IdSchemaUsuario;
import com.prf.inventario.model.Schema;
import com.prf.inventario.model.SchemaUsuario;
import com.prf.inventario.model.Usuario;
import com.prf.inventario.service.SchemaService;
import com.prf.inventario.service.SchemaUsuarioService;
import com.prf.inventario.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SchemaService schemaService;
	
	@Autowired
	private SchemaUsuarioService SchemaUsuarioService;
	
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
	

	@PostMapping("salvarSchemaUsuario")
	public ModelAndView salvarSchemaUsuario(@Valid SchemaUsuario schemaUsuario, BindingResult result, HttpSession sessao) {
		
		// Preenche o ID do usuário
		Usuario  usuario = (Usuario) sessao.getAttribute("usuario");
		IdSchemaUsuario idsu = new IdSchemaUsuario();
		idsu.setUsuario(usuario);
		idsu.setSchema(schemaUsuario.getSchema());
		schemaUsuario.setId(idsu);
		
		// Preenche da data de criação como a data atual
		java.util.Date dataAtual = new java.util.Date();
		Date data = new Date(dataAtual.getTime());
		schemaUsuario.setDataCriacao(data);
		
		// Salva Sempre como Ativo
		schemaUsuario.setAtivo(true);
		
		if(result.hasErrors()) {
			return editarUsuario(usuario.getIdUsuario(),sessao);
		}
		
		SchemaUsuarioService.salvarSchemaUsuario(schemaUsuario);
				
		return editarUsuario(usuario.getIdUsuario(),sessao);
	}
	
	@GetMapping("editarUsuario/{id}")
	public ModelAndView editarUsuario(@PathVariable("id") int id, HttpSession sessao) {
		ModelAndView mv = new ModelAndView("/usuarios/editarUsuario");
		Optional<Usuario> usuario = usuarioService.buscarUsuario(id);
		mv.addObject("usuario", usuario);
		
		sessao.setAttribute("usuario", usuario.get());
		
		// Lista para tabela de relação de usuários com schemas
		mv.addObject("schemasUsuario",usuario.get().getSchemasUsuarios());
		
		// Objeto para criação de relação entre schema e usuário
		SchemaUsuario schemaUsuario = new SchemaUsuario();
		mv.addObject("schemaUsuario",schemaUsuario);
		
		// Lista de schemas disponíveis
		Iterable <Schema> schemas = schemaService.listarSchema();
		mv.addObject("schemas",schemas);
				
		return mv;
	}	
	
}
