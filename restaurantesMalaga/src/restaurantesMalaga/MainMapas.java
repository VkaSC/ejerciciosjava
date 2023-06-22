package restaurantesMalaga;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import restaurantemalaga.model.Restaurante;

public class MainMapas {

	private static final String RUTA_FICHERO = "restaurantes.txt";

	public static void main(String[] args) throws IOException {

		// TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("FICHERO EXISTE!, a parsearlo :)");
			Path path = file.toPath();// convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);// leo todo el fichero en una línea
			List<Restaurante> listRest = MainRestaurante.cargarRestaurantes(lineas);

			// Crear mapa
			Map<String, Restaurante> mapRestaurantes = new HashMap<>();

			// recorremos la lista para cargar el mapa con la clave-valor
			for (Restaurante restaurante : listRest) {
				mapRestaurantes.put(restaurante.getNombre(), restaurante);
			}
			// Busqueda en el mapa (por clave nombre)
			Restaurante rParrilla = mapRestaurantes.get("La Parrilla");
			System.out.println(rParrilla.toString());

			// TODO partiendo de la lista de restaurantes hacer un mapa donde la clave sea
			// el barrio y el valor la lista de restaurantes de ese barrio

		} else {
			System.out.println("FICHERO NO EXISTE!");
		}
		

	}

	public static Map<String, List<Restaurante>> crearMapRestaurantesPorBarrio(List<Restaurante> rest) {
		Map<String, List<Restaurante>> mapa = new HashMap<>();
		// Recorro la lista
		for (Restaurante  restaurante : rest) {
			// Si el barrio esta en el mapa:
			List<Restaurante> listRestBarrio = mapa.get(restaurante.getBarrio());
			if (listRestBarrio != null) {
				// añado restaurante a esa lista
				System.out.println("ya existen restaurantes en ese barrio en la lista");
				listRestBarrio.add(restaurante);
			} else {
				// Si no: creo una lista nueva y add ese restaurante
				List<Restaurante> listNueva = new ArrayList<>();
				listNueva.add(restaurante);
				mapa.put(restaurante.getBarrio(), listNueva);
			}
		}
		
		
		return mapa;
	}

}

/*
 * package restaurantesmalaga;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import restaurantesmalaga.model.ComparadorRestaurantes;
import restaurantesmalaga.model.Restaurante;

public class MainMapas {
	
	
	private static final String RUTA_FICHERO = "restaurantes.txt";
	
	public static void main(String[] args) throws IOException {
		

		//TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists())
		{
			System.out.println("FICHERO EXISTE!, a parsearlo :)");
			Path path = file.toPath();//convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);//leo todo el fichero en una línea
			List<Restaurante> listRest =  MainRestaurante.cargarRestaurantes(lineas);
			
			Map<String, Restaurante> mapaRestaurantes = new TreeMap<>();
			
			for (Restaurante r : listRest)
			{
				mapaRestaurantes.put(r.getNombre(), r);
			}
			//TODO partiendo de la lista de restaurantes cargada
			//haced un mapa, donde la clave sea el barrio
			//y el valor, la lista de restaurantes de ese barrio
			
			
			
			System.out.println(mapaRestaurantes);
			
			Restaurante rp = mapaRestaurantes.get("La Parrilla");
			System.out.println(rp.toString());
			
			Map<String, List<Restaurante>> mapaRestaurantesPorBarrios = null;
			mapaRestaurantesPorBarrios = crearMapRestaurantesPorBarrios(listRest);
			Set<String> clavesMapa = mapaRestaurantesPorBarrios.keySet();
			for (String barrio : clavesMapa)
			{
				List<Restaurante> lrb = mapaRestaurantesPorBarrios.get(barrio);
				System.out.println("BARRIO =  " + barrio);
				for (Restaurante rb : lrb)
				{
					System.out.println(rb.toString());
				}
			}
			
		}
		else {
			System.out.println("FICHERO NO EXISTE!");
		}
	}
	
	
	public static Map<String, List<Restaurante>> crearMapRestaurantesPorBarrios (List<Restaurante> lr)
	{
		Map<String, List<Restaurante>> mapa = new HashMap<>();
		
		//recorro la lista
			//si el barrio ya está en el mapa
				//añado restaurante a esa lista
			//si no, creo lista nueva y add ese restaurante
		
			for (Restaurante r : lr)
			{
				List<Restaurante> lrb = mapa.get(r.getBarrio());
				if (lrb!=null)
				{
					System.out.println("ya existen restaurantes con ese barrio");
					lrb.add(r);
				} else {
					List<Restaurante> lnueva = new ArrayList<>();
					lnueva.add(r);
					mapa.put(r.getBarrio(), lnueva);
				}
			}
			
		return mapa;
		
	}*/
