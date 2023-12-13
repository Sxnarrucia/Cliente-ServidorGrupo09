package vista;

import controlador.InventarioController;
import modelo.InventarioModel.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventarioVista implements Vista {

    private InventarioController inventarioController;
    private JFrame frame;
    private JTextField nombreProductoField;
    private JTextField cantidadField;
    private JTextField precioUnitarioField;
    private DefaultTableModel tableModel;
    private JLabel statusLabel;

    public InventarioVista() {
        initialize();
    }

    private void initialize() {
        System.out.println("Initializing InventarioVista...");
        frame = new JFrame("Inventario");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel lblNombreProducto = new JLabel("Nombre del Producto:");
        panel.add(lblNombreProducto);
        nombreProductoField = new JTextField();
        panel.add(nombreProductoField);

        JLabel lblCantidad = new JLabel("Cantidad:");
        panel.add(lblCantidad);
        cantidadField = new JTextField();
        panel.add(cantidadField);

        JLabel lblPrecioUnitario = new JLabel("Precio Unitario:");
        panel.add(lblPrecioUnitario);
        precioUnitarioField = new JTextField();
        panel.add(precioUnitarioField);

        JButton btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.addActionListener(e -> agregarProducto());
        panel.add(btnAgregarProducto);

        JButton btnMostrarProductos = new JButton("Mostrar Productos");
        btnMostrarProductos.addActionListener(e -> mostrarProductos());
        panel.add(btnMostrarProductos);

        statusLabel = new JLabel("");
        panel.add(statusLabel);

        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);
    }

    public void setInventarioController(InventarioController inventarioController) {
        this.inventarioController = inventarioController;
    }

    public void mostrar() {
        SwingUtilities.invokeLater(() -> {
            try {
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void agregarProducto() {
        String nombreProducto = nombreProductoField.getText();
        String cantidadInput = cantidadField.getText();
        String precioUnitarioInput = precioUnitarioField.getText();

        if (nombreProducto.isEmpty() || cantidadInput.isEmpty() || precioUnitarioInput.isEmpty()) {
            mostrarError("Todos los campos deben estar llenos");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadInput);
            double precioUnitario = Double.parseDouble(precioUnitarioInput);

            inventarioController.agregarProducto(nombreProducto, cantidad, precioUnitario);
            mostrarMensaje("Producto añadido correctamente");
        } catch (NumberFormatException e) {
            mostrarError("La cantidad y el precio deben ser números válidos");
        }
    }

    private void mostrarProductos() {
        SwingUtilities.invokeLater(() -> {
            try {
                List<modelo.InventarioModel.Producto> productos = inventarioController.obtenerProductos();

                if (productos.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No hay productos para mostrar.", "Productos", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder mensaje = new StringBuilder("Lista de Productos:\n");

                    for (Producto producto : productos) {
                        mensaje.append("Nombre: ").append(producto.getNombre())
                                .append(", Cantidad: ").append(producto.getCantidad())
                                .append(", Precio Unitario: ").append(producto.getPrecioUnitario())
                                .append("\n");
                    }

                    JOptionPane.showMessageDialog(frame, mensaje.toString(), "Productos", JOptionPane.INFORMATION_MESSAGE);
                }

                System.out.println("Productos mostrados correctamente.");
            } catch (Exception e) {
                e.printStackTrace();
                mostrarError("Error al mostrar productos");
            }
        });
    }

    private void mostrarError(String mensaje) {
        statusLabel.setForeground(Color.RED);
        statusLabel.setText(mensaje);
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensaje(String mensaje) {
        statusLabel.setForeground(Color.GREEN);
        statusLabel.setText(mensaje);
    }

    @Override
    public void actualizarInventario() {
        mostrarProductos();
    }

    @Override
    public void mostrarSeccionInventario() {
        
    }
}
