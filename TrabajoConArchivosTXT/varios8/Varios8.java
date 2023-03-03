package varios8;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

/**
 * A partir de un archivo de texto con un mensaje que queremos codificar, se crea mediante un código un
 * mensaje cifrado, el cual se escribe en otro archivo de texto
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios8 {
	
	public static final String RUTA_CIFRADO="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/cifrado.txt";
	
	public static final String RUTA_CODEC="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/codec.txt";
	
	public static final String RUTA_MENSAJE="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/mensaje.txt";
	
	/**
	 * Lee el mensaje que queremos codificar de un archivo de texto determinado
	 * @param url Ruta al archivo donde se encuentra el mensaje que queremos codificar
	 * @return Lista que contiene el mensaje que queremos codificar
	 * @throws IOException
	 */
	public static List<String> leeMensaje(String url) throws IOException{
		List<String> mensaje=new ArrayList<>();
		BufferedReader in=new BufferedReader(new FileReader(url));
		String linea=in.readLine();
		if (linea==null) {
			System.err.println("Error: el fichero está vacío");
		}
		else {
			while(linea!=null) {
				mensaje.add(linea);
				linea=in.readLine();
			}
		}
		in.close();
		return mensaje;
	}
	
	/**
	 * Accede al archivo que contiene el código para codificar el mensaje y devuelve su contenido
	 * en forma de lista
	 * @param url Dirección de memoria del archivo que contiene la codificación
	 * @return Contenido del archivo de la codificación en forma de lista
	 * @throws IOException
	 */
	private static List<String> obtieneCodigo(String url) throws IOException{
		List<String> codigo=new ArrayList<>();
		BufferedReader in=new BufferedReader(new FileReader(url));
		codigo.add(in.readLine());
		codigo.add(in.readLine());
		in.close();
		return codigo;
	}
	
	/**
	 * Codifica el mensaje contenido en forma de lista que le pasamos como parámetro
	 * @param mensaje Lista que contiene el mensaje que queremos codificar
	 * @param urlCodec Dirección de memoria en la que se encuentra el código
	 * @return Mensaje codificado en forma de lista
	 */
	public static List<String> codificaMensaje(List<String> mensaje, String urlCodec) throws IOException{
		List<String> mensajeCodificado=new ArrayList<>();
		List<String> codigo=Varios8.obtieneCodigo(urlCodec);
		//Por cada línea del mensaje
		for (String linea: mensaje) {
			String lineaCodificada="";
			String palabras[]=linea.split(" ");
			//Por cada palabra de cada línea
			for (int i=0;i<=palabras.length-1;i++) {
				String palabraCodificada="";
				//Por cada letra de cada palabra
				for (int j=0;j<=palabras[i].length()-1;j++) {
					//Por cada letra del alfabeto
					for (int k=0;k<=codigo.get(0).length()-1;k++) {
						if (palabras[i].charAt(j)==codigo.get(0).charAt(k)) {
							//Si coincide el carácter de la palabra con una letra del alfabeto concreta,
							//se añade a la palabra codificada el carácter correspondiente
							palabraCodificada=palabraCodificada+codigo.get(1).charAt(k);
						}
					}
				}
				lineaCodificada=lineaCodificada+" "+palabraCodificada;
			}
			mensajeCodificado.add(lineaCodificada);
		}
		return mensajeCodificado;
	}
	
	/**
	 * Escribe en un fichero de texto determinado el mensaje cifrado
	 * @param url Dirección del archivo donde escribiremos el mensaje cifrado
	 * @param mensajeCodificado Mensaje codificado que queremos escribir
	 * @throws IOException
	 */
	public static void escribeMensajeCodificado(String url, List<String> mensajeCodificado) throws IOException{
		File cifrado=new File(url);
		cifrado.createNewFile();
		BufferedWriter out=new BufferedWriter(new FileWriter(url, false));
		for (int i=0;i<=mensajeCodificado.size()-1;i++) {
			out.write(mensajeCodificado.get(i));
			out.newLine();
		}
		out.close();
	}
	
	/**
	 * Método main sobre el que opera el programa
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<String> mensaje=Varios8.leeMensaje(RUTA_MENSAJE);
			List<String> mensajeCodificado=Varios8.codificaMensaje(mensaje, RUTA_CODEC);
			Varios8.escribeMensajeCodificado(RUTA_CIFRADO, mensajeCodificado);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
