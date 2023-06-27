package edu.arelance.nube.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;
import edu.arelance.nube.service.RestauranteService;

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
	
	//Atributo
	@Autowired
	RestauranteService restauranteService;
	
	
	//Metodos
	@GetMapping("/test") //Get http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest() {
		
		Restaurante restaurante = null;
		System.out.println("LLamando a obtenerRestauranteTest");
		restaurante = new Restaurante(1l, "Martinete", "carlos haya 33", "carranque", "www.martinete.org", "http://gogle.xe", 33.65f, -2.3f, 10, "gazpachelo", "paella", "sopa de marisco",  LocalDateTime.now());
		return restaurante;
	}
	
	// GET -> consultar todos -> http://localhost:8081/restaurante
		//ResponseEntity devuelve un mensaje http completo, se pone '?' para hacer el tipo de dato genérico
	@GetMapping
	public ResponseEntity<?> obtenerRestaurantes(){
		
		ResponseEntity<?> responseEntity = null;
		Iterable<Restaurante> lista_restaurantes = null;
		
			lista_restaurantes = this.restauranteService.consultarTodos();
			responseEntity = ResponseEntity.ok(lista_restaurantes);
			
		return responseEntity;
	}
	// * GET -> consultar por id  http://localhost:8081/restaurante/5
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		
		ResponseEntity<?> responseEntity = null;
			
		return responseEntity;
	}
	// * POST -> insertar  http://localhost:8081/restaurante (Body Restaurante)
	// * PUT -> Modifica un registro que ya existe  http://localhost:8081/restaurante/id (Body Restaurante)
	
	// * Delete -> Borra un registro (por Id)  http://localhost:8081/restaurante/3
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarPorId(@PathVariable Long id){
		
		ResponseEntity<?> responseEntity = null;
			
		return responseEntity;
	}

}
