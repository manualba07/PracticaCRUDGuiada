<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Búsqueda y Modificación de Empleados</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        margin: 30px;
        background-color: #fcfcfc;
        color: #222;
    }
    h1 {
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
        margin-bottom: 15px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px 12px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    input, button {
        padding: 6px 10px;
        margin-top: 5px;
        margin-bottom: 10px;
    }
    button, .btn {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
        border-radius: 3px;
    }
    button:hover {
        background-color: #0056b3;
    }
    a {
        color: #007bff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
   
    .volver, a[href*="index.jsp"] {
        display: inline-block;
        margin-top: 15px;
        padding: 6px 12px;
        background-color: #6c757d;
        color: white;
        border-radius: 3px;
        text-decoration: none;
    }
    .volver:hover, a[href*="index.jsp"]:hover {
        background-color: #5a6268;
        text-decoration: none;
    }
</style>
</head>
<body>
    <h1>Búsqueda y Modificación de Empleados</h1>
    <p>Introduce el DNI o el Nombre del empleado que deseas buscar:</p>
    
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="EmpleadoController" method="GET">
        <input type="hidden" name="accion" value="resultadoBusqueda">
        
        <label>Criterio de búsqueda (DNI o Nombre):</label><br>
        <input type="text" name="criterio" required><br><br>
        
        <button type="submit">Buscar Empleado</button>
    </form>
    
    <br>
    <a href="index.jsp">Volver al Menú Principal</a>
</body>
</html>