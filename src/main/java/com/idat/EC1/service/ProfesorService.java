package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import com.idat.EC1.model.MallaCurricular;
import com.idat.EC1.model.Profesor;

public interface ProfesorService {
	void guardarProfesor(Profesor curso);
	void actualizarProfesor(Profesor profesor);
	void eliminarProfesor(Integer id);
	List<Profesor> listarProfesor();
	Optional<Profesor> obtenerProfesorId(Integer id);
}
