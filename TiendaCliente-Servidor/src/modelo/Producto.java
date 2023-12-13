package modelo;

public class Producto {

    private String nombre;
    private int cantidadEnStock;
    private double precioUnitario;

    public Producto(String nombre, int cantidadEnStock, double precioUnitario) {
        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Método para realizar una venta del producto
    public void vender(int cantidad) {
        if (cantidad <= cantidadEnStock) {
            cantidadEnStock -= cantidad;
            System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("No hay suficientes unidades en stock para la venta");
        }
    }

    // Método para reponer el stock del producto
    public void reponerStock(int cantidad) {
        cantidadEnStock += cantidad;
        System.out.println("Stock repuesto: " + cantidad + " unidades de " + nombre);
    }

    @Override
    public String toString() {
        return "Producto{"
                + "nombre='" + nombre + '\''
                + ", cantidadEnStock=" + cantidadEnStock
                + ", precioUnitario=" + precioUnitario
                + '}';
    }

    public int getCantidad() {
        return cantidadEnStock;
    }
}
