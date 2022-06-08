package com.idat.EC1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC1.model.Curso;
import com.idat.EC1.service.CursoServiceImpl;

@Controller
public class CursoController {
	@Autowired
	CursoServiceImpl service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarCurso(@RequestBody Curso curso) {
		try {
			service.guardarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarCurso(@RequestBody Curso curso) {
		Optional<Curso> p = service.obtenerCursoId(curso.getIdCurso());
		if(p.isPresent()) {
			service.actualizarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Curso>> listarCurso(){
		return new ResponseEntity<List<Curso>>(service.listarCurso(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarCurso(@PathVariable Integer id){
		try {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Curso> encontrarCurso(@PathVariable Integer id){
		Optional<Curso> p = service.obtenerCursoId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Curso>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
	}
}
