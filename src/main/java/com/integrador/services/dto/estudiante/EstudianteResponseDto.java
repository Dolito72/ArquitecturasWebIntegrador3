package com.integrador.services.dto.estudiante;

import java.util.HashSet;
import java.util.Set;

import com.integrador.domain.Estudiante;
import com.integrador.domain.EstudianteCarrera;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class EstudianteResponseDto {
	private final int id;
    private final String nombre;
    private final String apellido;
	private final int dni;
	private final int edad;
	private final String genero;
	private final String ciudadResidencia;
	private final int LU;
	private final Set<EstudianteCarrera> carreras;
    
	public EstudianteResponseDto(Estudiante e ) {
        this.id = e.getEstudianteId();
        this.dni = e.getDni();
        this.nombre = e.getNombre();
        this.apellido = e.getApellido();
        this.edad = e.getEdad();
        this.genero = e.getGenero();
        this.ciudadResidencia = e.getCiudadResidencia();
        this.LU = e.getLU();
        this.carreras = new HashSet<EstudianteCarrera>();
	}






        
        
    }

