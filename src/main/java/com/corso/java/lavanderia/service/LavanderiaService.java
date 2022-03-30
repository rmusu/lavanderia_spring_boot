package com.corso.java.lavanderia.service;

public interface LavanderiaService {

	public void crea(int n);

	public int numGrucce();

	public void assegnaGruccia(String codiceAbito);

	public void liberaGruccia(Long id);

	public String dammiCapo(Long id);

	public Long cercaCapo(String codiceCapo);

	public Long numStampelleOccupate();

	public void riordina();

}
