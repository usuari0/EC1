package com.idat.EC1.service;

import java.util.List;
import java.util.Optional;

import com.idat.EC1.model.Profesor;
import com.idat.EC1.model.Universidad;

public interface UniversidadService {
	void guardarUniversidad(Universidad universidad);
	void actualizarUniversidad(Universidad universidad);
	void eliminarUniversidad(Integer id);
	List<Universidad> listarUniversidad();
	Optional<Universidad> obtenerUniversidadId(Integer id);
}
