<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registrar Proveedor</title>
</head>
<body>
<h1>Registro de Proveedor</h1>
<form action="RegistrarProveedorControl" method="post">
  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required><br>

  <label for="contacto">Contacto:</label>
  <input type="text" id="contacto" name="contacto" required><br>

  <label for="telefono">Teléfono:</label>
  <input type="text" id="telefono" name="telefono" required><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br>

  <label for="direccion">Dirección:</label>
  <input type="text" id="direccion" name="direccion" required><br>

  <label for="distrito">Distrito:</label>
  <input type="text" id="distrito" name="distrito" required><br>

  <label for="ruc">RUC:</label>
  <input type="text" id="ruc" name="ruc" required><br>

  <input type="submit" value="Registrar Proveedor">
</form>

</body>
</html>