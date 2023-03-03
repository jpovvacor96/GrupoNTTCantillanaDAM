package varios4;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Cliente implements Serializable{
	
	//##################
	//LISTA DE ATRIBUTOS
	//##################
	
	private int id;
	private String nombre;
	private int telefono;
	public static List<Cliente> listaClientes=new ArrayList<>();
	public static final String RUTA_ARCHIVO="/media/jose/Archivos/DAM/"
			+ "Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosBinarios/varios4/clientes.bin";
	
	
	//#########################
	//MÉTODOS SETTERS Y GETTERS
	//#########################
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int n) {
		this.id=n;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String s) {
		this.nombre=s;
	}
	
	public int getTelefono() {
		return this.telefono;
	}
	
	public void setTelefono(int n) {
		this.telefono=n;
	}
	
	//#############
	//CONSTRUCTORES
	//#############
	
	public Cliente(int id, String nombre, int telefono) {
		this.setId(id);
		this.setNombre(nombre);
		this.setTelefono(telefono);
	}
	
	//###################
	//MÉTODOS FUNCIONALES
	//###################
	
	public static void cargaDatosIniciales() {
		try {
			if(!new File(Cliente.RUTA_ARCHIVO).exists()) {
				System.out.println("No existen datos que importar");
			}
			else {
				ObjectInputStream entrada=new ObjectInputStream(new FileInputStream
						(Cliente.RUTA_ARCHIVO));
				Cliente.listaClientes=(List<Cliente>) entrada.readObject();
				System.out.println("Datos importados correctamente");
			}
		}
		catch(IOException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	private static boolean yaExisteCliente(int id) {
		boolean existe=false;
		for (Cliente c:Cliente.listaClientes) {
			if (c.getId()==id) {
				existe=true;
			}
		}
		return existe;
	}
	
	public static void nuevoCliente() {
		int id, telefono;
		String nombre;
		System.out.println("Introduzca el identificador del cliente:");
		id=new Scanner(System.in).nextInt();
		while(Cliente.yaExisteCliente(id)) {
			System.err.println("Ya existe un cliente con este identificador");
			System.out.println("Introduzca el identificador del cliente:");
			id=new Scanner(System.in).nextInt();
		}
		System.out.println("Introduzca el nombre y los apellidos:");
		nombre=new Scanner(System.in).nextLine();
		System.out.println("Introduzca el teléfono:");
		telefono=new Scanner(System.in).nextInt();
		Cliente.listaClientes.add(new Cliente(id, nombre, telefono));
		System.out.println("Nuevo cliente añadido correctamente");
	}
	
	public static void menuModificaDatos() {
		int id, opcion;
		System.out.println("Introduzca el identificador del cliente del cual desea modificar datos:");
		id=new Scanner(System.in).nextInt();
		while(!Cliente.yaExisteCliente(id)) {
			System.err.println("No existe ningún cliente con ese modificador");
			System.out.println("Introduzca un identificador válido:");
			id=new Scanner(System.in).nextInt();
		}
		System.out.println("1. Modificar el identificador");
		System.out.println("2. Modificar el nombre y los apellidos");
		System.out.println("3. Modificar el número de teléfono");
		System.out.println("4. Cancelar la operación");
		opcion=new Scanner(System.in).nextInt();
		Cliente.modificaDatos(id, opcion);
	}
	
	public static void modificaDatos(int id, int opcion) {
		int posicion=0;
		for (int i=0;i<=Cliente.listaClientes.size()-1;i++) {
			if (Cliente.listaClientes.get(i).getId()==id) {
				posicion=i;
			}
		}	
		switch(opcion) {
		case 1:
			System.out.println("Introduzca el nuevo identificador:");
			int iden=new Scanner(System.in).nextInt();
			Cliente.listaClientes.get(posicion).setId(iden);
			break;
		case 2:
			System.out.println("Introduzca el nuevo nombre y apellidos:");
			String nombre=new Scanner(System.in).nextLine();
			break;
		case 3:
			System.out.println("Introduzca el nuevo número de teléfono:");
			int telefono=new Scanner(System.in).nextInt();
			break;
		case 4:
			System.out.println("Operación cancelada");
			break;
		default:
			System.err.println("No existe esa opción");
		}
	}
	
	public static void muestraClientes() {
		System.out.println("\n#################");
		System.out.println("LISTA DE CLIENTES");
		System.out.println("#################\n");
		if (Cliente.listaClientes.isEmpty()) {
			System.out.println("No existe ningún cliente");
		}
		else {
			for (Cliente c:Cliente.listaClientes) {
				System.out.println(c.getId()+"--"+c.getNombre()+"--"+c.getTelefono());
			}
		}
	}
	
	public static void eliminarCliente() {
		System.out.println("Introduzca el identificador del cliente que desea eliminar:");
		int iden=new Scanner(System.in).nextInt();
		while(!Cliente.yaExisteCliente(iden)) {
			System.err.println("No existe ningún cliente con ese modificador");
			System.out.println("Introduzca un identificador válido:");
			iden=new Scanner(System.in).nextInt();
		}
		for (int i=0;i<=Cliente.listaClientes.size()-1;i++) {
			if (Cliente.listaClientes.get(i).getId()==iden) {
				Cliente.listaClientes.remove(i);
			}
		}
		System.out.println("Cliente eliminado correctamente");
	}
	
	public static void guardaDatos() {
		try (ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(Cliente.RUTA_ARCHIVO))){
			salida.writeObject(Cliente.listaClientes);
			System.out.println("Datos guardados correctamente");
		}
		catch(IOException e) {
			System.err.println("Se ha producido un error en la grabación de los datos");
		}
	}
	

}
