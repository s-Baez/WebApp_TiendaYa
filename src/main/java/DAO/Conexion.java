
package DAO;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/tiendaya?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public Conexion() {
    }

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaya?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException var1) {
            ClassNotFoundException e = var1;
            throw new SQLException("No se encontró el driver JDBC para MySQL.", e);
        } catch (SQLException var2) {
            SQLException e = var2;
            throw new SQLException("Error al conectar con la base de datos. Verifica la URL, el usuario y la contraseña.", e);
        }
    }

    public static boolean probarConexion() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaya?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC", "root", "");

            boolean var1;
            try {
                var1 = conexion != null && !conexion.isClosed();
            } catch (Throwable var4) {
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (Throwable var3) {
                        var4.addSuppressed(var3);
                    }
                }

                throw var4;
            }

            if (conexion != null) {
                conexion.close();
            }

            return var1;
        } catch (SQLException var5) {
            SQLException e = var5;
            System.out.println("Error al conectar: " + e.getMessage());
            return false;
        }
    }

    public int consultaTotalVentas() throws SQLException {
        String query = "SELECT COUNT(*) AS totalVentas FROM ventas";
        try (Connection con = conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("totalVentas");
            }
        }
        return 0;
    }

    public double consultaSumaPrecioTotalVentas() throws SQLException {
        String query = "SELECT SUM(precio_total) AS sumaPrecioTotalVentas FROM ventas";
        try (Connection con = conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getDouble("sumaPrecioTotalVentas");
            }
        }
        return 0.0;
    }

    public int consultaCantidadIngresos() throws SQLException {
        String query = "SELECT COUNT(*) AS cantidadIngresos FROM ingresos";
        try (Connection con = conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("cantidadIngresos");
            }
        }
        return 0;
    }

    public int consultaCantidadUsuarios() throws SQLException {
        String query = "SELECT COUNT(*) AS cantidadUsuarios FROM usuarios";
        try (Connection con = conectar(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("cantidadUsuarios");
            }
        }
        return 0;
    }
}
