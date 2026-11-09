<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Menú Principal - Gestión de Nóminas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #fcfcfc;
            color: #222;
        }
        h1 {
            color: #333;
            border-bottom: 2px solid #007bff;
            padding-bottom: 8px;
            display: inline-block;
        }
        p {
            color: #555;
            margin-bottom: 20px;
        }
        ul {
            list-style-type: none;
            padding: 0;
            margin-top: 15px;
            max-width: 550px;
        }
        li {
            margin-bottom: 10px;
        }
        a {
            display: block;
            background-color: #f8f9fa;
            color: #007bff;
            padding: 10px 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.2s, color 0.2s;
        }
        a:hover {
            background-color: #007bff;
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>Gestión de Empleados y Nóminas</h1>
    <p>Selecciona una opción del sistema:</p>
    
    <ul>
        <!-- Actualizado para apuntar al FrontController -->
        <li><a href="FrontController?accion=listar">Mostrar todos los empleados / Crear / Modificar</a></li>
        <li><a href="FrontController?accion=buscarSalarioForm">Mostrar el salario de un empleado por DNI</a></li>
        <li><a href="FrontController?accion=busquedaAvanzada">Buscar / Modificar empleados avanzada</a></li>     
    </ul>
</body>
</html>