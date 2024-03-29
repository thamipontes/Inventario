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

import com.prf.inventario.model.Sgbd;
import com.prf.inventario.service.SgbdService;

@Controller
@RequestMapping("/sgbds")
public class SgbdController {
	
	
	
	
	//"Instanciar" automaticamente.
	@Autowired
	private SgbdService ss;

	
	//Parâmetros via URL
	@GetMapping("")	
	public ModelAndView listaSgbd() {
		//Instaciando um objeto.
		ModelAndView mv = new ModelAndView("sgbds/index");
		//Criando um array (lista)
		Iterable<Sgbd> sgbds = ss.listarSgbds();
		
		
		//Vai adicionar esse objeto na página.
		mv.addObject("sgbds", sgbds); //Os parâmetros são: a variável - que recebeu listarSgbds - e nome na view (index).
		return mv;
	}
	
	@GetMapping("novoSgbd")	
	public ModelAndView novoSgbd(Sgbd sgbd) {		
		ModelAndView mv = new ModelAndView("sgbds/novoSgbd");
		mv.addObject("sgbd", sgbd);		
		return mv;
	}
	
	@PostMapping("salvarSgbd")
	public String salvarSgbd(@Valid Sgbd sgbd , BindingResult result) {
		//Se apresentar erro; retorna o método novoSgbd, senão retorna o método listaSgbd (terá salvo).
		if(result.hasErrors()) {
			return "redirect:/sgbds/novoSgbd";
		}
		ss.salvarSgbd(sgbd);
		return "redirect:/sgbds";
	}
	
	
	@GetMapping("editarSgbd/{id}")
	public ModelAndView editaSgbd(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/sgbds/editarSgbd");
		//Variável recebe a busca (id) para a edição.
		Optional <Sgbd> sgbd = ss.buscarSgbd(id);
		mv.addObject("sgbd", sgbd); 
		return mv;
	}
	
	@PostMapping("deletarSgbd")
	public String deletarSgbd(Sgbd sgbd) {
	    ss.deletarSgbd(sgbd);
	    return "redirect:/sgbds";       
	}
	

}