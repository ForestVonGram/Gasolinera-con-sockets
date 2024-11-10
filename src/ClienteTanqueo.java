import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTanqueo {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el número de identificación del cliente:");
            String numeroIdentificacion = scanner.nextLine();

            System.out.println("Ingrese el tipo de vehículo (automovil, motocicleta, camioneta):");
            String tipoVehiculo = scanner.nextLine();

            System.out.println("Ingrese la cantidad de gasolina cargada (en galones):");
            String cantidadGasolina = scanner.nextLine();

            System.out.println("Ingrese la fecha y hora del tanqueo (formato: yyyy-MM-dd HH:mm):");
            String fechaHora = scanner.nextLine();

            salida.println(numeroIdentificacion);
            salida.println(tipoVehiculo);
            salida.println(cantidadGasolina);
            salida.println(fechaHora);

            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
