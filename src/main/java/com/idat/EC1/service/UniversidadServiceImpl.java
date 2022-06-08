package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC1.model.Universidad;
import com.idat.EC1.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService{
	
	@Autowired
	UniversidadRepository repository;

	@Override
	public void guardarUniversidad(Universidad universidad) {
		repository.save(universidad);
	}

	@Override
	public void actualizarUniversidad(Universidad universidad) {
		repository.saveAndFlush(universidad);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Universidad> listarUniversidad() {
		return repository.findAll();
	}

	@Override
	public Optional<Universidad> obtenerUniversidadId(Integer id) {
		return repository.findById(id);
	}

}
