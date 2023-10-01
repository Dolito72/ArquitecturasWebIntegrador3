package com.integrador.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.integrador.domain.Estudiante;
import com.integrador.repository.EstudianteRepository;

import com.integrador.services.dto.estudiante.EstudianteRequestDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;
import com.integrador.services.exception.NotFoundException;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class EstudianteService{
	 
	  
	 @Autowired 
	 private  EstudianteRepository estudianteRepository;
	
/*	@Transactional
	    public EstudianteResponseDto save(EstudianteRequestDto request ){
	        Estudiante estudiante = new Estudiante(request);
	        Estudiante result = this.estudianteRepository.save(estudiante);
	        return new EstudianteResponseDto(estudiante, result.getEstudianteId(), result.getDni(), result.getNombre(), result.getApellido(),
	        		result.getEdad(), result.getGenero(), result.getCiudadResidencia(), result.getLU(), result.getCarreras());
	    }*/
	    
	    
	  

	    @Transactional
	    public List<EstudianteResponseDto> findAll(){
	        return this.estudianteRepository.findAll().stream().map( EstudianteResponseDto::new ).toList();
	    }

	    @Transactional
	    public EstudianteResponseDto findById( Integer id ){
	        return this.estudianteRepository.findById( id )
	                .map( EstudianteResponseDto::new )
	                .orElseThrow( () -> new NotFoundException("Estudiante", id ) );
	    }
	    
	   /* @Transactional
	    public EstudianteResponseDto estudiantePorLibreta1( int LU ){
	        return this.estudianteRepository.estudiantePorLibreta(LU)
	                stream.map( EstudianteResponseDto::new )
	                .orElseThrow( () -> new NotFoundException(LU ) );
	    }
	    
	    @Transactional
	    public Optional<EstudianteResponseDto> estudiantePorLibreta(int LU)throws Exception{
	    	var resultado = estudianteRepository.estudiantePorLibreta(LU);
	        try{
	            return (resultado).map(EstudianteResponseDto::new);
	        }catch (Exception e){
	            throw new Exception(e.getMessage());
	        }
	    }*/
	    
	    

	    @Transactional
	    public List<EstudianteResponseDto> estudiantesPorApellido ( ){
	        return this.estudianteRepository.estudiantesPorApellido()
	                .stream().map( EstudianteResponseDto::new ).toList();
	    }
	    
	   
	    @Transactional
	    public List<EstudianteResponseDto> estudiantePorGenero(String genero ){
	        return this.estudianteRepository.findByGenero(genero )
	                .stream().map( EstudianteResponseDto::new ).toList();
	    }
	    

	}

	
	
	
	
	
	
	
	
	
	
