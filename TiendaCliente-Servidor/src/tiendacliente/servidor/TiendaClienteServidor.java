
package tiendacliente.servidor;

import controlador.EncriptarPasswords;
import controlador.UsuarioController;
import modelo.ConexionBD;
import modelo.Usuario;
import vista.LoginForm;
import vista.RegistroForm;


public class TiendaClienteServidor {


    public static void main(String[] args) {
        
        EncriptarPasswords encriptador = new EncriptarPasswords();
        LoginForm login = new LoginForm();
        login.show();
        //UsuarioController controlador = new UsuarioController();
        //System.out.println(controlador.getUsuario("Test1"));;
        
    }
    
}
