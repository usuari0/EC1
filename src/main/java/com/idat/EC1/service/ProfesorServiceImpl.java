package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC1.model.Profesor;
import com.idat.EC1.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	ProfesorRepository repository;

	@Override
	public void guardarProfesor(Profesor profesor) {
		repository.save(profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		repository.saveAndFlush(profesor);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Profesor> listarProfesor() {
		return repository.findAll();
	}

	@Override
	public Optional<Profesor> obtenerProfesorId(Integer id) {
		return repository.findById(id);
	}

}
