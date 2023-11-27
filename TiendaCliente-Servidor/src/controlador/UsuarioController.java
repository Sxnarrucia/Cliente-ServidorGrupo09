package controlador;

import modelo.ConexionBD;
import java.sql.SQLException;
import java.sql.ResultSet;
import modelo.Usuario;

public class UsuarioController {

    ConexionBD conexion = new ConexionBD("root", "Geaninna1");
    ResultSet resultado = null;

    public Boolean insertarUsuario(Usuario usuario) {
        try {
            conexion.setConexion();
            conexion.setConsulta("insert into usuarios (username, password, email) "
                    + "values ('" + usuario.getNombreUsuario() + "', "
                    + "'" + usuario.getPassword() + "', "
                    + "'" + usuario.getEmail() + "')");
            if (conexion.getConsulta().executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
    }

    public Usuario getUsuario(String usuario) {
        Usuario miUsuario = new Usuario();
        try {
            conexion.setConexion();
            conexion.setConsulta("select username, password, email from usuarios where username = '" + usuario + "' ");
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
        }
        return miUsuario;
    }
}
