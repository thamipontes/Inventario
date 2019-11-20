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

import com.prf.inventario.model.Sistema;
import com.prf.inventario.service.SistemaService;

@Controller
@RequestMapping("/sistemas")
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;
	
	@GetMapping("")
	public ModelAndView listaSistemas() {
		ModelAndView mv = new ModelAndView("sistemas/index");
		Iterable<Sistema> sistemas = sistemaService.listarSistemas();
		mv.addObject("sistemas", sistemas); 
		return mv;
	}
	
	
	@GetMapping("novoSistema")
	public ModelAndView novoSistema(Sistema sistema) {
		
		ModelAndView mv = new ModelAndView("sistemas/novoSistema");
		mv.addObject("sistema", sistema);
		
		return mv;
	}
	
	@PostMapping("salvarSistema")
	public ModelAndView salvarSistema(@Valid Sistema sistema , BindingResult result) {
		if(result.hasErrors()) {
			return novoSistema(sistema);
		}
		sistemaService.salvarSistema(sistema);
		return listaSistemas();
	}
	
	@GetMapping("editarSistema/{id}")
	public ModelAndView editarSistema(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/sistemas/editarSistema");
		Optional<Sistema> sistema = sistemaService.buscarSistema(id);
		mv.addObject("sistema", sistema);
		
		return mv;
	}
	
}
