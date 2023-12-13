package vista;

import controlador.InventarioController;


public interface Vista {
    void setInventarioController(InventarioController inventarioController);

    void actualizarInventario();

    void mostrarSeccionInventario();
}
