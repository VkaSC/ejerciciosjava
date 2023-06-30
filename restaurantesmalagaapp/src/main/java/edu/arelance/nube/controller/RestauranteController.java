package edu.arelance.nube.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.arelance.nube.repository.entity.Restaurante;
import edu.arelance.nube.service.RestauranteService;
import io.swagger.v3.oas.annotations.Operation;

//import org.springframework.stereotype.Controller;

/**
 * API WEB HTTP -> Deriva en la ejecución de un método
 * 
 * GET -> consultar todos GET -> consultar por id (uno) POSt -> insertar PUT ->
 * Modifica un registro que ya existe Delete -> Borra un registro (por Id) GET
 * -> Busqueda: por barrio, por nombre, por especialidad o precio Medio
 * 
 * Recibe y devuelve información, pero no hace nada con ella, la manipulación
 * pertenece a service
 */
//@Controller   => Es un controlador menos específico devuelve una representación (mas antiguo)
@RestController // Return JSon
@RequestMapping("/restaurante")
public class RestauranteController {

	// Atributo
	@Autowired // inyeccion de dependencias
	RestauranteService restauranteService;
	
	//log
	Logger logger= LoggerFactory.getLogger(RestauranteController.class);


	// Metodos
	@GetMapping("/test") // Get http://localhost:8081/restaurante/test
	public Restaurante obtenerRestauranteTest() {

		Restaurante restaurante = null;
		System.out.println("LLamando a obtenerRestauranteTest");
		logger.debug("Estoy en obtenerRestauranteTest");
		restaurante = new Restaurante(1l, "Martinete", "carlos haya 33", "carranque", "www.martinete.org",
				"http://gogle.xe", 33.65f, -2.3f, 10, "gazpachelo", "paella", "sopa de marisco", LocalDateTime.now());
		return restaurante;
	}

	// GET -> consultar todos -> http://localhost:8081/restaurante
	// ResponseEntity devuelve un mensaje http completo, se pone '?' para hacer el
	// tipo de dato genérico
	@GetMapping
	public ResponseEntity<?> obtenerRestaurantes() {

		ResponseEntity<?> responseEntity = null;
		Iterable<Restaurante> lista_restaurantes = null;

		lista_restaurantes = this.restauranteService.consultarTodos();
		responseEntity = ResponseEntity.ok(lista_restaurantes); //Mensaje de respuesta

		return responseEntity;
	}

	// * GET -> consultar por id http://localhost:8081/restaurante/5
	@Operation(description = "Este servicio permite la consulta de restaurante por id")
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id) {

		ResponseEntity<?> responseEntity = null;
		Optional<Restaurante> or = null;
		logger.debug("Entrando en el método listarPorId: con id:" + id);
		or = this.restauranteService.consultarUno(id);
		if ( or.isPresent()) {
			//La consulta ha encontrado registro
			Restaurante restauranteLeido = or.get();
			responseEntity = ResponseEntity.ok(restauranteLeido);
			logger.debug("Recuperando el registro:" + restauranteLeido);
		} else {
			//La consulta no ha encontrado registro
			responseEntity = ResponseEntity.noContent().build();
			logger.debug("El restaurante con id: " + id +" NO EXISTE");
		};
		logger.debug("Saliendo del método");
		return responseEntity;
	}
	
	/*
	//Metodo get con pathVariable (menos intuitivo)
	//GET -> Restaurantes en rango de precios //http://localhost:8081/restaurante/5/20
	@GetMapping ("/{preciomin}/{preciomax}") 
	public ResponseEntity<?> listarPorRangoDePrecio (@PathVariable int preciomin, @PathVariable int preciomax){
		ResponseEntity<?> responseEntity = null;
		Iterable<Restaurante> restEnRango = null;
		restEnRango =  this.restauranteService.consultaPorRangoPrecio( preciomin,  preciomax);
		responseEntity = ResponseEntity.ok(restEnRango);
		return responseEntity;

	}*/
	
	//GET -> Restaurantes en rango de precios //http://localhost:8081/restaurante/buscarPorPrecio?preciomin=1&preciomax=10
		@GetMapping ("/buscarPorPrecio") 
		public ResponseEntity<?> listarPorRangoDePrecio (@RequestParam (name="preciomin") int preciomin, @RequestParam (name="preciomax") int preciomax){
			ResponseEntity<?> responseEntity = null;
			Iterable<Restaurante> restEnRango = null;
			restEnRango =  this.restauranteService.consultaPorRangoPrecio( preciomin,  preciomax);
			responseEntity = ResponseEntity.ok(restEnRango);
			return responseEntity;

		}
	//Get -> busqueda multiple en función del parametro de busqueda (barrio, nombre o especialidad
		//http://localhost:8081/restaurante/filtro?nombre=centro
		@GetMapping("/filtro")
		public ResponseEntity<?> filtroBusqueda(@RequestParam (name="nombre") String clave){
			ResponseEntity<?> responseEntity = null;
			Iterable<Restaurante> resFilt = null;
			resFilt =  this.restauranteService.buscarPorBarrioNombreOEspecialidad(clave);
			responseEntity = ResponseEntity.ok(resFilt);
			return responseEntity;
		}
	
	
	

	// * POST -> insertar http://localhost:8081/restaurante (Body Restaurante)
	@PostMapping
	public ResponseEntity<?> insertarRestaurante(@Valid @RequestBody Restaurante restaurante, BindingResult bindingResult) {

		ResponseEntity<?> responseEntity = null;
		Restaurante restauranteNuevo = null;
		//TODO Validar
		if (bindingResult.hasErrors()) {
			logger.debug("Errores en la entrada de POST");
			responseEntity = generarRespuestaDeErroresValidacion(bindingResult);
			
		} else {
			logger.debug("SIN Errores en la entrada al POST");
			restauranteNuevo = this.restauranteService.altaRestaurante(restaurante);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(restauranteNuevo);
		}
		return responseEntity;
	}

	// * PUT -> Modifica un registro que ya existe
	// http://localhost:8081/restaurante/id (Body Restaurante)
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarRestaurante(@Valid @RequestBody Restaurante restaurante, @PathVariable Long id, BindingResult bindingResult) {

		ResponseEntity<?> responseEntity = null;
		Optional<Restaurante> opRest = null;
		if (bindingResult.hasErrors()) {
			logger.debug("Error en la entrada al PUT");
			responseEntity = generarRespuestaDeErroresValidacion(bindingResult);

		} else {
			logger.debug("SIN Error en la entrada al PUT");
			opRest = this.restauranteService.modificarRestaurante(id, restaurante);
			if (opRest.isPresent()) {
				Restaurante rm = opRest.get(); //rm -> restaurante modificado que nos llega del service
				responseEntity = ResponseEntity.ok(rm);
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		return responseEntity;
	}

	// * Delete -> Borra un registro (por Id) http://localhost:8081/restaurante/3
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarPorId(@PathVariable Long id) {

		ResponseEntity<?> responseEntity = null;
		this.restauranteService.borrarRestaurante(id);
		responseEntity = ResponseEntity.ok().build();

		return responseEntity;
	}
	
	//Metodos
	private ResponseEntity<?> generarRespuestaDeErroresValidacion (BindingResult bindingResult){
		ResponseEntity<?> responseEntity = null;
		List<ObjectError> listaDeErrores = null;
		
			listaDeErrores = bindingResult.getAllErrors();
			
			//Imprimir errores por el log
			listaDeErrores.forEach(e -> logger.error(e.toString()));
			
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaDeErrores);
		
		return responseEntity;
	}

}
