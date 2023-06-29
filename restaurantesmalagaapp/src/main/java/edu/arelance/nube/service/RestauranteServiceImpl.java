package edu.arelance.nube.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.arelance.nube.repository.RestauranteRepository;
import edu.arelance.nube.repository.entity.Restaurante;

@Service // crea la instancia de RestauranteServiceImpl
public class RestauranteServiceImpl implements RestauranteService {

	// Atributo de la clae que debe comvertirse en una instancia que necesita para
	// comunicarse con el repositorio
	@Autowired // nos trae la instancia desde el contexto.
	RestauranteRepository restauranteRepository;

	// Metodos
	@Transactional(readOnly = true) // nos informa que existe conexión con la db. permite acceso concurrente
	@Override
	public Iterable<Restaurante> consultarTodos() {
		return this.restauranteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Restaurante> consultarUno(Long id) {
		return this.restauranteRepository.findById(id);
	}

	@Override
	@Transactional
	public Restaurante altaRestaurante(Restaurante restaurante) {
		return this.restauranteRepository.save(restaurante);
	}

	@Override
	@Transactional
	public void borrarRestaurante(Long id) {
		this.restauranteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Optional<Restaurante> modificarRestaurante(Long id, Restaurante restaurante) {
		Optional<Restaurante> opRest = Optional.empty();
		// Leer
		opRest = this.restauranteRepository.findById(id);
		if (opRest.isPresent()) {
			//al estar dentro de una transacción, restauranteLeido está asociado 
			//a un registro de la tabla. Si modifico un campo estoy modificando
			//la columna asociada (Estado "persistent" JPA)
			Restaurante restauranteLeido = opRest.get();
			//restauranteLeido.setNombre(restaurante.getNombre()); -> para hacerlo campo a campo
			BeanUtils.copyProperties(restaurante, restauranteLeido, "id", "creadoEn"); //coger el registro completo
			opRest = Optional.of(restaurante); //Relleno el optional
		}
		// Actualizar
		return opRest;
	}
	
	//Get 
	@Override
	@Transactional(readOnly = true)
	public Iterable<Restaurante> consultaPorRangoPrecio(int preciomin, int preciomax){
		 Iterable<Restaurante> listaRest = null;
		 listaRest = this.restauranteRepository.findByPrecioBetween(preciomin, preciomax );
		 return listaRest;
	}

	@Override
	public Iterable<Restaurante> buscarPorBarrioNombreOEspecialidad(String clave) {
		Iterable<Restaurante> listaRest = null;
		 listaRest = this.restauranteRepository.buscarPorBarrioNombreOEspecialidad(clave);
		 return listaRest;
	}

	


	

}
