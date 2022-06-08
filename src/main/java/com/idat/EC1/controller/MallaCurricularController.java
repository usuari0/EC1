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
import com.idat.EC1.model.MallaCurricular;
import com.idat.EC1.service.CursoServiceImpl;
import com.idat.EC1.service.MallaCurricularImpl;

@Controller
public class MallaCurricularController {
	@Autowired
	MallaCurricularImpl service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarMallaCurricular(@RequestBody MallaCurricular malla) {
		try {
			service.guardarMallaCurricular(malla);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarMallaCurricular(@RequestBody MallaCurricular malla) {
		Optional<MallaCurricular> p = service.obtenerMallaCurricularId(malla.getIdMalla());
		if(p.isPresent()) {
			service.actualizarMallaCurricular(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<MallaCurricular>> listarMallaCurricular(){
		return new ResponseEntity<List<MallaCurricular>>(service.listarMallaCurricular(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarMallaCurricular(@PathVariable Integer id){
		try {
			service.eliminarMallaCurricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<MallaCurricular> encontrarMallaCurricular(@PathVariable Integer id){
		Optional<MallaCurricular> p = service.obtenerMallaCurricularId(id);
		if(p.isPresent()) {
			return new ResponseEntity<MallaCurricular>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
	}
}
