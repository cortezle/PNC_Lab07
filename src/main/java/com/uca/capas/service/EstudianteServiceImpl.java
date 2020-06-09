package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDAO;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.mostrarTodos();
	}

	@Override
	public Estudiante findOne(Integer codigoEstudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(codigoEstudiante);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		estudianteRepo.deleteById(codigoEstudiante);
	}
	
	@Override
	public List<Estudiante> filtrarPor(String cadena)throws DataAccessException {
		return estudianteRepo.mostrarporNombre(cadena);
	}

	@Override
	public List<Estudiante> empiezaPor(String cadena)throws DataAccessException {
		return estudianteRepo.findByApellidoStartingWith(cadena);
	}

	/*@Override
	public List<EstudianteDTO> mostrarDTO() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.pruebaDTO();	}*/
}
