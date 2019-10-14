package com.prf.inventario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prf.inventario.model.Servidor;
import com.prf.inventario.service.AmbienteService;
import com.prf.inventario.service.ServidorService;
import com.prf.inventario.service.SistemaOperacionalService;

@Controller
public class ServidorController {

	@Autowired
	private ServidorService servidorService;
	
	@Autowired
	private AmbienteService ambienteService;
	
	@Autowired
	private SistemaOperacionalService soService;
	
	@GetMapping(path="/servidores")
	public ModelAndView listaServidores() {
		ModelAndView mv = new ModelAndView("servidores/index");
		Iterable<Servidor> servidores = servidorService.listarServidores();
		mv.addObject("servidores", servidores); 
		return mv;
	}
	
	@RequestMapping(value="/servidores/novoServidor", method=RequestMethod.GET)	
	public ModelAndView novoServidor(Servidor srv) {
		
		ModelAndView mv = new ModelAndView("/servidores/novoServidor");
		mv.addObject("servidor", srv);
		mv.addObject("ambientes",ambienteService.listarAmbientes());
		mv.addObject("sistemasOperacionais",soService.listarSistemasOperacionais());
		
		return mv;
	}
	
	@RequestMapping(value="/servidores/salvarServidor", method=RequestMethod.POST)	
	public ModelAndView salvarServidor(@Valid Servidor srv , BindingResult result) {
		if(result.hasErrors()) {
			return novoServidor(srv);
		}
		servidorService.salvarServidor(srv);
		return listaServidores();
	}
	
	@RequestMapping(value="/servidores/editarServidor/{id}", method=RequestMethod.GET)
	public ModelAndView editarServidor(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/servidores/editarServidor");
		Optional<Servidor> servidor = servidorService.buscarServidor(id);
		mv.addObject("servidor", servidor); 
		return mv;
	}
}
