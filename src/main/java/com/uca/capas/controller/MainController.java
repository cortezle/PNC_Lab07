package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	
	@RequestMapping("/")
	public ModelAndView Main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	/*@RequestMapping(value="/mostrarEstudiante",method=RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="codigo")int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = estudianteService.findOne(id);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("estudiante");
		return mav;
	}*/
	

	@RequestMapping("/estudiante")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/mostrarEstudiante",method=RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="Codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", estudiante);
		mav.setViewName("estudiante");
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("agregarEstudiante");
		}else {
			estudianteService.save(estudiante);
			List<Estudiante> estudiantes=null;
			try {
				estudiantes = estudianteService.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("listaEstudiantes");
		}
		return mav;

	}
	
	@RequestMapping("/insertarEstudiante")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("agregarEstudiante");
		return mav;
		
	}
	
	@RequestMapping(value="/borrarEstudiante",method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo")int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes=null;
		try {
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/filtrar")
	public ModelAndView filtrar(@RequestParam(value="nombre")String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes=null;
		try {
			
		estudiantes = estudianteService.filtrarPor(cadena); 
		//estudiantes = estudianteService.empiezaPor(cadena);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("main");
		mav.addObject("estudiantes", estudiantes);
		return mav;
		
	}
	
	/*@RequestMapping("/mostrarDTO")
	public ModelAndView mostrarDTO() {
		ModelAndView mav = new ModelAndView();
		List<EstudianteDTO> estudiantes = null;
		try {
			estudiantes = estudianteService.mostrarDTO();
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("muestraDTO");
		mav.addObject("estudiantes", estudiantes);
		return mav;
	}*/
	
	@RequestMapping("/editar")
	public ModelAndView editar(@RequestParam(value="codigo")int codigoEstudiante) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = estudianteService.findOne(codigoEstudiante);
		mav.setViewName("editarEstudiante");
		mav.addObject("estudiante",estudiante);
		return mav;
		
	}
	
	

}

