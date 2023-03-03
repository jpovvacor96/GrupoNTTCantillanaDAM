package varios7;

import java.io.*;
import java.util.*;

/**
 * Este programa lee dos ficheros con nombres de personas y crea un tercer fichero donde aparecen ordenados
 * alfabéticamente los nombres de dichos archivos
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios7 {
	
	public static final String RUTA_ARCHIVO_1="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/perso1.txt";
	
	public static final String RUTA_ARCHIVO_2="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/perso2.txt";
	
	public static final String RUTA_ARCHIVO_3="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/todos.txt";
	
	
    public static void main(String[] args) throws IOException {
        // Leer el contenido de los dos archivos en dos ArrayLists diferentes
        List<String> perso1 = readFileToList(RUTA_ARCHIVO_1);
        List<String> perso2 = readFileToList(RUTA_ARCHIVO_2);

        // Unir los dos ArrayLists en uno solo
        List<String> todos = new ArrayList<>();
        todos.addAll(perso1);
        todos.addAll(perso2);

        // Ordenar el ArrayList resultante alfabéticamente
        Collections.sort(todos);

        // Escribir los nombres ordenados en el archivo todos.txt
        writeListToFile(RUTA_ARCHIVO_3, todos);
    }

    // Método para leer el contenido de un archivo en un ArrayList de Strings
    public static List<String> readFileToList(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        reader.close();
        return list;
    }

    // Método para escribir el contenido de un ArrayList de Strings en un archivo
    public static void writeListToFile(String fileName, List<String> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String line : list) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}