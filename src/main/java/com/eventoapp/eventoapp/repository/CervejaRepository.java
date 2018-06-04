package com.eventoapp.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.eventoapp.models.Cerveja;
import com.eventoapp.eventoapp.models.Tipo;

public interface CervejaRepository extends CrudRepository<Cerveja, String> {	
	Iterable<Cerveja> findByTipo(Tipo tipo);
	
}
