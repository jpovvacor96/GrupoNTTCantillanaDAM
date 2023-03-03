package varios11;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Varios11 {
	
	public static final String RUTA_ARCHIVO_1="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/texto1.txt";
	
	public static final String RUTA_ARCHIVO_2="/media/jose/Archivos"
			+ "/DAM/Programación/eclipse-workspace-1dam/GrupoNTTCantillanaDAM/GrupoNTTCantillanaDAM"
			+ "/TrabajoConArchivosTXT/ficheros/texto2.txt";
	
	public static void comp(String archivo1, String archivo2) {
		try {
			int menorLinea;
			BufferedReader in1=new BufferedReader(new FileReader(archivo1));
			BufferedReader in2=new BufferedReader(new FileReader(archivo2));
			String linea1=in1.readLine();
			String linea2=in2.readLine();
			int cuentaLinea1=0;
			int cuentaLinea2=0;
			int limiteArchivo=0;
			int errorLinea=1;
			int errorCaracter=1;
			boolean iguales=true;
			while (linea1!=null) {
				cuentaLinea1=cuentaLinea1+1;
				linea1=in1.readLine();
			}
			while(linea2!=null) {
				cuentaLinea2=cuentaLinea2+1;
				linea2=in2.readLine();
			}
			if (cuentaLinea1!=cuentaLinea2) {
				BufferedReader in3=new BufferedReader(new FileReader(archivo1));
				BufferedReader in4=new BufferedReader(new FileReader(archivo2));
				System.out.println("Los archivos son diferentes");
				if (cuentaLinea1>cuentaLinea2) {
					System.out.println("El primer archivo tiene más líneas de texto");
					limiteArchivo=cuentaLinea2;
				}
				else {
					System.out.println("El segundo archivo tiene más líneas de texto");
					limiteArchivo=cuentaLinea1;
				}
				linea1=in3.readLine();
				linea2=in4.readLine();
				for (int j=0;j<limiteArchivo;j++) {
					if (!linea1.equals(linea2)) {
						if(linea1.length()<linea2.length()) {
							menorLinea=linea1.length();
						}
						else {
							menorLinea=linea2.length();
						}
						for (int i=0;i<=menorLinea-1 && iguales;i++) {
							if (linea1.charAt(i)!=linea2.charAt(i)) {
								errorCaracter=i;
								iguales=false;
							}
						}
					}
					else {
						errorLinea=errorLinea+1;
						linea1=in3.readLine();
						linea2=in4.readLine();
					}
				}
				if (iguales) {
					System.out.println("Diferencia localizada al final del documento");
					System.out.println("Inicio de la línea "+(limiteArchivo+1)+" del archivo más grande");
				}
				else {
					System.out.println("Diferencia detectada:");
					System.out.println("Línea: "+errorLinea);
					System.out.println("Posición del carácter: "+errorCaracter);
				}
			}
			else {
				BufferedReader in3=new BufferedReader(new FileReader(archivo1));
				BufferedReader in4=new BufferedReader(new FileReader(archivo2));
				linea1=in3.readLine();
				linea2=in4.readLine();
				for (int j=0;j<cuentaLinea1;j++) {
					if (!linea1.equals(linea2)) {
						if(linea1.length()<linea2.length()) {
							menorLinea=linea1.length();
						}
						else {
							menorLinea=linea2.length();
						}
						for (int i=0;i<=menorLinea-1 && iguales;i++) {
							if (linea1.charAt(i)!=linea2.charAt(i)) {
								errorCaracter=i;
								iguales=false;
							}
						}
					}
					else {
						errorLinea=errorLinea+1;
						linea1=in3.readLine();
						linea2=in4.readLine();
					}
				}
				if (iguales) {
					System.out.println("Ambos documentos son iguales");
				}
				else {
					System.out.println("Diferencia detectada:");
					System.out.println("Línea: "+errorLinea);
					System.out.println("Posición del carácter: "+errorCaracter);
				}
			}
			
		}
		catch(IOException e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		Varios11.comp(RUTA_ARCHIVO_1, RUTA_ARCHIVO_2);
	}

}
