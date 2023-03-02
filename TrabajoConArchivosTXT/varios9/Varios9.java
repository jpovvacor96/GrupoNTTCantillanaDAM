package varios9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizando el código correspondiente, decodifica un mensaje cifrado almacenado en un archivo de texto
 * y almacena el contenido de dicho archivo descodificado en otro archivo de texto
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios9 {
	
	/**
	 * Lee el archivo de texto que contiene el mensaje cifrado y devuelve su contenido en
	 * forma de lista
	 * @param url Dirección en memoria del archivo que contiene el mensaje cifrado
	 * @return Lista que contiene el mensaje cifrado obtenido de un archivo de texto
	 * @throws IOException
	 */
	public static List<String> leeMensajeCifrado(String url) throws IOException{
		List<String> mensajeCifrado=new ArrayList<>();
		BufferedReader in=new BufferedReader(new FileReader(url));
		String linea=in.readLine();
		if (linea==null) {
			System.err.println("Error: el fichero está vacío");
		}
		else {
			while(linea!=null) {
				mensajeCifrado.add(linea);
				linea=in.readLine();
			}
		}
		in.close();
		return mensajeCifrado;
	}
	
	/**
	 * Lee el archivo de texto que contiene el código y lo devuelve en forma de lista
	 * @param url Dirección en memoria del archivo de texto que contiene el código
	 * @return Lista que contiene el código utilizado para descifrar el mensaje
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
	 * Decodifica el mensaje cifrado con ayuda del código
	 * @param mensaje Lista que contiene el mensaje cifrado
	 * @param urlCodec Dirección en memoria del archivo de texto que contiene el código
	 * @return Lista que contiene el mensaje descifrado
	 * @throws IOException
	 */
	public static List<String> decodificaMensaje(List<String> mensaje, String urlCodec) throws IOException{
		List<String> mensajeDecodificado=new ArrayList<>();
		List<String> codigo=Varios9.obtieneCodigo(urlCodec);
		//Por cada línea del mensaje
		for (String linea: mensaje) {
			String lineaCodificada="";
			String palabras[]=linea.split(" ");
			//Por cada palabra de cada línea
			for (int i=0;i<=palabras.length-1;i++) {
				String palabraCodificada="";
				//Por cada letra de cada palabra
				for (int j=0;j<=palabras[i].length()-1;j++) {
					//Por cada letra detectada
					for (int k=0;k<=codigo.get(0).length()-1;k++) {
						if (palabras[i].charAt(j)==codigo.get(1).charAt(k)) {
							palabraCodificada=palabraCodificada+codigo.get(0).charAt(k);
						}
					}
				}
				lineaCodificada=lineaCodificada+" "+palabraCodificada;
			}
			mensajeDecodificado.add(lineaCodificada);
		}
		return mensajeDecodificado;
	}
	
	/**
	 * Escribe el mensaje decodificado en un archivo de texto, cuya dirección en memoria se introduce
	 * como parámetro
	 * @param url Dirección en memoria del archivo de texto que contendrá el mensaje descifrado
	 * @param mensajeDecodificado Lista que contiene el mensaje decodificado
	 * @throws IOException
	 */
	public static void escribeMensajeDecodificado(String url, List<String> mensajeDecodificado) throws IOException{
		File mensaje=new File(url);
		mensaje.createNewFile();
		BufferedWriter out=new BufferedWriter(new FileWriter(url, false));
		for (int i=0;i<=mensajeDecodificado.size()-1;i++) {
			out.write(mensajeDecodificado.get(i));
			out.newLine();
		}
		out.close();
	}
	
	/**
	 * Método main sobre el que trabaja el programa
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<String> mensaje=Varios9.leeMensajeCifrado("/media/Archivos/DAM/Programación/eclipse-"
					+ "workspace-1dam/TrabajoConArchivosTXT/src/varios9/cifrado.txt");
			List<String> mensajeCodificado=Varios9.decodificaMensaje(mensaje, "/media/Archivos/DAM/Programación"
					+ "/eclipse-workspace-1dam/TrabajoConArchivosTXT/src/varios9/codec.txt");
			Varios9.escribeMensajeDecodificado("/media/Archivos/DAM/Programación"
					+ "/eclipse-workspace-1dam/TrabajoConArchivosTXT/src/varios9/mensaje.txt", mensajeCodificado);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
