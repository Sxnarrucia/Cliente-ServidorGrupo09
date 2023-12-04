package tiendacliente.servidor;

import vista.LoginForm;
import modelo.Cliente;
import modelo.Servidor;

public class TiendaClienteServidor {

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.show();
        Cliente miCliente = new Cliente();
        Servidor miServer = new Servidor();
        Thread miHiloCliente = new Thread(miCliente);
        Thread miHiloServidor = new Thread(miServer);
        miHiloServidor.start();
        miHiloCliente.start();
    }
}
