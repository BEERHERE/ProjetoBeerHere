package com.eventoapp.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventoapp.eventoapp.models.Bar;


public interface BarRepository extends CrudRepository<Bar, String> {
	

	Bar findById(long id);

}
