package varios2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Pide al usuario su nombre y su edad y guarda dichos datos personales en un fichero de texto. Si
 * existe, se borra su contenido, y si no, se crea uno nuevo
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios2 {
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/";

	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			System.out.print("Ingrese su nombre: ");
			String nombre = teclado.nextLine();
			System.out.print("Ingrese su edad: ");
			int edad = teclado.nextInt();
			File datos = new File(RUTA_ARCHIVO+"datos.txt");
			if (datos.exists()) {
				datos.delete();
			}
			try {
				datos.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				FileWriter creador = new FileWriter(datos);
				creador.write(nombre + "\n");
				creador.write(edad + "\n");
				creador.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}