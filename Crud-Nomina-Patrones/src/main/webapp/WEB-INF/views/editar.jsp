<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nomina.model.Empleado" %>
<%
    Empleado emp = (Empleado) request.getAttribute("empleado");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
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
    <h1>Editar Empleado</h1>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="EmpleadoController?accion=actualizar" method="POST">
        <label>DNI (Clave principal):</label><br>
        <input type="text" name="dni" value="<%= emp != null ? emp.getDni() : "" %>" readonly><br><br>
        
        <label>Nombre:</label><br>
        <input type="text" name="nombre" value="<%= emp != null ? emp.getNombre() : "" %>" required><br><br>

        <label>Sexo (H/M/O):</label><br>
        <input type="text" name="sexo" maxlength="1" value="<%= emp != null ? emp.getSexo() : "" %>" required><br><br>
        
        <label>Categoría:</label><br>
        <input type="number" name="categoria" value="<%= emp != null ? emp.getCategoria() : 0 %>" required><br><br>
        
        <label>Años Trabajados:</label><br>
        <input type="number" name="anyos_trabajados" value="<%= emp != null ? emp.getAñosTrabajados() : 0 %>" required><br><br>
        
        <button type="submit">Actualizar Cambios</button>
    </form>
    <br>
    <a href="EmpleadoController?accion=listar">Volver al listado</a>
</body>
</html>