package Controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ExportExcelServlet")
public class ExportExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear el libro de trabajo
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clientes");

        // Establecer los datos
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Name", "NIS", "Score"});
        data.add(new Object[]{"Pepe Ruvianes", "010101", "8"});
        data.add(new Object[]{"Juan Loco", "2576", "7"});
        data.add(new Object[]{"Julia Dos", "934856", "9"});

        // Escribir los datos en la hoja
        int rowNum = 0;
        for (Object[] objArr : data) {
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);
                if (rowNum == 1) { // Primera fila
                    CellStyle style = workbook.createCellStyle();
                    Font font = workbook.createFont();
                    font.setBold(true);
                    style.setFont(font);
                    cell.setCellStyle(style);
                }
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        // Configurar la respuesta HTTP
        response.setContentType("application/vnd.ms-excel");
        String filename = "clientes.xls";
        response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(filename, "UTF-8") + "\"");

        // Escribir el archivo en la respuesta
        try (OutputStream out = response.getOutputStream()) {
            workbook.write(out);
            out.flush();
        } finally {
            workbook.close();
        }
    }
}