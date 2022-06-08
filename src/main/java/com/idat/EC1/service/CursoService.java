package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import com.idat.EC1.model.Curso;

public interface CursoService {

	void guardarCurso(Curso curso);
	void actualizarCurso(Curso curso);
	void eliminarCurso(Integer id);
	List<Curso> listarCurso();
	Optional<Curso> obtenerCursoId(Integer id);
}
