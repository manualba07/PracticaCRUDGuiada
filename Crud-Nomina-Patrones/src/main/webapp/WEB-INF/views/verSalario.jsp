<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.nomina.model.Empleado, com.nomina.model.Nomina" %>
<%
    Empleado emp = (Empleado) request.getAttribute("empleado");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Resultado del Salario</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 40px;
                background-color: #fcfcfc;
                color: #222;
            }
            h1 {
                color: #333;
            }
            .salario-box {
                background-color: #e9ecef;
                border-left: 5px solid #007bff;
                padding: 15px 20px;
                margin: 20px 0;
                font-size: 18px;
                width: fit-content;
                border-radius: 4px;
            }
            a {
                color: #007bff;
                text-decoration: none;
                display: inline-block;
                margin-top: 10px;
            }
            a:hover {
                text-decoration: underline;
            }
            .volver {
                background-color: #6c757d;
                color: white;
                padding: 6px 12px;
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
        <h1>Consulta de Salario</h1>

        <% if (emp != null) {
                Nomina nomina = new Nomina();
                int sueldoTotal = nomina.sueldo(emp);
        %>
        <p>Empleado: <strong><%= emp.getNombre()%></strong> (DNI: <%= emp.getDni()%>)</p>

        <div class="salario-box">
            Salario calculado: <strong><%= sueldoTotal%> €</strong>
        </div>
        <% } else { %>
        <p style="color:red;">No se ha encontrado ningún empleado con el dni proporcionado.</p>
        <% }%>

        <br>
        <a href="EmpleadoController?accion=buscarSalarioForm">Consultar otro DNI</a><br><br>
        <a href="index.jsp" class="volver">Volver al Menú Principal</a>
    </body>
</html>