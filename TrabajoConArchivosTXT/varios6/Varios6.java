package varios6;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


public class Varios6 {
	
	public static void mostrar24() throws IOException{
		Scanner teclado = new Scanner(System.in);
		String texto = "";
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\antoniocaro\\Downloads\\texto.txt"));
		while (in.readLine() != null) {
			for(int i = 0 ; i < 24; i++ ) {
				texto = in.readLine();
				System.out.println(texto);
			}
			teclado.nextLine();	
		}
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
