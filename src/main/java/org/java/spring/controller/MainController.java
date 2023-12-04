package org.java.spring.controller;

import java.util.List; 
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serve.Pizzeriaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private Pizzeriaservice pizzeriaService;
	
	@GetMapping("/")
	public String getPizze(Model model,@RequestParam(required = false) String search) {
		
		List<Pizza> pizze = search == null  
				? pizzeriaService.findAll()
				: pizzeriaService.findByNome(search);
		
		model.addAttribute("pizze", pizze);
		model.addAttribute("search", search == null ? "" : search);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizza(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzeriaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		Pizza pizza = new Pizza();	
				
		model.addAttribute("pizza", pizza);
		
		return "pizza-form";
	}
	
	@PostMapping("/pizza/create")
	public String storePizza(
			Model model,
			@Valid @ModelAttribute Pizza pizza, 
			BindingResult bindingResult) {
		
				
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			model.addAttribute("pizza", pizza);
			return "pizza-form";
		}
			
			pizzeriaService.save(pizza);
			  
		return "redirect:/";
	}
}
