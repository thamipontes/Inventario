package com.prf.Chamado.controller;

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

import com.prf.Chamado.model.TipoChamado;
import com.prf.Chamado.service.TipoChamadoService;

@Controller
@RequestMapping("/tipoChamado")
public class TipoChamadoController {

	@Autowired
	private TipoChamadoService tcs;
	
	@GetMapping("")	
	public ModelAndView listaTipoChamado() {
		ModelAndView mv = new ModelAndView("tipoChamado/index");
		Iterable<TipoChamado> tipoChamado = tcs.listarTipoChamado();
		mv.addObject("tipoChamado", tipoChamado); 
		return mv;
	}
	
	@GetMapping("novoTipoChamado")
	public ModelAndView novoTipoChamado(TipoChamado tipoChamado) {
		
		ModelAndView mv = new ModelAndView("/tipoChamado/novoTipoChamado");
		mv.addObject("tipoChamado", tipoChamado);
		
		return mv;
	}
	
	@PostMapping("addTipoChamado")	
	public ModelAndView addTipoChamado(@Valid TipoChamado tipoChamado , BindingResult result) {
		if(result.hasErrors()) {
			return novoTipoChamado(tipoChamado);
		}
		tcs.salvarTipoChamado(tipoChamado);
		return listaTipoChamado();
	}
	
	@PostMapping("salvarTipoChamado")	
	public ModelAndView salvarTipoChamado(@Valid TipoChamado tipoChamado , BindingResult result,HttpSession sessao) {
		TipoChamado tipoChamadoSessao = (TipoChamado) sessao.getAttribute("tipoChamado");
		tipoChamado.setIdTipoChamado(tipoChamadoSessao.getIdTipoChamado());
		if(result.hasErrors()) {
			return editarTipoChamado(tipoChamado.getIdTipoChamado(),sessao);
		}
		tcs.salvarTipoChamado(tipoChamado);
		return listaTipoChamado();
	}
	
	@GetMapping("editarTipoChamado/{id}")
	public ModelAndView editarTipoChamado(@PathVariable("id") int id, HttpSession sessao) {
		ModelAndView mv = new ModelAndView("/tipoChamado/editarTipoChamado");
		Optional <TipoChamado> tipoChamado = tcs.buscarTipoChamado(id);
		sessao.setAttribute("tipoChamado", tipoChamado.get());
		mv.addObject("tipoChamado", tipoChamado); 
		return mv;
	}
	
	@PostMapping("deletarTipoChamado")
	public String deletarTipoChamado(TipoChamado tipoChamado) {
	    tcs.deletarTipoChamado(tipoChamado);
	    return "redirect:/tipoChamado";       
	}

}
