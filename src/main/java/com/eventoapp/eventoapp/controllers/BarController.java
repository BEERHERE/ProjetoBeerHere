package com.eventoapp.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.models.Bar;

import com.eventoapp.eventoapp.repository.BarRepository;

@Controller
public class BarController {
	@Autowired
	private BarRepository br;
	
	@RequestMapping(value = "/cadastrarBar", method=RequestMethod.GET)
	public String form() {
		return "evento/formBar";
	}
	@RequestMapping(value = "/cadastrarBar", method=RequestMethod.POST)
	public String form(Bar bar) {
		
		br.save(bar);
		
		return "redirect:/cadastrarBar";
	}
	
	@RequestMapping("/bares")
	public ModelAndView listaBar() {
		ModelAndView mv = new ModelAndView("evento/bares");
		Iterable<Bar> bares = br.findAll();
		mv.addObject("bares", bares);
		return mv;
		
	}
	
	@RequestMapping("{id}")
	public ModelAndView detalhesBar(@PathVariable("id")int id) {
		Bar bar = br.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalheBar");
		mv.addObject("bar", bar);
		return mv;
		
	}

	
	

}
	
	
