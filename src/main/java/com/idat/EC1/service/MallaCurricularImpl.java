package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC1.model.MallaCurricular;
import com.idat.EC1.repository.MallaCurricularRepository;

@Service
public class MallaCurricularImpl implements MallaCurricularService{
	
	@Autowired
	MallaCurricularRepository repository;

	@Override
	public void guardarMallaCurricular(MallaCurricular malla) {
		repository.save(malla);
	}

	@Override
	public void actualizarMallaCurricular(MallaCurricular mallaCurricular) {
		repository.saveAndFlush(mallaCurricular);
	}

	@Override
	public void eliminarMallaCurricular(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<MallaCurricular> listarMallaCurricular() {
		return repository.findAll();
	}

	@Override
	public Optional<MallaCurricular> obtenerMallaCurricularId(Integer id) {
		return repository.findById(id);
	}

}
