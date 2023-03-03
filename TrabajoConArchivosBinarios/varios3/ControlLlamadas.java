package varios3;

import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class ControlLlamadas {
	
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos/DAM/Programación"
			+ "/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosBinarios/ficheros/texto.bin";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<RegistroLlamadas> registros = new ArrayList<RegistroLlamadas>();
		boolean running = true;

		// Cargar datos desde el archivo
		try (DataInputStream input = new DataInputStream(new FileInputStream(RUTA_ARCHIVO))) {
			while (input.available() > 0) {
				LocalDate fecha = LocalDate.parse(input.readUTF());
				int llamadas = input.readInt();
				registros.add(new RegistroLlamadas(fecha, llamadas));
			}
			System.out.println("Datos cargados correctamente.");
		} catch (IOException ex) {
			System.out.println("No se pudo cargar el archivo.");
		} catch (DateTimeParseException ex) {
			System.out.println("El formato de fecha en el archivo es incorrecto.");
		}

		// Menú
		while (running) {
			System.out.println("1. Añadir número de llamadas");
			System.out.println("2. Ver lista completa");
			System.out.println("3. Salir");
			System.out.print("Elija una opción: ");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.print("Ingrese la fecha (formato YYYY-MM-DD): ");
				String fechaString = scanner.next();
				LocalDate fecha = null;
				try {
					fecha = LocalDate.parse(fechaString);
				} catch (DateTimeParseException ex) {
					System.out.println("Formato de fecha inválido.");
					break;
				}
				System.out.print("Ingrese el número de llamadas recibidas hoy: ");
				int llamadasHoy = scanner.nextInt();
				registros.add(new RegistroLlamadas(fecha, llamadasHoy));
				System.out.println("Registro de llamadas añadido correctamente.");
				break;
			case 2:
				System.out.println("Lista de registros de llamadas:");
				for (RegistroLlamadas registro : registros) {
					System.out.println(registro);
				}
				break;
			case 3:
				running = false;
				break;
			default:
				System.out.println("Opción inválida.");
			}
		}

		// Guardar datos en el archivo
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
			for (RegistroLlamadas registro : registros) {
				output.writeUTF(registro.getFecha().toString());
				output.writeInt(registro.getLlamadas());
			}
			System.out.println("Datos guardados correctamente.");
		} catch (IOException ex) {
			System.out.println("No se pudo guardar el archivo.");
		}
		scanner.close();
	}
}