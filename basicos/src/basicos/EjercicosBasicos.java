package basicos;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO perteneceACadena 
 * 2) HACER UN MÉTODO QUE RECIBA UNA
 * CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
 * 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
 * posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
 * 
 * "hola" a --> 3 "maja" a --> 3 "conejo" i --> -1
 * 
 * 
 * 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar
 * 4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE
 * EDAD O NO mayorDeEdad 
 * 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA
 * SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota -
 * 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena 
 * 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99 deTresEnTres
 *
 *
 * // DEFINO UN MÉTODO // DARLE UN NOMBRE - camelCase // ID la entrada - // ID
 * la salida -
 *
 * //pensar el los pasos en esapñol en psuedocódigo
 */
public class EjercicosBasicos {
	
	public static void main (String[] arg) {
		boolean resultado = isIn("Mälaga", 'g');
		System.out.println(resultado);
		boolean resultado2 = existChar("Mälaga", 'g');
		System.out.println(resultado2);
		boolean resultadoEjercicio3 = isPar(4);
		System.out.println(resultadoEjercicio3);
		boolean resultadoEjercicio4 = esMayorEdad(20);
		System.out.println("Mayor de edad es:" + resultadoEjercicio4);
		//boolean resultadoEjercicio4_1 = esMayorEdadCalculado();
		//System.out.println("Mayor de edad es:" + resultadoEjercicio4_1);
		String resultadoEjercicio5 = clasificarNota(2);
		System.out.println("Tu calificación es: " + resultadoEjercicio5);
		
	}
	
	//1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER PERTENECE A LA CADENA O NO perteneceACadena
	
	private static boolean isIn (String cadena, char car) {
		boolean in=true;
		int cont=0;
		while (cadena.charAt(cont)!=car) {
		++cont;
		}
		if(cadena.charAt(cont)==car) in=true;
		
		else {
			in=false;
		}
		
		return in;
	}
	//2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
	private static boolean existChar(String cad, char car) {
		boolean match = false;
		int pos = 0;
		int length = cad.length()-1;
		while (pos <= length ) {
			match = cad.charAt(pos) == car ? true : false;
			if (match) {
				return match;
			}
			pos++;
		}
		return match;
}
	 //* 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar
	private static boolean isPar (int number) {
		boolean par = false;
		
		if (number%2 == 0) {
			par = true;
		}
		return par;
		
	}
	
	
	//4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO mayorDeEdad 
	private static boolean esMayorEdad (int edad) {
		boolean mayorEdad = false;
		
		if (edad >= 18) {
			mayorEdad = true;
			System.out.println("Es mayor de edad");
		}else {
			System.out.println("Es menor de edad");
		}
		
		return mayorEdad;
	}
	
	/*
	private static boolean esMayorEdadCalculado() {
		boolean mayorEdad = false;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce tu fecha de nacimiento:");
		String fechaNacimiento = input.nextLine();
		System.out.println("Naci el :" + fechaNacimiento);
		
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(fechaNacimiento);
		dtf.f
		
		return mayorEdad;
	}
	*/
	
	//5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota 

	private static String clasificarNota (int nota) {
		String calificacion = "";
			
		
		
		switch (nota) {
		case 1:
		{
							calificacion = "suspenso";
			
			break;
			//yield type;
		}
		case 2 : {
			if (nota >= 5 ) {
				calificacion = "Suficiente";

			}
			break;
			//yield type;
		}
		case  3: {
			if (nota >= 6 ) {
				calificacion = "Bien";

			}
			break;
			//yield type;
		}
		case  4: {
			if (nota >= 7 || nota < 9 ) {
				calificacion = "Notable";

			}
			break;
			//yield type;
		}
		case  5: {
			if (nota >= 9 || nota < 10 ) {
				calificacion = "Sobresaliente";

			}
			break;
			//yield type;
		}
		case  6: {
			if (nota == 10 ) {
				calificacion = "Matrícula de Honor";

			}
			break;
			//yield type;
		}
		
		default:
			System.out.println("El dato introducido (" + nota + ") no es correcto.Introduzca un número del 0 al 10");
		}
		return calificacion;
		
	}
}
	


