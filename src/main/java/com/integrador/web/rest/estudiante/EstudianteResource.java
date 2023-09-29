package com.integrador.web.rest.estudiante;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.services.EstudianteService;
import com.integrador.services.dto.estudiante.EstudianteRequestDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteResource {
	private  EstudianteService estudianteService;

    @GetMapping("")
    public List<EstudianteResponseDto> findAll(){
        return this.estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteResponseDto findById( @PathVariable Integer id ){
        return this.estudianteService.findById( id );
    }

    @GetMapping("/search")
    public List<EstudianteResponseDto> findById( EstudianteRequestDto request ){
        return this.estudianteService.search( request );
    }

 /*   @PostMapping("")
    public ResponseEntity<EstudianteResponseDto> save( @RequestBody @Validated EstudianteRequestDto request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body( result );
    }*/
	
	
	
	
	
	

}
