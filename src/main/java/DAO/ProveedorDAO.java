package DAO;

import Model.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public static List<Proveedor> obtenerProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT id_proveedor, nombre, contacto, telefono, email, direccion, distrito, ruc FROM proveedor";

        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id_proveedor = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String contacto = rs.getString("contacto");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                String distrito = rs.getString("distrito");
                String ruc = rs.getString("ruc");

                Proveedor proveedor = new Proveedor(id_proveedor, nombre, contacto, telefono, email, direccion, distrito, ruc);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la lista de proveedores: " + e.getMessage());
            e.printStackTrace();
        }

        return proveedores;
    }
}