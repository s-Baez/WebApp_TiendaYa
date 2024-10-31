package Controller;

import DAO.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/ingreso")
public class IngresoControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        if (isValidUser(correo, password)) {
            response.sendRedirect("productoslista.jsp");
        } else {
            request.setAttribute("errorMessage", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private boolean isValidUser(String correo, String password) {
        boolean isValid = false;

        // Establecer la conexión a la base de datos
        try (Connection connection = Conexion.conectar()) {
            String sql = "SELECT password FROM usuario WHERE correo = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, correo);
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Verificar si se encontró el usuario
                    if (resultSet.next()) {
                        String hashedPassword = resultSet.getString("password");
                        System.out.println("Hash de la contraseña almacenada: " + hashedPassword);

                        // Validar la contraseña usando BCrypt
                        isValid = BCrypt.checkpw(password, hashedPassword);
                        if (isValid) {
                            System.out.println("Contraseña válida para: " + correo);
                        } else {
                            System.out.println("Contraseña inválida para: " + correo);
                        }
                    } else {
                        System.out.println("No se encontró el usuario: " + correo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
}