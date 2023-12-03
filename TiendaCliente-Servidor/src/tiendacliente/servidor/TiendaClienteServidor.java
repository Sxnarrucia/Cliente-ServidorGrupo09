
package tiendacliente.servidor;

import controlador.EncriptarPasswords;
import vista.LoginForm;
import modelo.ActualizacionInventario;
import modelo.ConexionBD;



public class TiendaClienteServidor {


    public static void main(String[] args) {
        
        EncriptarPasswords encriptador = new EncriptarPasswords();
        LoginForm login = new LoginForm();
        login.show();
        //UsuarioController controlador = new UsuarioController();
        //System.out.println(controlador.getUsuario("Test1"));;

        int idProductoVendido = 1;
        int cantidadVendida = 5;
        
        ConexionBD conexionBD = new ConexionBD("username", "password");
        if (conexionBD.setConexion()) {
            ActualizacionInventario actualizacionInventario = new ActualizacionInventario(conexionBD);
            actualizacionInventario.actualizarInventario(idProductoVendido, cantidadVendida);
        }
    }
}
