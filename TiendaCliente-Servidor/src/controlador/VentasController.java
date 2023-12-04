package controlador;

import modelo.ActualizacionInventario;
import modelo.ConexionBD;
import vista.VentasForm;

public class VentasController {
    public static void main(String[] args) {
        realizarVenta();
    }
    
    public static void realizarVenta() {
        VentasForm ventasForm = new VentasForm();
        ventasForm.show();
        
        int idProducto = ventasForm.getIdProducto();
        int cantidadVendida = ventasForm.getCantidadVendida();
        
        ConexionBD conexionBD = new ConexionBD("root", "admin");
        if (conexionBD.setConexion()) {
            ActualizacionInventario actualizacionInventario = new ActualizacionInventario(conexionBD);
            actualizacionInventario.actualizarInventario(idProducto, cantidadVendida);
        }
    }
}
