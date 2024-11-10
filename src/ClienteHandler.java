import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteHandler implements Runnable{
    private Socket socket;

    public ClienteHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            String numeroIdentificacion = entrada.readLine();
            String tipoVehiculo = entrada.readLine();
            String cantidadGasolina = entrada.readLine();
            String fechaHora = entrada.readLine();

            System.out.println("Datos recibidos: ");
            System.out.println("ID Cliente: " + numeroIdentificacion);
            System.out.println("Tipo de Vehículo: " + tipoVehiculo);
            System.out.println("Cantidad de Gasolina: " + cantidadGasolina + " galones");
            System.out.println("Fecha y Hora: " + fechaHora);

            salida.println("Registro exitoso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
