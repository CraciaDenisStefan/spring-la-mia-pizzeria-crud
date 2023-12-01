package org.java.spring.controller;

import java.util.List;
import org.java.spring.db.pojo.Pizzeria;
import org.java.spring.db.serve.Pizzeriaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private Pizzeriaservice pizzeriaService;
	
	@GetMapping("/")
	public String getPizze(Model model,@RequestParam(required = false) String search) {
		
		List<Pizzeria> pizze = search == null  
				? pizzeriaService.findAll()
				: pizzeriaService.findByNome(search);
		
		model.addAttribute("pizze", pizze);
		model.addAttribute("search", search == null ? "" : search);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizza(Model model,
			@PathVariable int id) {
		
		Pizzeria pizza = pizzeriaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
}
