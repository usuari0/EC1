package com.idat.EC1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	
	@Column(name = "curso")
	private String curso;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "curso_profesor",
		joinColumns = @JoinColumn(
			name = "idCurso",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idCurso) references curso(idCurso)")
		),
		inverseJoinColumns = @JoinColumn(
			name = "idProfesor",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idProfesor) references profesor(idProfesor)")
		)
	)
	private List<Profesor> profesor = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(
		name = "idMalla",
		nullable = false,
		unique = true,
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idMalla) references mallacurricular(idMalla)")
	)
	private MallaCurricular mallaCurricular;
	
	public Curso() {}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
