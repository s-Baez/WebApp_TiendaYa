<%--
  Created by IntelliJ IDEA.
  User: sadit
  Date: 30/10/2024
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>
<style>
    .form-rol {
        font-size: .8rem;
        border-radius: 10rem;
        height: 47px;
    }
</style>
<body class="bg-gradient-primary">
<div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">

            <div class="row">


                <hr>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form class="user" action="RegistroControl" method="post">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" id="nombre" class="form-control form-control-user" name="nombre" placeholder="Nombre" required>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" id="apellido" class="form-control form-control-user" name="apellido" placeholder="Apellido" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email">Correo Electrónico</label>
                                <input type="email" id="email" class="form-control form-control-user" name="email" placeholder="Correo Electrónico" required>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6">
                                    <label for="rol">Rol</label>
                                    <select class="form-control form-rol" id="rol" name="rol" required>
                                        <option value="" disabled selected>Selecciona un rol</option>
                                        <option value="Administrador">Administrador</option>
                                        <option value="Trabajador">Trabajador</option>
                                    </select>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label for="dni">DNI</label>
                                    <input type="text" id="dni" class="form-control form-control-user" name="dni" placeholder="DNI" required>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label for="password">Contraseña</label>
                                    <input type="password" id="password" class="form-control form-control-user" name="password" placeholder="Contraseña" required>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                Registrar Cuenta
                            </button>
                            <hr>
                            <a href="index.html" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Registrarse con Google
                            </a>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="index.jsp">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/sb-admin-2.min.js"></script>
</body>
</html>
