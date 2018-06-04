package com.eventoapp.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.models.Bar;
import com.eventoapp.eventoapp.models.Cerveja;
import com.eventoapp.eventoapp.models.Tipo;
import com.eventoapp.eventoapp.repository.CervejaRepository;
import com.eventoapp.eventoapp.repository.TipoRepository;

@Controller
public class TipoController {
	
	@Autowired
	private TipoRepository tp;
	
	@Autowired
	private CervejaRepository cr;
	
	@RequestMapping(value = "/cadastrarTipo", method=RequestMethod.GET)
	public String form() {
		return "evento/formTipo";
	}
	@RequestMapping(value = "/cadastrarTipo", method=RequestMethod.POST)
	public String form(Tipo tipo) {
		
		tp.save(tipo);
		
		return "redirect:/cadastrarTipo";
	}
	
	@RequestMapping("/tipos")
	public ModelAndView listaTipos() {
		ModelAndView mv = new ModelAndView("evento/tipos");
		Iterable<Tipo> tipos = tp.findAll();
		mv.addObject("tipos", tipos);
		return mv;
		
	}
	
	@RequestMapping(value= "/{codigo}",method=RequestMethod.GET )
	public ModelAndView detalhesTipo(@PathVariable("codigo")long codigo) {
		Tipo tipo = tp.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalheTipo");
		mv.addObject("tipo", tipo);		
		Iterable<Cerveja> cervejas = cr.findByTipo(tipo);
		mv.addObject("cervejas",cervejas);
		return mv;
		
	}
	
	@RequestMapping(value= "/{codigo}",method=RequestMethod.POST )
	public String detalhesTipoPost(@PathVariable("codigo")long codigo, Cerveja cerveja) {
		Tipo tipo = tp.findByCodigo(codigo);
		cerveja.setTipo(tipo);
		cr.save(cerveja);	
		return "redirect:/{codigo}";
		
	}
	
	@RequestMapping("/news")
	public String listaTipos1() {
		
		
		return "evento/noticias";
	}
	

	

}


