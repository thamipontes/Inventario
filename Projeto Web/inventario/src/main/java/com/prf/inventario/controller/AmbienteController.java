package com.prf.inventario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prf.inventario.model.Ambiente;
import com.prf.inventario.repository.AmbienteRepository;

@Controller
public class AmbienteController {

	@Autowired
	private AmbienteRepository ar;
	
	@RequestMapping(value="/ambientes", method=RequestMethod.GET)	
	public ModelAndView listaInventario() {
		ModelAndView mv = new ModelAndView("ambiente/index");
		Iterable<Ambiente> ambientes = ar.findAll();
		mv.addObject("ambientes", ambientes); 
		return mv;
	}
	
	@RequestMapping(value="/ambiente/novoAmbiente", method=RequestMethod.GET)	
	public String novoAmbiente(Ambiente ambiente) {
		
		return "novoAmbiente";
	}
	
	@RequestMapping(value="/ambiente/addAmbiente", method=RequestMethod.POST)	
	public ModelAndView addAmbiente(@Valid Ambiente ambiente) {
		ar.save(ambiente);
		ModelAndView mv = new ModelAndView("ambiente/index");
		Iterable<Ambiente> ambientes = ar.findAll();
		mv.addObject("ambientes", ambientes); 
		return mv;
	}
}
