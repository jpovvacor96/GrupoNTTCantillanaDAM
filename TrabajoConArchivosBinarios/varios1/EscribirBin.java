package varios1;

import java.io.*;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class EscribirBin {
    public static void main(String[] args) {
        try {
            FileOutputStream fichero = new FileOutputStream("datos.bin");
            DataOutputStream escribir = new DataOutputStream(fichero);
            escribir.writeDouble(3.14159);
            escribir.writeDouble(2.71828);
            escribir.writeDouble(1.41421);
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}