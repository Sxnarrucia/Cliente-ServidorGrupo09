package tiendacliente.servidor;

import controlador.EncriptarPasswords;
import vista.LoginForm;
import modelo.ActualizacionInventario;
import modelo.Cliente;
import modelo.ConexionBD;
import modelo.Servidor;

public class TiendaClienteServidor {

    public static void main(String[] args) {

        EncriptarPasswords encriptador = new EncriptarPasswords();
        LoginForm login = new LoginForm();
        login.show();
        //UsuarioController controlador = new UsuarioController();
        //System.out.println(controlador.getUsuario("Test1"));;

        Cliente miCliente = new Cliente();
        Servidor miServer = new Servidor();
        Thread miHiloCliente = new Thread(miCliente);
        Thread miHiloServidor = new Thread(miServer);
        miHiloServidor.start();
        miHiloCliente.start();
        int idProductoVendido = 1;
        int cantidadVendida = 5;

        ConexionBD conexionBD = new ConexionBD("root", "admin");
        if (conexionBD.setConexion()) {
            ActualizacionInventario actualizacionInventario = new ActualizacionInventario(conexionBD);
            actualizacionInventario.actualizarInventario(idProductoVendido, cantidadVendida);
        }
    }
}
