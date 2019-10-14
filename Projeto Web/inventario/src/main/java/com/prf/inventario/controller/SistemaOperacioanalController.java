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

import com.prf.inventario.model.SistemaOperacional;
import com.prf.inventario.service.SistemaOperacionalService;

@Controller
public class SistemaOperacioanalController {

	@Autowired
	private SistemaOperacionalService soService;
	
	
	@RequestMapping(value="/sistemasOperacionais", method=RequestMethod.GET)	
	public ModelAndView listaSistemasOperacionais() {
		ModelAndView mv = new ModelAndView("sistemasOperacionais/index");
		Iterable<SistemaOperacional> sos = soService.listarSistemasOperacionais();
		mv.addObject("sos", sos); 
		return mv;
	}
	
	@RequestMapping(value="/sistemasOperacionais/novoSo", method=RequestMethod.GET)	
	public ModelAndView novoSo(SistemaOperacional so) {
		
		ModelAndView mv = new ModelAndView("/sistemasOperacionais/novoSo");
		mv.addObject("so", so);
		
		return mv;
	}
	
	@RequestMapping(value="/sistemasOperacionais/salvarSo", method=RequestMethod.POST)	
	public ModelAndView salvarSo(@Valid SistemaOperacional so , BindingResult result) {
		if(result.hasErrors()) {
			return novoSo(so);
		}
		soService.salvarSo(so);
		return listaSistemasOperacionais();
	}
	
	@RequestMapping(value="/sistemasOperacionais/editarSo/{id}", method=RequestMethod.GET)
	public ModelAndView editarSo(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/sistemasOperacionais/editarSo");
		Optional<SistemaOperacional> so = soService.buscarSo(id);
		mv.addObject("so", so); 
		return mv;
	}

}
