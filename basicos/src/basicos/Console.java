package basicos;

import java.util.Scanner;

public class Console {
	
	
	/**
	 * 
	 * @param message (Mensaje que mostramos al usuario por consola)
	 * @param erroMessage (Mensaje mostrado al usuario por consola en caso de error)
	 * @param minimunValue (controlamos que no pueda introducir un número inferior a lo establecido)
	 * @param maxValue  (controlamos que no pueda introducir un número superior a lo establecido)
	 * @return número entero
	 */
	public static int readNumber(String message, String erroMessage, int minimunValue, int maxValue ) {

		int number = 0;
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		do {
			System.out.println(message);
			String userData = scanner.nextLine();
			
			//Control de errores
			try {
				// convertimos a número decimal el string recogido por consola
				number = Integer.valueOf(userData);
				
				//comprobamos que el valor introducido por el usuario no sea inferior al valor mínimo
				isCorrect = number >= minimunValue && number <= maxValue;
				
				//Si el valor es inferior mostramos un mensaje de error por consola
				if (!isCorrect) {
					System.out.println(erroMessage);
				}
			} catch (Exception e) {
				isCorrect = false;
				System.out.println(erroMessage);
			}
		} while (!isCorrect);

		return number;
	}

	/**
	 * 
	 * @param message      (Mensaje que mostramos al usuario por consola)
	 * @param erroMessage  (Mensaje mostrado al usuario por consola en caso de error)
	 * @param minimunValue (controlamos que no pueda introducir un número inferior a lo establecido)
	 * @return número decimal
	 */
	public static double readDouble(String message, String erroMessage, Double minimunValue) {

		double number = 0;
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		do {
			System.out.println(message);
			String userData = scanner.nextLine();
			
			//Control de errores
			try {
				// convertimos a número decimal el string recogido por consola
				number = Double.valueOf(userData);
				
				//comprobamos que el valor introducido por el usuario no sea inferior al valor mínimo
				isCorrect = number >= minimunValue;
				
				//Si el valor es inferior mostramos un mensaje de error por consola
				if (!isCorrect) {
					System.out.println(erroMessage);
				}
			} catch (Exception e) {
				isCorrect = false;
				System.out.println(erroMessage);
			}
		} while (!isCorrect);

		return number;
	}
	
	
	/**
	 * 
	 * @param message (Mensaje que mostramos al usuario por consola)
	 * @param erroMessage (Mensaje mostrado al usuario por consola en caso de
	 *                     error)
	 * @param minimunValue (controlamos que no pueda introducir un número inferior a
	 *                     lo establecido)
	 * @param maxValue (controlamos que no pueda introducir un número superior a
	 *                     lo establecido)
	 * @return (Número decimal)
	 */
	public static double readDouble(String message, String erroMessage, Double minimunValue, Double maxValue ) {

		double number = 0;
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = false;
		do {
			System.out.println(message);
			String userData = scanner.nextLine();
			
			//Control de errores
			try {
				// convertimos a número decimal el string recogido por consola
				number = Double.valueOf(userData);
				
				//comprobamos que el valor introducido por el usuario no sea inferior al valor mínimo
				isCorrect = number >= minimunValue && number <= maxValue;
				
				//Si el valor es inferior mostramos un mensaje de error por consola
				if (!isCorrect) {
					System.out.println(erroMessage);
				}
			} catch (Exception e) {
				isCorrect = false;
				System.out.println(erroMessage);
			}
		} while (!isCorrect);

		return number;
	}
	
	/**
	 * 
	 * @return devuelve los datos introducidos por el usuario
	 */
	public static String readLine(String message) {

		Scanner scanner = new Scanner(System.in);
		System.out.println(message);

		return scanner.nextLine();
	}

}
