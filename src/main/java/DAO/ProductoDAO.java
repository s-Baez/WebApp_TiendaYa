package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Producto;

public class ProductoDAO {

    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT id, nombre, tamano, precio, stock, categoria_id, imagen FROM productos WHERE precio REGEXP '^[0-9]+(\\.[0-9]+)?$'";

        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tamano = rs.getString("tamano");

                double precio = 0.0;
                try {
                    precio = rs.getDouble("precio");
                } catch (SQLException | NumberFormatException e) {
                    System.out.println("Error al convertir el precio para el ID " + id + ": " + e.getMessage());
                    precio = 0.0; // Asignar un valor por defecto si deseas
                }
                String stock = rs.getString("stock");

                int categoriaId = rs.getInt("categoria_id");
                String imagen = rs.getString("imagen");


                productos.add(new Producto(id, nombre, tamano, precio, stock, categoriaId, imagen));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}