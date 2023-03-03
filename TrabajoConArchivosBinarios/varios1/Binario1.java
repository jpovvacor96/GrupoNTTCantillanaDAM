package varios1;

import java.io.*;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Binario1 {
	
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos/DAM/Programación"
			+ "/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosBinarios/ficheros/datos.bin";
	
    public static void main(String[] args) {
        try {
            FileInputStream fichero = new FileInputStream(RUTA_ARCHIVO);
            DataInputStream lector = new DataInputStream(fichero);
            while (lector.available() > 0) {
                double d = lector.readDouble();
                System.out.println(d);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}