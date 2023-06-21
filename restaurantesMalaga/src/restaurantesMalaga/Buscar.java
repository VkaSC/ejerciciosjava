package restaurantesMalaga;

import java.util.ArrayList;
import java.util.List;

import restaurantemalaga.model.Restaurante;

public class Buscar {
	
		//TODO crear metodo para filtrar por precio

	/**
	 * Buscar restaurante
	 * @param listRest lista restaurante
	 * @param restauranteBuscado nombre rest. buscado 
	 * @return boolean
	 */
	public static boolean buscarRestaurante(List<Restaurante> listRest, Restaurante restauranteBuscado){
		boolean estaRestaurante = false;
		int pos_actual = 0;
		int longitud = listRest.size();
		Restaurante restauranteAux = null;
		
		while (!estaRestaurante && pos_actual<longitud) {
			restauranteAux = listRest.get(pos_actual);
			estaRestaurante = restauranteAux.equals(restauranteAux);
			pos_actual = pos_actual+1;
		}
		return estaRestaurante;
	}
	
	/**
	 * Busca restaurantes por nombre
	 * @param listRest lista de restaurantes
	 * @param nombre	Nombre del restaurante buscado
	 * @return Lista restaurantes filtrados por nombres.
	 */
	public static List<Restaurante> buscarRestaurantePorNombre(List<Restaurante> listRest, String nombre){
		List<Restaurante> restNombre = null;
		//int pos_actual = 0;
		int longitud = listRest.size();
		Restaurante restauranteAux = null;
		restNombre = new ArrayList<Restaurante>();
		for (int i = 0; i < longitud; i++) {
			restauranteAux = listRest.get(i);
			String nombreRest = restauranteAux.getNombre().trim();
			if (nombreRest.equals(nombre)) {
				restNombre.add(restauranteAux);
			}
			
		}
		return restNombre;
	}

	

	public static List<Restaurante> buscarRestaurantePorBarrio(List<Restaurante> listRest, String barrio){
		List<Restaurante> restBarrio = null;
		//int pos_actual = 0;
		int longitud = listRest.size();
		Restaurante restauranteAux = null;
		restBarrio = new ArrayList<Restaurante>();
		for (int i = 0; i < longitud; i++) {
			restauranteAux = listRest.get(i);
			String nombreRest = restauranteAux.getBarrio().trim();
			if (nombreRest.equals(barrio)) {
				restBarrio.add(restauranteAux);
			}
			
		}
		return restBarrio;
	}
	
	public static List<Restaurante> buscarRestaurantePorEspecialidades(List<Restaurante> listRest, String especialidad){
		List<Restaurante> restEspecialidades = null;
		//int pos_actual = 0;
		int longitud = listRest.size();
		Restaurante restauranteAux = null;
		restEspecialidades = new ArrayList<Restaurante>();
		for (int i = 0; i < longitud; i++) {
			restauranteAux = listRest.get(i);
			List<String> nombreEspecialidad = restauranteAux.getEspecialidades();
			if (nombreEspecialidad.contains(especialidad)) {
				restEspecialidades.add(restauranteAux);
			}
			
		}
		return restEspecialidades;
	}
	
	

}