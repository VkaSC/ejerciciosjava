package restaurantesMalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import restaurantemalaga.model.ComparadorRestaurantes;
import restaurantemalaga.model.Restaurante;
import restaurantemalaga.model.ComparadorBarrioPrecio;

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
				restauranteAux.setNombre(linea.trim());
				break;
			case 2:
				restauranteAux.setDireccion(linea.trim());
				break;
			case 3:
				restauranteAux.setWeb(linea.trim());
				break;
			case 4:
				restauranteAux.setFichaGoogle(linea.trim());
				break;
			case 5:
				restauranteAux.setLatitud(Float.parseFloat(linea));
				break;
			case 6:
				restauranteAux.setLongitud(Float.parseFloat(linea));
				break;
			case 7:
				restauranteAux.setBarrio(linea.trim());
				break;
		
			case 8:
				String[] especialidades = linea.split(",");
				String[] especialidadesProcesadas = new String[especialidades.length];
				
				for (int i = 0; i < especialidades.length; i++) {
					especialidadesProcesadas[i] = especialidades[i].trim();
				}
				List<String> lespecialidades = Arrays.asList(especialidadesProcesadas); //Pasar un array a lista
				restauranteAux.setEspecialidades(lespecialidades);
				
				break;
			case 9:
				restauranteAux.setPrecioMedio(Double.parseDouble(linea));
				//restauranteAux.setPrecioMedio(randomNumber(5, 100));
				
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
			System.out.println("La lista Original tiene: "+ listRest.size() + " restaurantes.");
			//Metodo mostrar restaurantes
			mostrarRestaurantes(listRest);
			
			System.out.println("\nLa lista Ordenada precios tiene: "+ listRest.size() + " restaurantes.");
			//Metodo mostrar restaurantes ordenados
			Collections.sort(listRest);
			mostrarRestaurantes(listRest);
			
			System.out.println("\nLa lista Ordenada nombre tiene: "+ listRest.size() + " restaurantes.");
			//Metodo mostrar restaurantes ordenados
			Collections.sort(listRest, new ComparadorRestaurantes());
			mostrarRestaurantes(listRest);
			
			Restaurante r5 =listRest.get(4);
			boolean esta = Buscar.buscarRestaurante(listRest, r5);
			System.out.println("R5 está en la lista " + esta);
			List<Restaurante> listaNueva = Buscar.buscarRestaurantePorNombre(listRest, "McDonadls3");
			TreeSet<Restaurante> nombrePrecio = new TreeSet<>(listaNueva);
			System.out.println("\nRestaurantes por nombre y precio medio: \n" + nombrePrecio);
			
			
			List<Restaurante> listaNuevaB = Buscar.buscarRestaurantePorBarrio(listRest, "centro");
			listaNuevaB.sort(new ComparadorBarrioPrecio());
			System.out.println("\nRestaurantes por barrio/precio: \n" +listaNuevaB);
			
			List<Restaurante> listaNuevaE = Buscar.buscarRestaurantePorEspecialidades(listRest, "pescado");
			System.out.println("\nRestaurantes por especialidad: \n" +listaNuevaE);
			
			List<Restaurante> listaBE = Buscar.buscarPorBarrioYEspecialidadOrdenadoPrecio(listRest, "centro", "pescado");
			System.out.println("\nRestaurantes por Barrio, especialidad y precio: \n" + listaBE);

			

			
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
	
	public static void mostrarRestaurantesLambda (List<Restaurante> listRest) {
	 listRest.forEach(restaurante -> System.out.println(restaurante));
	}
	
	
	
	

	


}
