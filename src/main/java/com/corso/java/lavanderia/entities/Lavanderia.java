package com.corso.java.lavanderia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grucce")
public class Lavanderia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_gruccia")
	private Long numeroGruccia;
	@Column(name = "codice_abito")
	private String codiceAbito;
	@Column(name = "libera")
	private Boolean libera;

	public Lavanderia(String codiceAbito, Boolean libera) {

		this.codiceAbito = codiceAbito;
		this.libera = libera;
	}

	public Lavanderia() {

	}

	public Long getNumeroGruccia() {
		return numeroGruccia;
	}

	public void setNumeroGruccia(Long numeroGruccia) {
		this.numeroGruccia = numeroGruccia;
	}

	public String getCodiceAbito() {
		return codiceAbito;
	}

	public void setCodiceAbito(String codiceAbito) {
		this.codiceAbito = codiceAbito;
	}

	public Boolean isLibera() {
		return libera;
	}

	public void setLibera(Boolean libera) {
		this.libera = libera;
	}
	
	

}
