package varios12;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int telefono;
	
	public Persona(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombre + " " +telefono;
	}

	@Override
	public int compareTo(Persona o) {
		return this.getNombre().compareTo(o.getNombre());
	}
	
	
	

}