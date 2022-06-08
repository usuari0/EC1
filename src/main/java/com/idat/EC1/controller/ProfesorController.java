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
import com.idat.EC1.model.Profesor;
import com.idat.EC1.service.CursoServiceImpl;
import com.idat.EC1.service.ProfesorServiceImpl;

@Controller
public class ProfesorController {
	@Autowired
	ProfesorServiceImpl service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarProfesor(@RequestBody Profesor profesor) {
		try {
			service.guardarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarProfesor(@RequestBody Profesor profesor) {
		Optional<Profesor> p = service.obtenerProfesorId(profesor.getIdProfesor());
		if(p.isPresent()) {
			service.actualizarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Profesor>> listarProfesor(){
		return new ResponseEntity<List<Profesor>>(service.listarProfesor(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id){
		try {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Profesor> encontrarProfesor(@PathVariable Integer id){
		Optional<Profesor> p = service.obtenerProfesorId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Profesor>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
}
