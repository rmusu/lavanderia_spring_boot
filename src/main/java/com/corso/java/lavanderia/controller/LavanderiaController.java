package com.corso.java.lavanderia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.corso.java.lavanderia.service.LavanderiaService;

@RestController
public class LavanderiaController {

	@Autowired
	private LavanderiaService ls;

	@GetMapping("/crea/{n}")
	public void crea(@PathVariable int n) {

		ls.crea(n);

	}

	@GetMapping("/numGrucce")
	public int numGrucce() {

		return ls.numGrucce();

	}

	@GetMapping("/assegnaGruccia/{c}")
	public void assegnaGruccia(@PathVariable String c) {

		ls.assegnaGruccia(c);

	}

	@GetMapping("/liberaGruccia/{id}")
	public void liberaGruccia(@PathVariable Long id) {

		ls.liberaGruccia(id);

	}

	@GetMapping("/dammiCapo/{id}")
	public String dammiCapo(@PathVariable Long id) {

		return ls.dammiCapo(id);

	}

	@GetMapping("/cercaCapo/{c}")
	public Long cercaCapo(@PathVariable String c) {

		return ls.cercaCapo(c);

	}

	@GetMapping("/numStampelleOccupate")
	public Long numStampelleOccupate() {

		return ls.numStampelleOccupate();
	}

	@GetMapping("/aggiungiStampelle/{n}")
	public void aggiungiStampella(@PathVariable int n) {

		ls.crea(n);
	}
	
	@GetMapping("/riordina")
	public void riordina(){

		ls.riordina();
	}

}
