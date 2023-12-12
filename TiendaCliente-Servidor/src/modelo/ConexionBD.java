package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
    //Datos de gestion de BD

    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    private final String username;
    private final String password;

    public ConexionBD(String username, String password) {
        conexion = null;
        consulta = null;
        resultado = null;
        this.username = username;
        this.password = password;
    }

    public boolean setConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tienda?useSSL=false", username, password);
            return conexion != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void setConsulta(String sql) {
        try {
            this.consulta = conexion.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getConsulta() {
        return consulta;
    }

    public ResultSet getResultado() {
        try {
            return consulta.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cerrarConexion() {

        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    
    public Connection obtenerConexion() {
        return conexion;
    }
}
