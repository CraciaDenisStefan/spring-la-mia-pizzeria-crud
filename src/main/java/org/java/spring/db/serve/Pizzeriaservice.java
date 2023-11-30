package org.java.spring.db.serve;

import java.util.List;

import org.java.spring.db.pojo.Pizzeria;
import org.java.spring.db.repo.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pizzeriaservice {

	@Autowired
	
	private PizzeriaRepository pizzeriaRepository;
	
	public List<Pizzeria> findAll() {
		
		return pizzeriaRepository.findAll();
	}
	public Pizzeria findById(int id) {
		
		return pizzeriaRepository.findById(id).get();
	}
	public void save(Pizzeria pizzeria) {
		
		pizzeriaRepository.save(pizzeria);
	}
	
	
}
