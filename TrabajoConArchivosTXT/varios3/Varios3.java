package varios3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lee un fichero de texto y cuenta los caracteres, las líneas y las palabras, mostrando el resultado
 * del conteo por pantalla
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios3 {
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/carta.txt";
	
    public static void main(String[] args) {
        int numChars = 0;
        int numWords = 0;
        int numLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String line;
            while ((line = br.readLine()) != null) {
                numChars += line.length();
                numWords += line.split(" ").length;
                numLines++;
            }
            System.out.println("Número de caracteres: " + numChars);
            System.out.println("Número de palabras: " + numWords);
            System.out.println("Número de líneas: " + numLines);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }

    }
}
