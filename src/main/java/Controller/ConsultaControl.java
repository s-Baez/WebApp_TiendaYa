package Controller;
import DAO.Conexion;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
@WebServlet("/ConsultaControl")
public class ConsultaControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Conexion conexion = new Conexion();
        try {
            int totalVentas = conexion.consultaTotalVentas();
            double sumaPrecioTotalVentas = conexion.consultaSumaPrecioTotalVentas();
            int cantidadIngresos = conexion.consultaCantidadIngresos();
            int cantidadUsuarios = conexion.consultaCantidadUsuarios();
            JSONObject result = new JSONObject();
            result.put("totalVentas", totalVentas);
            result.put("sumaPrecioTotalVentas", sumaPrecioTotalVentas);
            result.put("cantidadIngresos", cantidadIngresos);
            result.put("cantidadUsuarios", cantidadUsuarios);

            response.getWriter().write(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}