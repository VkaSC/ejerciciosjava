package basicos;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * TODO HACED UNA APLICACIÓN QUE PERMITA INTRODUCIR AL USUARIO SU ESTATURA EN
 * METROS Y SU PESO EN KG Y LE INFORME SU INFORME DE SU ÍNDICE DE MASA CORPORAL
 * (IMC) SEGÚN LA SIGUIENTE FÓRMULA
 * 
 * LA FÓRMULA DEL IMC = PESO KG / ESTATURA AL CUADRADO METROS
 * SI IMC < 16 ->> su imc es DESNUTRIDO 
 * SI IMC >= 16 Y < 18 ->> su imc es DELGADO 
 * SI IMC >= 18 Y < 25 ->> su imc es IDEAL 
 * SI IMC >= 25 Y < 31 ->> su imc es SOBREPESO 
 * SI IMC >= 31 ->> su imc es OBESO 
 * ADEMÁS, DE DECIRLE SU IMC NUMÉRICO Y NOMINAL,
 * pista: PARA LEER DE TECLADO USAD LA CLASE SCANNER
 */
public class AppImc {


	//App
	public static void main(String[] args) {

		// Menu consola
		System.out.println("Ejercicio IMC  \n\n");
		System.out.println("0 --------------------0");
		System.out.println("|   Calcula tu IMC    |");
		System.out.println("0 --------------------0 \n");
		System.out.println("Para poder realizar el cálculo de su índice de masa corporal (IMC) de forma correcta,\nnecesitamos que nos proporcione su altura, peso y sexo\n\n");

		//Declaración de variables
		double imc = 0;
		String resultado = "";
		int option = 0;
				
		
		//Formateamos el resultado para que solo muestre 3 decimales
		DecimalFormat formatImc = new DecimalFormat("#.###");
		
		//Recogemos datos por consola (llamando al método 'readNumber()')
		double altura = Console.readDouble("Introduzca su altura en M :", "El dato introducido no es correcto\nIntroduzca un valor superior a 0.5\n", 0.5, 3.0);
		double peso = Console.readDouble("Introduzca su peso en Kg:", "El dato introducido no es correcto\nIntroduzca un valor superior a 2.5\n", 2.5);
		option = Console.readNumber("Seleccione una opción:\n1 Sexo masculino\n2 Sexo femenino", "El dato introducido no es correcto\nIntroduzca '1' para masculino y '2' si es femenino\n", 1, 2);
	
		//Calculamos el IMC y lo mostramos por pantalla
		imc = peso / (altura * altura);
		System.out.println("Su indice de masa corporal (IMC) es: " + formatImc.format(imc) + "\n");
		
		//Asignamos valor nominal al IMC y lo mostramos por pantalla0
		switch (option) {
		case 1: {
			if (imc <16 ) {
				resultado = "DESNUTRICION";
				System.out.println("Presenta " + resultado + ", vigile su alimentación y consulte un especialista");
			}else if (imc >= 16 && imc < 20) {
				resultado = "DELGADEZ";
				System.out.println("Presenta " + resultado + ", vigile su alimentación y consulte un especialista");
			}else if (imc >= 20 && imc < 24) {
				resultado = "IDEAL";
				System.out.println("Presenta un peso " + resultado + ". FELICIDADES!!!");
			}else if (imc >= 24 && imc < 29) {
				resultado = "SOBREPESO";
				System.out.println("Presenta " + resultado + ", vigile su alimentación y consulte un especialista");
			}else if (imc >29) {
				resultado = "OBESIDAD";
				System.out.println("Presenta " + resultado + ", vigile su alimentación y consulte un especialista");
			}
			break;
		}
		
		case 2: {
			if (imc <17 ) {
				resultado = "DESNUTRICION";
				System.out.println("Presenta " + resultado + " ,vigile su alimentación y consulte un especialista");
			}else if (imc >= 17 && imc < 20) {
				resultado = "DELGADEZ";
				System.out.println("Presenta " + resultado + " ,vigile su alimentación y consulte un especialista");
			}else if (imc >= 20 && imc < 25) {
				resultado = "IDEAL";
				System.out.println("Presenta un peso " + resultado + " .FELICIDADES!!!");
			}else if (imc >= 25 && imc < 30) {
				resultado = "SOBREPESO";
				System.out.println("Presenta " + resultado + " ,vigile su alimentación y consulte un especialista");
			}else if (imc >30) {
				resultado = "OBESIDAD";
				System.out.println("Presenta " + resultado + " ,vigile su alimentación y consulte un especialista");
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

		
		
	}

}
