package DAO;

import Model.Venta;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO {

    public List<Venta> obtenerVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT v.id_venta, v.codigo_factura, v.numero_venta, v.PrecioTotal, v.fecha, "
                + "p.nombre AS nombre_producto, p.precio, v.cantidad, v.metodo_pago "
                + "FROM Ventas v JOIN productos p ON v.id_producto = p.id";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.setCodigoFactura(rs.getString("codigo_factura"));
                venta.setNumeroVenta(rs.getInt("numero_venta"));
                venta.setFecha(rs.getDate("fecha").toLocalDate());
                venta.setNombreProducto(rs.getString("nombre_producto"));
                venta.setPrecio(rs.getBigDecimal("precio"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setMetodoPago(rs.getString("metodo_pago"));
                venta.setPrecioTotal(rs.getDouble("PrecioTotal"));

                ventas.add(venta);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return ventas;
    }
}