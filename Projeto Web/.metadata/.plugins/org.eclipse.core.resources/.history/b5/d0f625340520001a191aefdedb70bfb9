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

import com.prf.inventario.model.Instancia;
import com.prf.inventario.model.Sgbd;
import com.prf.inventario.service.InstanciaService;
import com.prf.inventario.service.ServidorService;
import com.prf.inventario.service.SgbdService;

@Controller
@RequestMapping("/instancias")
public class InstanciaController {
	
	@Autowired
	private InstanciaService instanciaService;
	
	@Autowired
	private ServidorService servidorService;
	
	@Autowired
	private SgbdService sgbdService;
	
	@GetMapping("")
	public ModelAndView listaInstancias() {
		ModelAndView mv = new ModelAndView("instancias/index");
		Iterable<Instancia> instancias = instanciaService.listarInstancias();
		mv.addObject("instancias", instancias); 
		return mv;
	}
	
	/*
	@GetMapping("novaInstancia")
	public ModelAndView novaInstancia(Instancia instancia) {
		
		ModelAndView mv = new ModelAndView("instancias/novaInstancia");
		mv.addObject("instancia", instancia);
		mv.addObject("sgbds",sgbdService.listarSgbds());
		mv.addObject("servidores",servidorService.listarServidores());
		
		return mv;
	}
	
	*/
	
	
	/*
	@PostMapping("salvarInstancia")
	public ModelAndView salvarInstancia(@Valid Instancia instancia , BindingResult result) {
		if(result.hasErrors()) {
			return novaInstancia(instancia);
		}
		instanciaService.salvarInstancia(instancia);
		return listaInstancias();
	}
	*/
	
	@GetMapping("novaInstancia")
	public ModelAndView novaInstancia(Instancia srv, HttpSession sessao) {
		
		ModelAndView mv = new ModelAndView("/servidores/novaInstancia");
		mv.addObject("instancia", srv);
		Iterable<Sgbd> sgbds = sgbdService.listarSgbds();
		mv.addObject("sgbds",sgbds);
		mv.addObject("servidores",servidorService.listarServidores());
		sessao.setAttribute("instancia", null);
		return mv;
	}
	
	@PostMapping("salvarInstancia")
	public ModelAndView salvarInstancia(@Valid Instancia srv , BindingResult result, HttpSession sessao) {
		Instancia  instanciaOld = (Instancia) sessao.getAttribute("instancia");
		// Se for null significa que é um novo servidor.
		// Se já existe, está alterando um existente.
		if(instanciaOld != null) {
			srv.setIdInstancia(instanciaOld.getIdInstancia());
			// Se der erro ao alterar um servidor existente
			if(result.hasErrors()) {
				return editarInstancia(srv.getIdInstancia(),sessao);
			}
		} else {
			// Se der erro ao alterar um novo servidor
			if(result.hasErrors()) {
				return novaInstancia(srv,sessao);
			}
		}

		instanciaService.salvarInstancia(srv);
		return listaInstancias();
	}
	
	/*
	@GetMapping("editarInstancia/{id}")
	public ModelAndView editarInstancia(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("instancias/editarInstancia");
		
		Optional<Instancia> instancia = instanciaService.buscarInstancia(id);
		mv.addObject("instancia", instancia);
		mv.addObject("sgbds",sgbdService.listarSgbds());
		mv.addObject("servidores",servidorService.listarServidores());
				
		return mv;
	}
	*/
	
	@GetMapping("editarInstancia/{id}")
	public ModelAndView editarInstancia(@PathVariable("id") int id ,HttpSession sessao) {
		ModelAndView mv = new ModelAndView("/instancias/editarInstancia");
		Optional<Instancia> instancia = instanciaService.buscarInstancia(id);
		mv.addObject("instancia", instancia); 
		Iterable<Sgbd> sgbds = sgbdService.listarSgbds();
		mv.addObject("sgbds",sgbds);
		mv.addObject("servidores",servidorService.listarServidores());
		sessao.setAttribute("instancia", instancia.get());
		
		return mv;
	}
	
	@PostMapping("deletarInstancia")
	public String deletarInstancia(Instancia instancia) {
	    instanciaService.deletarInstancia(instancia);
	    return "redirect:/instancias";       
	}
	
	@GetMapping("exibirInstancia/{id}")
	public ModelAndView exibirInstancia(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("instancias/exibirInstancia");
		
		Optional<Instancia> instancia = instanciaService.buscarInstancia(id);
		mv.addObject("instancia", instancia.get());
				
		return mv;
	}
	
}
