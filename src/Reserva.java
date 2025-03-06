import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private String nombreCliente;
    private int numPersonas;
    private String fecha;
    private boolean activa;

    /**
     * Crea una nueva reserva.
     * @param nombreCliente Nombre del cliente.
     * @param numPersonas Número de personas (debe ser mayor a 0).
     * @param fecha Fecha y hora de la reserva en formato "YYYY-MM-DD HH:MM".
     * @pre numPersonas > 0 && fecha no puede ser anterior a la fecha actual.
     * @post Se crea un objeto Reserva con los datos proporcionados y la reserva está activa.
     */
    public static Reserva crearReserva(String nombreCliente, int numPersonas, String fecha) {
        if (numPersonas <= 0) {
            throw new IllegalArgumentException("El número de personas debe ser mayor a 0.");
        }

        LocalDateTime fechaReserva = LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        if (fechaReserva.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de reserva no puede ser anterior a la actual.");
        }

        return new Reserva(nombreCliente, numPersonas, fecha);
    }

    private Reserva(String nombreCliente, int numPersonas, String fecha) {
        this.nombreCliente = nombreCliente;
        this.numPersonas = numPersonas;
        this.fecha = fecha;
        this.activa = true;
    }

    /**
     * Devuelve el nombre del cliente que hizo la reserva.
     * @return Nombre del cliente.
     * @pre La reserva debe existir.
     */
    public String obtenerNombreCliente() {
        return nombreCliente;
    }

    /**
     * Devuelve el número de personas de la reserva.
     * @return Número de personas.
     * @pre La reserva debe existir.
     */
    public int obtenerNumeroPersonas() {
        return numPersonas;
    }

    /**
     * Devuelve la fecha de la reserva.
     * @return Fecha de la reserva en formato "YYYY-MM-DD HH:MM".
     * @pre La reserva debe existir.
     */
    public String obtenerFecha() {
        return fecha;
    }

    /**
     * Modifica el número de personas en la reserva.
     * @param nuevoNumPersonas Nuevo número de personas (debe ser mayor a 0).
     * @pre nuevoNumPersonas > 0 && La reserva debe existir.
     * @post El número de personas en la reserva se actualiza.
     */
    public void modificarNumeroPersonas(int nuevoNumPersonas) {
        if (nuevoNumPersonas <= 0) {
            throw new IllegalArgumentException("El número de personas debe ser mayor a 0.");
        }
        this.numPersonas = nuevoNumPersonas;
    }

    /**
     * Cancela la reserva actual.
     * @pre La reserva debe existir.
     * @post La reserva queda cancelada y ya no puede ser utilizada.
     */
    public void cancelarReserva() {
        this.activa = false;
    }

    /**
     * Verifica si la reserva está activa.
     * @return true si la reserva no ha sido cancelada, false en caso contrario.
     */
    public boolean estaActiva() {
        return activa;
    }
}
