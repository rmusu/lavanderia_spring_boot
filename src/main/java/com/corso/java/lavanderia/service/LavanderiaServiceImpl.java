package com.corso.java.lavanderia.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.lavanderia.entities.Lavanderia;
import com.corso.java.lavanderia.repositories.LavanderiaRepo;

@Service
public class LavanderiaServiceImpl implements LavanderiaService {

	@Autowired
	private LavanderiaRepo lr;

	public void crea(int n) {

		for (int i = 0; i < n; i++) {

			Lavanderia l = new Lavanderia(null, true);
			lr.save(l);

		}
	}

	public int numGrucce() {

		return lr.findAll().size();

	}

	public void assegnaGruccia(String codiceAbito) {

		Long grucciaLibera = lr.findAll().stream().filter(x -> x.isLibera()).mapToLong(g -> g.getNumeroGruccia()).min()
				.orElseThrow(NoSuchElementException::new);

		updateGruccia(grucciaLibera, codiceAbito, false);

	}

	public void updateGruccia(Long id, String codiceAbito, Boolean isLibera) {
		Lavanderia grucciaLibera = lr.getById(id);

		grucciaLibera.setCodiceAbito(codiceAbito);
		grucciaLibera.setLibera(isLibera);

		lr.save(grucciaLibera);
	}

	@Override
	public void liberaGruccia(Long id) {

		updateGruccia(id, null, true);

	}

	@Override
	public String dammiCapo(Long id) {

		if (lr.getById(id).isLibera()) {
			throw new NoSuchElementException();
		}

		return lr.getById(id).getCodiceAbito();

	}

	@Override
	public Long cercaCapo(String codiceAbito) {

		List<Lavanderia> res = lr.findAll().stream()
				.filter(x -> !(x.isLibera()) && x.getCodiceAbito().equals(codiceAbito)).collect(Collectors.toList());
		if (res.size() == 0) {
			return (long) -1;
		}
		return res.get(0).getNumeroGruccia();

	}

	@Override
	public Long numStampelleOccupate() {

		return lr.findAll().stream().filter(x -> !x.isLibera()).count();
	}

	@Override
	public void riordina() {

		int count = 0;

		List<Lavanderia> occupate = lr.findAll().stream().filter(x -> !(x.isLibera())).collect(Collectors.toList());

		for (Lavanderia l : occupate) {

			if (l.getNumeroGruccia() != ++count) {

				assegnaGruccia(l.getCodiceAbito());
				liberaGruccia(l.getNumeroGruccia());

			}
		}
	}

}
