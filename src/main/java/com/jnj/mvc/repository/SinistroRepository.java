package com.jnj.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jnj.mvc.entity.Sinistro;

public interface SinistroRepository extends CrudRepository<Sinistro, Long> {

	List<Sinistro> findAll();
}

