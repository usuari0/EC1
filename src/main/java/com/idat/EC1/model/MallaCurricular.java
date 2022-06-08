package com.idat.EC1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mallacurricular")
public class MallaCurricular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	
	@Column(name = "año")
	private Integer año;

	@OneToOne
	@JoinColumn(name = "idUniversidad", 
				nullable = false, 
				unique = true, 
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idUniversidad) references universidad(idUniversidad)"))
	private Universidad universidad;
	
	@OneToMany(mappedBy = "mallaCurricular")
	private List<Curso> curso = new ArrayList<>();
	
	public MallaCurricular() {}

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}
	
	
}
