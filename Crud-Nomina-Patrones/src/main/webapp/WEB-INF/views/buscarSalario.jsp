<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consultar Salario</title>
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
        .volver {
            display: inline-block;
            margin-top: 15px;
            padding: 6px 12px;
            background-color: #6c757d;
            color: white;
            border-radius: 3px;
            text-decoration: none;
        }
        .volver:hover {
            background-color: #5a6268;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>Consultar Salario por DNI</h1>
    <p>Introduce el DNI del empleado para calcular su nómina:</p>
    
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="EmpleadoController" method="GET">       
        <input type="hidden" name="accion" value="mostrarSalario">
        
        <label>DNI del empleado:</label><br>
        <input type="text" name="dni" required><br><br>
        
        <button type="submit">Consultar Salario</button>
    </form>
    
    <br>
    <a href="index.jsp" class="volver">Volver al Menú Principal</a>
</body>
</html>