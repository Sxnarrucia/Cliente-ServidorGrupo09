package tiendacliente.servidor;

import controlador.EncriptarPasswords;
import controlador.UsuarioController;
import modelo.ConexionBD;
import vista.LoginForm;

public class TiendaClienteServidor {
    public static void main(String[] args) {
        // Assuming you have a password for your MySQL database
        String url = "jdbc:mysql://127.0.0.1:3306/tienda?useSSL=false";
        String username = "root";
        String password = "admin"; // Replace with your actual database password

        // Create an instance of ConexionBD with the correct parameters
        ConexionBD conexionBD = new ConexionBD(url, username, password);

        // Rest of your code...

        LoginForm login = new LoginForm(conexionBD);
        login.setVisible(true);
    }
}
