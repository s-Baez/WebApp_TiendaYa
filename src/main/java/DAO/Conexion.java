package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/caferepublica?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC para MySQL.", e);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con la base de datos. Verifica la URL, el usuario y la contraseña.", e);
        }
    }
    public static boolean probarConexion() {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASS)) {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return false;
        }
    }
}

