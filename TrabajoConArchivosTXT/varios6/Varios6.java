package varios6;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


public class Varios6 {
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/texto.txt";
	
	public static void mostrar24() throws IOException{
		Scanner teclado = new Scanner(System.in);
		String texto = "";
		BufferedReader in = new BufferedReader(new FileReader(RUTA_ARCHIVO));
		while (in.readLine() != null) {
			for(int i = 0 ; i < 24; i++ ) {
				texto = in.readLine();
				if(texto!=null) {
					System.out.println(texto);
				}
			}
			teclado.nextLine();	
		}
		System.out.println("Final del documento");
		teclado.close();
	}

	public static void main(String[] args) {
		try {
			mostrar24();
		} 
		catch (IOException ex) {
			System.out.println(ex);
		}
	}

}
