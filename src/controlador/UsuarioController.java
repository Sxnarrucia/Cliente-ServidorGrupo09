package controlador;

import modelo.ConexionBD;
import modelo.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController {

    private ConexionBD conexion;
    private ResultSet resultado = null;

    public UsuarioController(ConexionBD conexion) {
        this.conexion = conexion;
    }

    // Remove the default constructor or provide a meaningful implementation
    /*
    public UsuarioController() {
        // You can provide a meaningful implementation or remove this constructor
    }
    */

    public Boolean insertarUsuario(Usuario usuario) {
        try {
            conexion.setConexion();
            conexion.setConsulta("INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)");
            // Establecer los valores para la consulta utilizando PreparedStatement
            conexion.getConsulta().setString(1, usuario.getNombreUsuario());
            conexion.getConsulta().setString(2, usuario.getPassword());
            conexion.getConsulta().setString(3, usuario.getEmail());

            if (conexion.getConsulta().executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public Usuario getUsuario(String usuario) {
        Usuario miUsuario = new Usuario();
        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT username, password, email FROM usuarios WHERE username = ?");
            // Establecer el valor para la consulta utilizando PreparedStatement
            conexion.getConsulta().setString(1, usuario);

            resultado = conexion.getResultado();
            while (resultado.next()) {
                miUsuario = new Usuario();
                miUsuario.setNombreUsuario(resultado.getString("username"));
                miUsuario.setPassword(resultado.getString("password"));
                miUsuario.setEmail(resultado.getString("email"));
                return miUsuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }
        return miUsuario;
    }
}
