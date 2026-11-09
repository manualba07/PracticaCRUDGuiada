<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.nomina.model.Empleado" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Empleados</title>
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
    <h1>Gestión de Empleados</h1>
    <a href="EmpleadoController?accion=nuevo" class="nuevo">+ Nuevo Empleado</a>
    
    <table>
        <tr>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Años Trabajados</th>
            <th>Acciones</th>
        </tr>
        <% 
            List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
            if (empleados != null) {
                for (Empleado emp : empleados) {
        %>
        <tr>
            <td><%= emp.getDni() %></td>
            <td><%= emp.getNombre() %></td>
            <td><%= emp.getCategoria() %></td>
            <td><%= emp.getAñosTrabajados() %></td>
            <td>
                <a href="EmpleadoController?accion=editar&dni=<%= emp.getDni() %>">Editar</a>
                <a href="EmpleadoController?accion=eliminar&dni=<%= emp.getDni() %>" class="eliminar" onclick="return confirm('¿Seguro que deseas eliminar este empleado?')">Eliminar</a>
            </td>
        </tr>
        <% 
                }
            } 
        %>
    </table>
    <br>
    <a href="index.jsp" style="background:#6c757d;">Volver al Menú Principal</a>
</body>
</html>