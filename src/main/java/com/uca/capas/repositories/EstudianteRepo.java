package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
	
	public List<Estudiante> findByNombre(String cadena) throws DataAccessException;
	
	public List<Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="select * from public.estudiante")
	public List<Estudiante> mostrarTodos() throws DataAccessException;
	
	//@Query(nativeQuery=true, value="select * from public.estudiante where nombre = :cadena")
	@Query(nativeQuery=true, value="select * from public.estudiante where nombre = ?1")
	public List<Estudiante> mostrarporNombre(String cadena) throws DataAccessException;
	
	
	//@Query(nativeQuery=true,value="select nombre,apellido from public.estudiante")
	//public List<Object[]> pruebaDTO() throws DataAccessException;
	
	
}
