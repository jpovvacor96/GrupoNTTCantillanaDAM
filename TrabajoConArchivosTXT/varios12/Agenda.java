package varios12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agenda {
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/agenda.txt";
	
	private static List<Persona> contactos = new ArrayList<Persona>();
	private static List<Persona> nuevosContactos = new ArrayList<Persona>();

	public static void main(String[] args) {
		boolean hayDatos = comprobarDatos();
		Scanner scanner = new Scanner(System.in);
		int e;
		do {
			imprimirMenu();
			e = scanner.nextInt();
			scanner.nextLine();
			acciones(e, hayDatos, scanner);
		} while (e != 4);
		scanner.close();
	}

	public static boolean comprobarDatos() {
		File archivo = new File(RUTA_ARCHIVO);
		if (archivo.exists()) {
			try (Scanner scanner = new Scanner(archivo)) {
				while (scanner.hasNextLine()) {
					String linea = scanner.nextLine();
					String[] datos = linea.split(" ");
					String nombre = datos[0];
					int telefono = Integer.parseInt(datos[1]);
					contactos.add(new Persona(nombre, telefono));
				}
				System.out.println("Agenda cargada correctamente desde agenda.txt");
			} catch (Exception ex) {
				System.out.println("Error al leer el archivo agenda.txt");
			}
			return true;
		} else
			return false;
	}

	public static void imprimirMenu() {
		System.out.println("---------------------------Menú---------------------------");
		System.out.println("1.- Nuevo Contacto");
		System.out.println("2.- Buscar por nombre");
		System.out.println("3.- Mostrar datos");
		System.out.println("4.- Salir");
	}

	public static void acciones(int e, boolean hayDatos, Scanner scanner) {
		String nombre;
		switch (e) {
		case 1:
			System.out.println("Introduce el nombre");
			nombre = scanner.nextLine();
			System.out.println("Introduce el número de teléfono");
			int telefono = scanner.nextInt();
			contactos.add(new Persona(nombre, telefono));
			nuevosContactos.add(new Persona(nombre, telefono));
			break;
		case 2:

			System.out.println("Introduzca la búsqueda");
			nombre = scanner.nextLine();
			boolean encontrado = false;
			System.out.println("Resultado de la búsqueda: ");
			for (Persona p : contactos) {
				if (p.getNombre().equals(nombre)) {
					System.out.println(p.toString());
					if (!encontrado)
						encontrado = true;
				}
			}
			if (!encontrado)
				System.out.println("No se encontró ningún resultado");
			break;
		case 3:
			Collections.sort(contactos);
			contactos.forEach(p -> System.out.println(p.toString()));

			break;
		case 4:
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, hayDatos))) {

				for (Persona p : nuevosContactos) {
					writer.write(p.toString() + "\n");
				}
				System.out.println("Agenda guardada correctamente en agenda.txt");
			} catch (Exception ex) {
				System.out.println("Error al guardar la agenda");
			}

			break;

		default:
			System.out.println("Opción no valida");
			break;
		}

	}

}
