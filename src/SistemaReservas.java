import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Creación de una reserva
            System.out.println("Ingrese el nombre del cliente:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el número de personas:");
            int personas = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            System.out.println("Ingrese la fecha de la reserva (YYYY-MM-DD HH:MM):");
            String fecha = scanner.nextLine();

            Reserva reserva = Reserva.crearReserva(nombre, personas, fecha);
            System.out.println("Reserva creada exitosamente para " + reserva.obtenerNombreCliente());

            // Consultar información de la reserva
            System.out.println("Número de personas: " + reserva.obtenerNumeroPersonas());
            System.out.println("Fecha de la reserva: " + reserva.obtenerFecha());

            // Modificar la reserva
            System.out.println("Ingrese un nuevo número de personas:");
            int nuevoNum = scanner.nextInt();
            reserva.modificarNumeroPersonas(nuevoNum);
            System.out.println("Número de personas actualizado a: " + reserva.obtenerNumeroPersonas());

            // Cancelar la reserva
            System.out.println("¿Desea cancelar la reserva? (sí/no)");
            scanner.nextLine(); // Consumir nueva línea
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                reserva.cancelarReserva();
                System.out.println("Reserva cancelada.");
            }

            System.out.println("Estado de la reserva: " + (reserva.estaActiva() ? "Activa" : "Cancelada"));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
