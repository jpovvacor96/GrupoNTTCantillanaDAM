package varios4;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	
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
	
	public static void nuevoCliente() {
		int id, telefono;
		String nombre;
		System.out.println("Introduzca el identificador del cliente:");
		id=new Scanner(System.in).nextInt();
		System.out.println("Introduzca el nombre y los apellidos:");
		nombre=new Scanner(System.in).nextLine();
		System.out.println("Introduzca el teléfono:");
		telefono=new Scanner(System.in).nextInt();
		new Cliente(id, nombre, telefono);
		System.out.println("Nuevo cliente añadido correctamente");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
