package Controller;
import Model.Proveedor;
import DAO.ProveedorDAO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@WebServlet("/ExpProveedorControl")
public class ExpProveedorControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Proveedor> proveedores = ProveedorDAO.obtenerProveedores();
        try (Workbook workbook = new HSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Proveedores");
            createHeaderRow(sheet);
            int rowCount = 1;
            for (Proveedor proveedor : proveedores) {
                Row row = sheet.createRow(rowCount++);
                writeProveedorToRow(proveedor, row);
            }
            workbook.write(outputStream);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=proveedores.xls");
            response.setContentLength(outputStream.size());
            response.getOutputStream().write(outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        String[] columnHeaders = {"ID Proveedor", "Nombre", "Contacto", "Teléfono", "Email", "Dirección", "Distrito", "RUC"};

        for (int i = 0; i < columnHeaders.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnHeaders[i]);
        }
    }

    private void writeProveedorToRow(Proveedor proveedor, Row row) {
        row.createCell(0).setCellValue(proveedor.getIdProveedor());
        row.createCell(1).setCellValue(proveedor.getNombre());
        row.createCell(2).setCellValue(proveedor.getContacto());
        row.createCell(3).setCellValue(proveedor.getTelefono());
        row.createCell(4).setCellValue(proveedor.getEmail());
        row.createCell(5).setCellValue(proveedor.getDireccion());
        row.createCell(6).setCellValue(proveedor.getDistrito());
        row.createCell(7).setCellValue(proveedor.getRuc());
    }
}