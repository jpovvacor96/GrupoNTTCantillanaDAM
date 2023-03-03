package varios2;

import java.io.*;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Binario2 {
	
	public static final String RUTA_ARCHIVO="/media/jose/Archivos/DAM/Programación"
			+ "/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosBinarios/ficheros/texto.bin";

	public static void main(String[] args) {
        try {
            // Abrir archivo binario para escritura
            FileOutputStream fileOutputStream = new FileOutputStream(RUTA_ARCHIVO);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            
            // Escribir texto línea por línea en el archivo
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            do {
                linea = reader.readLine();
                if (!linea.isEmpty()) {
                    dataOutputStream.writeUTF(linea);
                }
            } while (!linea.isEmpty());
            
            // Cerrar archivo de salida
            dataOutputStream.close();
            fileOutputStream.close();
            
            // Leer archivo binario y mostrar contenido por pantalla
            FileInputStream fileInputStream = new FileInputStream(RUTA_ARCHIVO);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            while (dataInputStream.available() > 0) {
                String lineaLeida = dataInputStream.readUTF();
                System.out.println(lineaLeida);
            }
            
            // Cerrar archivo de entrada
            dataInputStream.close();
            fileInputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
