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
	
	@PostMapping("salvarAmbiente")	
	public ModelAndView salvarAmbiente(@Valid Ambiente ambiente , BindingResult result,HttpSession sessao) {
		Ambiente ambienteSessao = (Ambiente) sessao.getAttribute("ambiente");
		ambiente.setIdAmbiente(ambienteSessao.getIdAmbiente());
		if(result.hasErrors()) {
			return editarAmbiente(ambiente.getIdAmbiente(),sessao);
		}
		ambienteService.salvarAmbiente(ambiente);
		return listaInventario();
	}
	
	@GetMapping("editarAmbiente/{id}")
	public ModelAndView editarAmbiente(@PathVariable("id") int id, HttpSession sessao) {
		ModelAndView mv = new ModelAndView("/ambientes/editarAmbiente");
		Optional <Ambiente> ambiente = ambienteService.buscarAmbiente(id);
		sessao.setAttribute("ambiente", ambiente.get());
		mv.addObject("ambiente", ambiente); 
		return mv;
	}
	
	@PostMapping("deletarAmbiente")
	public String deletarAmbiente(Ambiente ambiente) {
	    ambienteService.deletarAmbiente(ambiente);
	    return "redirect:/ambientes";       
	}

}
