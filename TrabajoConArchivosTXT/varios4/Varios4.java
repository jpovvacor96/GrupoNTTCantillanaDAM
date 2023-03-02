package varios4;

import java.io.File;
import java.util.Scanner;

/**
 * Procesa un fichero de texto que contiene números y muestra cuál es el mayor y cuál es el menor
 * de todos ellos
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class Varios4 {
	public static void main(String[] args) {
        String filename = "C:\\Users\\adrii\\eclipse-workspace\\varios\\numeros.txt";
        File numeros = new File(filename);
        double mayor;
        double menor;
        try(Scanner scanner = new Scanner(numeros)){
        	mayor = scanner.nextDouble();
        	menor=mayor;
        	while(scanner.hasNext()) {
        		double num=scanner.nextDouble();
        		if(num>mayor) mayor=num;
        		if(num<menor) menor=num;
        	}
        	System.out.println("El mayor es "+mayor);
        	System.out.println("El menor es "+menor);
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }
	}

}