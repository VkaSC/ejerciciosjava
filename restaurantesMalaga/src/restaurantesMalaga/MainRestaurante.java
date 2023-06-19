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
		// TODO cargar lista restaurante del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists()) {
			System.out.println("FICHERO EXISTE!!, a parsearlo :)");
			Path path = file.toPath();
			List<String> lineas = Files.readAllLines(path);
			List<Restaurante> listRest = cargarRestaurantes(lineas);
			System.out.println("La lista tiene: "+ listRest.size() + " restaurantes.");
			
		} else {
			System.out.println("NO EXISTE!!, el fichero en esta ruta :(");
		}

	}

}
