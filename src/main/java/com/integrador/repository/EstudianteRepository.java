package com.integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.integrador.domain.*;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	@Query( "SELECT e FROM Estudiante e WHERE e.apellido = :apellido ORDER BY e.apellido ASC" )
    	List<Estudiante> findByByApellido(String apellido);


	@Query ("SELECT e FROM Estudiante e WHERE e.LU = :LU")
		Estudiante findByLibreta(String LU);
	
	@Query ("SELECT e FROM Estudiante e WHERE e.genero = :genero")
		List<Estudiante> findByGenero(String genero);

	}







