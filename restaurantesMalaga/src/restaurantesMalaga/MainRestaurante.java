package restaurantesMalaga;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import restaurantemalaga.model.Restaurante;

public class MainRestaurante {

	public static final String RUTA_FICHERO = "restaurantes.txt";

	public static List<Restaurante> cargarRestaurantes(List<String> lineas) {
		List<Restaurante> lRestaurantes = null;
		int numLinea = 0;
		Restaurante restauranteAux = null;// restaurante instanciado en el momento(por iteracion)
		lRestaurantes = new ArrayList<>();

		restauranteAux = new Restaurante();

		for (String linea : lineas) {
			numLinea = numLinea + 1;
			switch (numLinea) {
			case 1:
				restauranteAux.setNombre(linea);
				break;
			case 2:
				restauranteAux.setDireccion(linea);
				break;
			case 3:
				restauranteAux.setWeb(linea);
				break;
			case 4:
				restauranteAux.setFichaGoogle(linea);
				break;
			case 5:
				restauranteAux.setLatitud(Float.parseFloat(linea));
				break;
			case 6:
				restauranteAux.setLongitud(Float.parseFloat(linea));
				break;
			case 7:
				restauranteAux.setBarrio(linea);
				break;
			case 8:
				String[] especialidades = linea.split(",");
				List<String> lespecialidades = Arrays.asList(especialidades); //Pasar un array a lista
				restauranteAux.setEspecialidades(lespecialidades);
				lRestaurantes.add(restauranteAux);
				numLinea = 0;
				restauranteAux = new Restaurante();
				break;

			}
		}
		return lRestaurantes;

	}

	public static void main(String[] args) throws IOException {
		
		// Cargar lista restaurante del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("FICHERO EXISTE!!, a parsearlo :)");
			Path path = file.toPath();
			List<String> lineas = Files.readAllLines(path);
			List<Restaurante> listRest = cargarRestaurantes(lineas);
			System.out.println("La lista tiene: "+ listRest.size() + " restaurantes.");
			//Metodo mostrar restaurantes
			mostrarRestaurantes(listRest);
			
			Restaurante r5 =listRest.get(4);
			boolean esta = buscarRestaurante(listRest, r5);
			System.out.println("R5 está en la lista " + esta);
			List<Restaurante> listaNueva = buscarRestaurantePorNombre(listRest, "McDonadls3");
			System.out.println(listaNueva);
			List<Restaurante> listaNuevaB = buscarRestaurantePorBarrio(listRest, "teatinos");
			System.out.println(listaNuevaB);
			
			List<Restaurante> listaNuevaE = buscarRestaurantePorEspecialidades(listRest, "helados");
			System.out.println(listaNuevaE);
			

			
		} else {
			System.out.println("NO EXISTE!!, el fichero en esta ruta :(");
		}

	}
	
	/**
	 * Muestra una lista de restaurantes ordenada por posición y con todos los datos
	 * @param listRest  Lista de restaurantes
	 */ 
	public static void mostrarRestaurantes (List<Restaurante> listRest) {
		System.out.println("Mostrando restaurantes");
		for (Restaurante r : listRest) {
			System.out.println(r);
			
		}
	}
	

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

	public static List<Restaurante> buscarRestaurantePorBarrio(List<Restaurante> listRest, String nombre){
		List<Restaurante> restNombre = null;
		//int pos_actual = 0;
		int longitud = listRest.size();
		Restaurante restauranteAux = null;
		restNombre = new ArrayList<Restaurante>();
		for (int i = 0; i < longitud; i++) {
			restauranteAux = listRest.get(i);
			String nombreRest = restauranteAux.getBarrio().trim();
			if (nombreRest.equals(nombre)) {
				restNombre.add(restauranteAux);
			}
			
		}
		return restNombre;
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
