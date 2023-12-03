package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ConexionBD;
import modelo.Persona;

public class PersonaController {

    ConexionBD conexion = new ConexionBD("root", "admin");
    ResultSet resultado = null;

    public Boolean insertarUsuario(Persona persona) {
        try {
            conexion.setConexion();
            conexion.setConsulta("insert into clientes (nombre, correo, telefono, cedula) "
                    + "values ('" + persona.getNombre() + "', "
                    + "'" + persona.getCorreo() + "', "
                    + "'" + persona.getTelefono() + "', "
                    + "'" + persona.getCedula() + "')");
            if (conexion.getConsulta().executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Persona getUsuario(String persona) {
        Persona miPersona = new Persona();
        try {
            conexion.setConexion();
            conexion.setConsulta("select nombre, correo, telefono, cedula from clientes where nombre = '" + persona + "' ");
            resultado = conexion.getResultado();
            while (resultado.next()) {
                miPersona = new Persona();
                miPersona.setNombre(resultado.getString("nombre"));
                miPersona.setCorreo(resultado.getString("correo"));
                miPersona.setTelefono(resultado.getString("telefono"));
                miPersona.setCedula(resultado.getInt("cedula"));
                return miPersona;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return miPersona;
    }
}
