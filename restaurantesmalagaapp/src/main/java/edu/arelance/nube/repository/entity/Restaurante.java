package edu.arelance.nube.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {
	
	@Id //indico a spring que el id es la PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento MySQL.
	private Long id;
	private String nombre;
	private String direccion;
	private String barrio;
	private String web;
	private String fichaGoogle;
	private Float latitud;
	private Float longitud;
	private Integer precio;
	private String especialidad1;
	private String especialidad2;
	private String especialidad3;
	
}
