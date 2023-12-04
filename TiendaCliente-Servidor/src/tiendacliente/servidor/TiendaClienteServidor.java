package tiendacliente.servidor;

import vista.LoginForm;
import modelo.Cliente;
import modelo.Servidor;
import vista.VentasForm;

public class TiendaClienteServidor {

    public static void main(String[] args) {
        //LoginForm login = new LoginForm();
        //login.show();
        VentasForm venta = new VentasForm();
        venta.show();
        Cliente miCliente = new Cliente();
        Servidor miServer = new Servidor();
        Thread miHiloCliente = new Thread(miCliente);
        Thread miHiloServidor = new Thread(miServer);
        miHiloServidor.start();
        miHiloCliente.start();
    }
}
