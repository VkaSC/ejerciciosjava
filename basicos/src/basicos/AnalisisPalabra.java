package basicos;

/**
 * 
 * 
 * @author Val
 *
 *El código de esta clase, es un poco misterioso. Algún programador Clase "C", no ha usado
 *nombres descriptivos y ahora, nos toca pegarnos y descubrir qué narices hace este código, 
 *para poder usarlo en nuestro proyecto.
 *
 *
 *Se pide:
 *
 *1) Adivinar la funcionalidad del método adivinaQueHace: Comprueba si la palabra que entra por parámetros es un Palíndromo
 *2) Una vez descubierto, aplicar un nombre apropiado al método y a la clase
 *3) Idear un método equivalente, pero distinto. Es decir, crear un método 
 *que haga lo mismo que adivinaQueHace, pero de otra manera.
 *4) EXTRA: Sólo si resolviste los puntos anteriores, implementa una versión recursiva
 *
 */
public class AnalisisPalabra {
	
	private static boolean esPalindromo (String cadena)
	{
		boolean palindromo = true;
		
		int letra1 = 0;
		int letra2 = cadena.length()-1;
		
		while ((letra1<=letra2)&&(palindromo))
		{
			palindromo = cadena.charAt(letra1)==cadena.charAt(letra2);
			letra1++;
			letra2--;
		}
		
		
		return palindromo;
	}
	private static boolean esPalindromo2(String cadena) {
		boolean compara = false;
	
		StringBuilder inverso = new StringBuilder(cadena).reverse();
		
		String cadena2 = inverso.toString();
		
		//System.out.println(cadena2);para comprobar que invierte la cadena
		
			if (cadena2.equals(cadena)) {
				compara = true;
			}
			
			return compara;
	}
	
	//Recursividad
	public static boolean compararCadenaRecursiva (int inicio, int fin, String cad) 
	{
		if (inicio >=fin)
			return true;
			
		else {
			return cad.charAt(inicio )== cad.charAt(fin)&& compararCadenaRecursiva(++inicio, --fin, cad);
					
		}
	}
	
	
	public static void main(String[] args) {
		if (esPalindromo("poop"))
		{
			System.out.println("VERDADERO");
		} else 
		{
			System.out.println("FALSO");
		}
		if (esPalindromo2("ramar"))
		{
			System.out.println("ES UN PALINDROMO");
		} else 
		{
			System.out.println("NO ES UN PALINDROMO");
		}
		
		String palabraXp = new String ("salamandra");
		
		if (compararCadenaRecursiva(0, palabraXp.length()-1, palabraXp)) {
			System.out.println("ES UN PALINDROMO");
		} else 
		{
			System.out.println("NO ES UN PALINDROMO");
		
	}

}}