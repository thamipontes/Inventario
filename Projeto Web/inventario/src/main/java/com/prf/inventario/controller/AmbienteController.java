package com.prf.inventario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prf.inventario.model.Ambiente;
import com.prf.inventario.service.AmbienteService;

@Controller
public class AmbienteController {

	@Autowired
	private AmbienteService ambienteService;
	
	@RequestMapping(value="/ambientes", method=RequestMethod.GET)	
	public ModelAndView listaInventario() {
		ModelAndView mv = new ModelAndView("ambientes/index");
		Iterable<Ambiente> ambientes = ambienteService.listarAmbientes();
		mv.addObject("ambientes", ambientes); 
		return mv;
	}
	
	@RequestMapping(value="/ambientes/novoAmbiente", method=RequestMethod.GET)	
	public ModelAndView novoAmbiente(Ambiente ambiente) {
		
		ModelAndView mv = new ModelAndView("/ambientes/novoAmbiente");
		mv.addObject("ambiente", ambiente);
		
		return mv;
	}
	
	@RequestMapping(value="/ambientes/addAmbiente", method=RequestMethod.POST)	
	public ModelAndView addAmbiente(@Valid Ambiente ambiente , BindingResult result) {
		if(result.hasErrors()) {
			return novoAmbiente(ambiente);
		}
		ambienteService.SalvarAmbiente(ambiente);
		return listaInventario();
	}
	
	@RequestMapping(value="/ambientes/detalhesAmbiente/{id}", method=RequestMethod.GET)
	public ModelAndView addAmbiente(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/ambientes/detalhesAmbiente");
		Optional <Ambiente> ambiente = ambienteService.buscarAmbiente(id);
		mv.addObject("ambiente", ambiente); 
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
