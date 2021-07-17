package com.nobelti.cl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nobelti.cl.model.Proyecto;
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
	public Proyecto findTopByOrderByIdProjectDesc();

}
