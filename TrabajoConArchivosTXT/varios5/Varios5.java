package varios5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

/**
 * Simula un libro de firmas, permitiendo registrar a todas las personas que van pasando por un
 * lugar determinado. Permite añadir un nuevo nombre, comprobando que ese nombre no se encuentre ya
 * con anterioridad en el registro y mostrar todos los nombres de las personas que han firmado
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios5 {
	
	public static void firma(String nombre) throws IOException{
		if (Varios5.estaEseNombre(nombre)) {
			System.err.println("Esta persona ya ha firmado");	
		}
		else if (nombre=="") {
			System.err.println("Debe introducir un nombre válido");
		}
		else {
			BufferedWriter out=new BufferedWriter(new FileWriter("/media/Archivos/DAM/"
			+ "Programación/eclipse-workspace-1dam/TrabajoConArchivosTXT/src/varios5/firmas.txt",
			true));
			out.write(nombre);
			out.newLine();
			System.out.println("Firma registrada correctamente");
			out.close();
		}
	}
	
	public static boolean estaEseNombre(String nombre) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("/media/Archivos/DAM/"
			+ "Programación/eclipse-workspace-1dam/TrabajoConArchivosTXT/src/varios5/firmas.txt"));
		boolean encontrado;
		encontrado=false;
		String linea;
		linea=in.readLine();
		while(linea!=null) {
			if(linea.equals(nombre)) {
				encontrado=true;
				linea=null;
			}
			linea=in.readLine();
		}
		in.close();
		return encontrado;
	}
	
	public static void muestraFirmas() throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("/media/Archivos/DAM/"
			+ "Programación/eclipse-workspace-1dam/TrabajoConArchivosTXT/src/varios5/firmas.txt"));
		String linea;
		linea=in.readLine();
		while(linea!=null) {
			System.out.println(linea);
			linea=in.readLine();
		}
		in.close();
	}
	
	public static void main(String[] args) {
		try (Scanner teclado=new Scanner(System.in)) {
			int opcion;
			do {
				System.out.println("\n\n##################");
				System.out.println("CONTROL DE ACCESOS");
				System.out.println("##################");
				System.out.println("1. Insertar un nuevo nombre");
				System.out.println("2. Mostrar libro de firmas");
				System.out.println("3. Salir del programa\n\n");
				opcion=teclado.nextInt();
				switch(opcion) {
				case 1:
					String nombre;
					System.out.println("Introduce el nombre:");
					nombre=new Scanner(System.in).nextLine();
					Varios5.firma(nombre);
					break;
				case 2:
					System.out.println("Lista de firmas:");
					Varios5.muestraFirmas();
					break;
				case 3:
					System.out.println("Que tenga un buen día");
					break;
				default:
					System.err.println("Opción inválida");
					break;
				}
			}while(opcion!=3);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
