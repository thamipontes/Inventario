package com.prf.inventario.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.prf.inventario.model.Schema;
import com.prf.inventario.model.Sistema;
import com.prf.inventario.service.SchemaService;
import com.prf.inventario.service.SistemaService;

@Controller
@RequestMapping("/sistemas")
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;

	@Autowired
	private SchemaService schemaService;

	@GetMapping("")
	public ModelAndView listaSistemas() {
		ModelAndView mv = new ModelAndView("sistemas/index");
		Iterable<Sistema> sistemas = sistemaService.listarSistemas();
		mv.addObject("sistemas", sistemas);
		return mv;
	}

	@GetMapping("novoSistema")
	public ModelAndView novoSistema(Sistema sistema, HttpSession sessao) {

		ModelAndView mv = new ModelAndView("/sistemas/novoSistema");
		mv.addObject("sistema", sistema);
		sessao.setAttribute("sistema", null);

		return mv;
	}

	@PostMapping("salvarSistema")
	public ModelAndView salvarSistema(@Valid Sistema sistema, BindingResult result, HttpSession sessao) {
		Sistema sistemaOld = (Sistema) sessao.getAttribute("sistema");
		if (sistemaOld != null) {
			sistema.setIdSistema(sistemaOld.getIdSistema());
			if (result.hasErrors()) {
				return editarSistema(sistema.getIdSistema(), sessao);
			}
		} else {
			// Se der erro ao alterar um novo servidor
			if (result.hasErrors()) {
				return novoSistema(sistema, sessao);
			}
		}
		sistemaService.salvarSistema(sistema);
		return listaSistemas();

	}

	@GetMapping("editarSistema/{id}")
	public ModelAndView editarSistema(@PathVariable("id") int id, HttpSession sessao) {
		ModelAndView mv = new ModelAndView("/sistemas/editarSistema");
		Optional<Sistema> sistema = sistemaService.buscarSistema(id);
		mv.addObject("sistema", sistema);
		sessao.setAttribute("sistema", sistema.get());

		Schema schema = new Schema();
		mv.addObject("schema", schema);

		// Lista de schemas disponíveis
		Iterable<Schema> todosSchemas = schemaService.listarSchema();
		List <Schema> schemasSistema = sistema.get().getSchemas();
		List <Schema> schemasRestantes = new ArrayList<>();
		for (Schema schemaIterable : todosSchemas) {
			if(!schemasSistema.contains(schemaIterable)){
				schemasRestantes.add(schemaIterable);
			}
		}
		
		mv.addObject("schemasRestantes",schemasRestantes);
		mv.addObject("schemas",schemasSistema);
		

		return mv;
	}
	
	@PostMapping("vincularSchema")
	public ModelAndView vincularSchema(@Valid Schema schemaForm, BindingResult result, HttpSession sessao) {		
		Sistema  sistema = (Sistema) sessao.getAttribute("sistema");		
		Optional <Schema> schemaOpt = schemaService.buscarSchema(schemaForm.getIdSchema());		
		Schema schema = schemaOpt.get();		
		List <Sistema> sistemas = new ArrayList();		
		sistemas.add(sistema);		
		schema.setSistemas(sistemas);
		
		if(result.hasErrors()) {
			return editarSistema(sistema.getIdSistema(),sessao);
		}
				
		//List <Schema>  schemasSistemas = sistema.getSchemas();
		//schemasSistemas.add(schema);
		//sistema.setSchemas(schemasSistemas);
		
		//sistemaService.salvarSistema(sistema);
		
		
		schemaService.salvarSchema(schema);
		
		return editarSistema(sistema.getIdSistema(),sessao);
	}
	

	@GetMapping("exibirSistema/{id}")
	public ModelAndView exibirBase(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("/sistemas/exibirSistema");

		Optional<Sistema> sistema = sistemaService.buscarSistema(id);
		mv.addObject("sistema", sistema.get());

		return mv;
	}

}
