package varios1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Programa que solicita al usuario el nombre de un fichero de texto, y muestra su contenido por
 * pantalla. Si no se proporciona ningún nombre, la aplicación utiliza por dfecto el nombre de 
 * "prueba.txt"
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios1 {

	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			System.out.print("Introduce el nombre del archivo: ");
			String nFichero = teclado.nextLine();

			if (nFichero.isEmpty()) {
				nFichero = "prueba.txt";
			}

			try {
				FileReader fichero = new FileReader(nFichero);
				BufferedReader lector = new BufferedReader(fichero);

				String linea = lector.readLine();
				while (linea != null) {
					System.out.println(linea);
					linea = lector.readLine();
				}

				lector.close();

			} catch (IOException e) {
				System.out.println("No se pudo leer el archivo " + nFichero);
			}
		}

	}
}
