package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioModel {

    private ConexionBD conexionBD;

    public static class Producto {

        private String nombre;
        private int cantidad;
        private double precioUnitario;

        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(double precioUnitario) {
            this.precioUnitario = precioUnitario;
        }
    }

    public InventarioModel(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public void guardarProducto(String nombreProducto, int cantidad, double precioUnitario) {
        
        String sql = "INSERT INTO productos (nombre, cantidad, precio_unitario) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexionBD.getConexion().prepareStatement(sql)) {
            statement.setString(1, nombreProducto);
            statement.setInt(2, cantidad);
            statement.setDouble(3, precioUnitario);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public void agregarProducto(String nombre, int cantidad, double precioUnitario) {
        
        try {
            conexionBD.setConexion();

            String query = "INSERT INTO inventarios (producto, cantidad, precio_unitario) VALUES (?, ?, ?)";
            conexionBD.setConsulta(query);

            PreparedStatement preparedStatement = conexionBD.getConsulta();
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, cantidad);
            preparedStatement.setDouble(3, precioUnitario);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }

        
        notificarActualizacion();
    }

    public List<Producto> obtenerProductos() {
        
        List<Producto> productos = new ArrayList<>();
        try {
            conexionBD.setConexion();

            String query = "SELECT * FROM inventarios";
            conexionBD.setConsulta(query);

            ResultSet resultSet = conexionBD.getResultado();
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setNombre(resultSet.getString("producto"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setPrecioUnitario(resultSet.getDouble("precio_unitario"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBD.cerrarConexion();
        }

        return productos;
    }

    public void notificarActualizacion() {
        
    }

    
}
