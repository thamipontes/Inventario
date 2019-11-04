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

import com.prf.inventario.model.Ambiente;
import com.prf.inventario.service.AmbienteService;

@Controller
@RequestMapping("/ambientes")
public class AmbienteController {

	@Autowired
	private AmbienteService ambienteService;
	
	@GetMapping("")	
	public ModelAndView listaInventario() {
		ModelAndView mv = new ModelAndView("ambientes/index");
		Iterable<Ambiente> ambientes = ambienteService.listarAmbientes();
		mv.addObject("ambientes", ambientes); 
		return mv;
	}
	
	@GetMapping("novoAmbiente")
	public ModelAndView novoAmbiente(Ambiente ambiente) {
		
		ModelAndView mv = new ModelAndView("/ambientes/novoAmbiente");
		mv.addObject("ambiente", ambiente);
		
		return mv;
	}
	
	@PostMapping("addAmbiente")	
	public ModelAndView addAmbiente(@Valid Ambiente ambiente , BindingResult result) {
		if(result.hasErrors()) {
			return novoAmbiente(ambiente);
		}
		ambienteService.salvarAmbiente(ambiente);
		return listaInventario();
	}
	
	@GetMapping("editarAmbiente/{id}")
	public ModelAndView addAmbiente(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/ambientes/editarAmbiente");
		Optional <Ambiente> ambiente = ambienteService.buscarAmbiente(id);
		mv.addObject("ambiente", ambiente); 
		return mv;
	}
	
	@PostMapping("deletarAmbiente")
	public String deletarAmbiente(Ambiente ambiente) {
	    ambienteService.deletarAmbiente(ambiente);
	    return "redirect:/ambientes";       
	}

}
