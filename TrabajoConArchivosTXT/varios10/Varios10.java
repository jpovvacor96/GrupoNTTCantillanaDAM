package varios10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lee un fichero de texto que contiene una matriz y muestra la matriz traspuesta por pantalla
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 */
public class Varios10 {

    public static void main(String[] args) {
    	
    	//Nueva matriz
        File miMatriz  = new File("/media/jose/Archivos/DAM/Programación"
        		+ "/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/"
        		+ "GrupoNTTCantillanaDAM/TrabajoConArchivosTXT/varios10/matriz.txt");

        Scanner scn;
        try {
            scn = new Scanner(miMatriz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int tam = scn.nextInt();
        int[][] matriz = new int[tam][tam];

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = scn.nextInt();
            }
        }

        scn.close();

        System.out.println("Matriz original:");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("La Matriz traspuesta quedaría tal que así:");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
    }

}
