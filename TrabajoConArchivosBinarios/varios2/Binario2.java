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
            /*crear un archivo binario para la escritura*/
            FileOutputStream archSalida = new FileOutputStream(RUTA_ARCHIVO);
            DataOutputStream datos = new DataOutputStream(archSalida);
            
            /*Escritura del archivo y lectura linea a linea*/
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            do {
                linea = lector.readLine();
                if (!linea.isEmpty()) {
                	datos.writeUTF(linea);
                }
            } while (!linea.isEmpty());
            
            /* cerrar archivo*/
            datos.close();
            archSalida.close();
            
            /* lectura del archivo .bin y muestra del mismo en pantalla*/
            FileInputStream archEntrada = new FileInputStream(RUTA_ARCHIVO);
            DataInputStream datos2 = new DataInputStream(archEntrada);
            while (datos2.available() > 0) {
                String lineaLeida = datos2.readUTF();
                System.out.println(lineaLeida);
            }
            
            /* cerrar el archvio de lectura*/
            archEntrada.close();
            datos2.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
