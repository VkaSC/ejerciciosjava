package edu.arelance.nube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;

//import org.springframework.stereotype.Controller;



/**
 * API WEB
 * HTTP -> Deriva en la ejecución de un método
 * 
 * GET -> consultar todos
 * GET -> consultar por id (uno)
 * POSt -> insertar 
 * PUT -> Modifica un registro que ya existe
 * Delete -> Borra un registro (por Id)
 * GET -> Busqueda: por barrio, por nombre, por especialidad o precio Medio
 * 
 * Recibe y devuelve información, pero no hace nada con ella, la manipulación pertenece a service
 */
//@Controller   => Es un controlador menos específico devuelve una representación (mas antiguo)
@RestController //Return JSon
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@GetMapping("/test") //Get http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest() {
		
		Restaurante restaurante = null;
		System.out.println("LLamando a obtenerRestauranteTest");
		return restaurante;
	}

}
