package com.corso.java.lavanderia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corso.java.lavanderia.entities.Lavanderia;

@Repository
public interface LavanderiaRepo extends JpaRepository<Lavanderia, Long>{

	
	
	

}
