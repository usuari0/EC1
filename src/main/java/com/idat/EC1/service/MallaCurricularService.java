package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import com.idat.EC1.model.Curso;
import com.idat.EC1.model.MallaCurricular;

public interface MallaCurricularService {

	void guardarMallaCurricular(MallaCurricular curso);
	void actualizarMallaCurricular(MallaCurricular mallaCurricular);
	void eliminarMallaCurricular(Integer id);
	List<MallaCurricular> listarMallaCurricular();
	Optional<MallaCurricular> obtenerMallaCurricularId(Integer id);
}
