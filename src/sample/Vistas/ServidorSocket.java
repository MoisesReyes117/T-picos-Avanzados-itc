package sample.Vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    private ServerSocket servidor;
    private Socket cliente;
    private int noClienteConectado = 0;

    public void iniciarServidor(){
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado...");
            while(true){
                cliente = servidor.accept();  // Establecemos el canal de comunicación
                noClienteConectado++;
                System.out.println("Llego el cliente numero "+noClienteConectado);

                //Mandar mensaje al cliente
                // Recuperamos  el flujo de salida desde el servidor hacia el cliente
                PrintStream salida = new PrintStream(cliente.getOutputStream());
                //Mandamos mensaje al cliente
                salida.println("Bienvenido, usted es mi cliente  numero: "+noClienteConectado);

                //Recuperar el flujo de entrada hacia el servidor
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                //Leemos desde el flujo el texto enviado  desde el cliente y lo imprima
                System.out.println(entrada.readLine());
                cliente.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
