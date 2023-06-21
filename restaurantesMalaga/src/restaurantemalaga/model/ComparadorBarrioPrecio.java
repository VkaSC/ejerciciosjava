package restaurantemalaga.model;

import java.util.Comparator;

public class ComparadorBarrioPrecio implements Comparator<Restaurante> {

	@Override
	public int compare(Restaurante o1, Restaurante o2) {
		//ordenamos por barrio
		int resultadoBarrio =o1.getBarrio().compareTo(o2.getBarrio());
		//Si el barrio coincide, ordenamos por precio medio. Si no, solo nos devuelve la ordenación por barrios.
		if (resultadoBarrio == 0) {
			int resultado = 0;
			if (o1.getPrecioMedio() > o2.getPrecioMedio()) {
				resultado = 1;
			} else if (o1.getPrecioMedio() < o2.getPrecioMedio()){
				resultado = -1;
			}
			return resultado;
		} else {
			return resultadoBarrio;
		}
		
		
		
	}

}
