package edu.arelance.nube.service;

import java.util.Optional;

import edu.arelance.nube.repository.entity.Restaurante;

public interface RestauranteService {
	
	//consultar todos
	Iterable<Restaurante> consultarTodos();
	//Consulta por rango precio
	Iterable<Restaurante> consultaPorRangoPrecio(int preciomin, int preciomax);
	//Buscar por nombre, barrio o especialidad en función del parametro de busqueda
	Iterable<Restaurante> buscarPorBarrioNombreOEspecialidad (String clave);
	//Consultar restaurante 
	//Optional: es una clase que ayuda a controlar, minimizar la excepción por null pointer
	Optional<Restaurante> consultarUno (Long id);
	
	//Crear
	 Restaurante altaRestaurante(Restaurante restaurante);
	 	
	 //Borrar
	 void borrarRestaurante (Long id);
	 
	 //Modificación
	 Optional<Restaurante> modificarRestaurante(Long id, Restaurante restaurante);
}
