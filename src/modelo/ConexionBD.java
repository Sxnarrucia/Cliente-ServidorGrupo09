package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private Connection conexion = null;
    private PreparedStatement consulta = null;
    private ResultSet resultado = null;
    private String username;
    private String password;

    public ConexionBD(String url, String username, String password) {
    this.username = username;
    this.password = password;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}

    public ConexionBD(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Connection getConexion() {
        return conexion;
    }

    public boolean setConexion() {
    try {
        conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tienda?useSSL=false", username, password);
        return conexion != null;
    } catch (Exception e) {
        e.printStackTrace();
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
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (consulta != null) {
                consulta.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
