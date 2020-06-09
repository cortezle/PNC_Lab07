package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;

public interface EstudianteService {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer codigoEstudiante) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer codigoEstudiante) throws DataAccessException;

	List<Estudiante> filtrarPor(String cadena) throws DataAccessException;

	List<Estudiante> empiezaPor(String cadena) throws DataAccessException;

	//public List<EstudianteDTO> mostrarDTO() throws DataAccessException;
	

}
