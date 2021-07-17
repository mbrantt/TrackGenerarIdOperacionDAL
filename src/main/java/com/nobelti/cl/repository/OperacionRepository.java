package com.nobelti.cl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nobelti.cl.model.Operacion;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Integer> {
	public Operacion findTopByOrderByIdOperationDesc();
	
}