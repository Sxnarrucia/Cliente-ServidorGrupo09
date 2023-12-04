package modelo;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import vista.VentasForm;
import java.sql.SQLException;
import modelo.ConexionBD;

public class ActualizacionInventario {

    private ConexionBD conexionBD;
    ConexionBD conexion = new ConexionBD("root", "admin");
    
    public ActualizacionInventario(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public void actualizarInventario(int idProducto, int cantidadVendida) {
        try {
            conexionBD.setConsulta("UPDATE inventario SET cantidad = cantidad - ? WHERE id_producto = ?");
            conexionBD.getConsulta().setInt(1, cantidadVendida);
            conexionBD.getConsulta().setInt(2, idProducto);
            conexionBD.getConsulta().executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBD.cerrarConexion();
        }
    }
}
