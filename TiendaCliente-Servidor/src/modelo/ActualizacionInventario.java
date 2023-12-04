package modelo;

import java.sql.SQLException;

public class ActualizacionInventario {
  
    private ConexionBD conexionBD;
  
    public ActualizacionInventario(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
  
    public void actualizarInventario(int idProducto, int cantidadVendida) {
        try {
            // Actualiza la cantidad en el inventario
            conexionBD.setConsulta("UPDATE inventario SET cantidadProducto = cantidadProducto - ? WHERE idProducto = ?");
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
