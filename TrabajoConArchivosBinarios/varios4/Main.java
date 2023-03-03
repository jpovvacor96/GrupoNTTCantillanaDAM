package varios4;

import java.util.Scanner;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Main {

	public static void main(String[] args) {
		int opcion;
		System.out.println("Buenos días. Iniciando la aplicación...");
		Cliente.cargaDatosIniciales();
		do {
			System.out.println("###################");
			System.out.println("GESTIÓN DE CLIENTES");
			System.out.println("###################\n");
			System.out.println("1. Añadir nuevo cliente");
			System.out.println("2. Modificar datos");
			System.out.println("3. Dar de baja a un cliente");
			System.out.println("4. Listar los clientes");
			System.out.println("5. Salir del programa\n");
			opcion=new Scanner(System.in).nextInt();
			switch(opcion) {
			case 1:
				Cliente.nuevoCliente();
				break;
			case 2:
				Cliente.menuModificaDatos();
				break;
			case 3:
				Cliente.eliminarCliente();
				break;
			case 4:
				Cliente.muestraClientes();
				break;
			case 5:
				Cliente.guardaDatos();
				break;
			default:
				System.err.println("No existe esa opción");
				break;
			}
		}while(opcion!=5);
	}
	
}
