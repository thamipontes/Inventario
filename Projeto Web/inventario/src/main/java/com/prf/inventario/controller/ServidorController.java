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
import com.prf.inventario.model.DiscosServidor;
import com.prf.inventario.model.Servidor;
import com.prf.inventario.service.AmbienteService;
import com.prf.inventario.service.ServidorService;
import com.prf.inventario.service.SistemaOperacionalService;

@Controller
@RequestMapping("/servidores")
public class ServidorController {

	@Autowired
	private ServidorService servidorService;
	
	@Autowired
	private AmbienteService ambienteService;
	
	@Autowired
	private SistemaOperacionalService soService;
	
	@GetMapping("")
	public ModelAndView listaServidores() {
		ModelAndView mv = new ModelAndView("servidores/index");
		Iterable<Servidor> servidores = servidorService.listarServidores();
		mv.addObject("servidores", servidores); 
		return mv;
	}
	
	@GetMapping("novoServidor")
	public ModelAndView novoServidor(Servidor srv) {
		
		ModelAndView mv = new ModelAndView("/servidores/novoServidor");
		mv.addObject("servidor", srv);
		Iterable<Ambiente> ambientes = ambienteService.listarAmbientes();
		mv.addObject("ambientes",ambientes);
		mv.addObject("sistemasOperacionais",soService.listarSistemasOperacionais());
		
		return mv;
	}
	
	@PostMapping("salvarServidor")
	public ModelAndView salvarServidor(@Valid Servidor srv , BindingResult result) {
		if(result.hasErrors()) {
			return novoServidor(srv);
		}
		servidorService.salvarServidor(srv);
		return listaServidores();
	}
	
	@PostMapping("salvarDisco")
	public ModelAndView salvarDisco(@Valid DiscosServidor disco , BindingResult result) {
		if(result.hasErrors()) {
			return editarServidor(disco.getServidor().getIdServidor());
		}
		servidorService.salvarDisco(disco);
		return editarServidor(disco.getServidor().getIdServidor());
	}
		
	@GetMapping("editarServidor/{id}")
	public ModelAndView editarServidor(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/servidores/editarServidor");
		Optional<Servidor> servidor = servidorService.buscarServidor(id);
		mv.addObject("servidor", servidor); 
		Iterable<Ambiente> ambientes = ambienteService.listarAmbientes();
		mv.addObject("ambientes",ambientes);
		mv.addObject("sistemasOperacionais",soService.listarSistemasOperacionais());
		mv.addObject("discos",servidor.get().getDiscosServidor());
		DiscosServidor disco = new DiscosServidor();
		mv.addObject("discoServidor",disco);
		return mv;
	}
}
