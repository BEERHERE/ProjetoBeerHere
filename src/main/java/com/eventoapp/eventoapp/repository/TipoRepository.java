package com.eventoapp.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;


import com.eventoapp.eventoapp.models.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, String>  {
	Tipo findByCodigo(long codigo);

}
