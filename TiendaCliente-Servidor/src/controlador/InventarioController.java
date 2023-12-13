package controlador;

import modelo.InventarioModel;
import vista.InventarioVista;

import java.util.List;

public class InventarioController {

    private InventarioModel inventarioModel;
    private InventarioVista inventarioVista;  

    public InventarioController(InventarioModel inventarioModel) {
        this.inventarioModel = inventarioModel;
    }

    public void setInventarioVista(InventarioVista inventarioVista) {
        this.inventarioVista = inventarioVista;
    }

    public void agregarProducto(String nombreProducto, int cantidad, double precioUnitario) {
        inventarioModel.agregarProducto(nombreProducto, cantidad, precioUnitario);
        inventarioModel.guardarProducto(nombreProducto, cantidad, precioUnitario);
    }

    public List<InventarioModel.Producto> obtenerProductos() {
        try {
            return inventarioModel.obtenerProductos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarSeccionInventario() {
        
        System.out.println("Mostrando sección de inventario desde InventarioController");
        inventarioVista.mostrar();
    }

    public void agregarListener(InventarioVista inventarioVista) {
        this.inventarioVista = inventarioVista;
    }
}
