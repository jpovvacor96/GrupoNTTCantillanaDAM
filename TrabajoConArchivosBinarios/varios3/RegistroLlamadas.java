package varios3;

import java.time.LocalDate;

/**
 * @author Antonio Jesús Caro Gutiérrez
 * @author Adrián Díaz López
 * @author José Palomino Ochoa
 * @author Daniel Romero Reyes
 *
 */
public class RegistroLlamadas {
    private LocalDate fecha;
    private int llamadas;

    public RegistroLlamadas(LocalDate fecha, int llamadas) {
        this.fecha = fecha;
        this.llamadas = llamadas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getLlamadas() {
        return llamadas;
    }

    @Override
    public String toString() {
        return fecha.toString() + ": " + llamadas;
    }

}