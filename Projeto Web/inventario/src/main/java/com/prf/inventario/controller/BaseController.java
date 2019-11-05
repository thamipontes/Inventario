package com.prf.inventario.controller;

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

import com.prf.inventario.model.Base;
import com.prf.inventario.model.Schema;
import com.prf.inventario.service.BaseService;
import com.prf.inventario.service.InstanciaService;
import com.prf.inventario.service.SchemaService;

@Controller
@RequestMapping("/bases")
public class BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private InstanciaService instanciaService;
	
	@Autowired
	private SchemaService schemaService;
	
	@GetMapping("")
	public ModelAndView listaBases() {
		ModelAndView mv = new ModelAndView("bases/index");
		Iterable<Base> bases = baseService.listarBases();
		mv.addObject("bases", bases); 
		return mv;
	}
	
	
	@GetMapping("novaBase")
	public ModelAndView novaBase(Base base) {
		
		ModelAndView mv = new ModelAndView("bases/novaBase");
		mv.addObject("base", base);
		
		// Lista as intancias para selecionar
		mv.addObject("instancias",instanciaService.listarInstancias());
		
		return mv;
	}
	
	@PostMapping("salvarBase")
	public ModelAndView salvarBase(@Valid Base base , BindingResult result) {
		if(result.hasErrors()) {
			return novaBase(base);
		}
		baseService.salvarBase(base);
		return listaBases();
	}
	
	@GetMapping("editarBase/{id}")
	public ModelAndView editarBase(@PathVariable("id") int id, HttpSession sessao) {
		
		ModelAndView mv = new ModelAndView("bases/editarBase");
		
		Optional<Base> base = baseService.buscarBase(id);
		
		// Salva a base na sessao
		sessao.setAttribute("base", base.get());
		mv.addObject("base", base);
		mv.addObject("instancias",instanciaService.listarInstancias());
		
		mv.addObject("schemas",base.get().getSchemas());
		
		// Instancia Schema para adicionar um novo
		Schema schema = new Schema();
		mv.addObject("schema",schema);
				
		return mv;
	}
	
	@PostMapping("salvarSchema")
	public ModelAndView salvarSchema(@Valid Schema schema , BindingResult result, HttpSession sessao) {
		
		// Busca a base na sessão
		Base base = (Base) sessao.getAttribute("base");
		
		// Seta a Base como a base sa sessão
		schema.setBase(base);
		
		if(result.hasErrors()) {
			return editarBase(base.getIdBase(),sessao);
		}
		
		schemaService.salvarSchema(schema);
		return editarBase(base.getIdBase(),sessao);
	}
}
