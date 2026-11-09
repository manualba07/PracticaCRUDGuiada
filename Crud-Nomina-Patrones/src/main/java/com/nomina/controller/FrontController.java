package com.nomina.controller;

import com.nomina.service.EmpleadoService;
import com.nomina.model.Empleado;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController", "/EmpleadoController"})
public class FrontController extends HttpServlet {
    private EmpleadoService empleadoService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.empleadoService = new EmpleadoService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        
        if (accion == null || accion.isEmpty()) {
            accion = "listar";
        }

        try {
            switch (accion) {
                case "listar": {
                    List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
                    request.setAttribute("empleados", empleados);
                    request.getRequestDispatcher("/WEB-INF/views/listar.jsp").forward(request, response);
                    break;
                }
                case "nuevo": {
                    request.getRequestDispatcher("/WEB-INF/views/crear.jsp").forward(request, response);
                    break;
                }
                case "insertar": {
                    String dni = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    String sexoStr = request.getParameter("sexo");
                    char sexo = (sexoStr != null && !sexoStr.isEmpty()) ? sexoStr.charAt(0) : 'O';
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    int anyos = Integer.parseInt(request.getParameter("anyos_trabajados"));

                    Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
                    empleadoService.guardarEmpleado(emp);
                    response.sendRedirect("FrontController?accion=listar");
                    break;
                }
                case "editar": {
                    String dni = request.getParameter("dni");
                    Empleado emp = empleadoService.buscarEmpleadoPorDni(dni);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("/WEB-INF/views/editar.jsp").forward(request, response);
                    break;
                }
                case "actualizar": {
                    String dni = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    String sexoStr = request.getParameter("sexo");
                    char sexo = (sexoStr != null && !sexoStr.isEmpty()) ? sexoStr.charAt(0) : 'O';
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    int anyos = Integer.parseInt(request.getParameter("anyos_trabajados"));

                    Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
                    empleadoService.actualizarEmpleado(emp);
                    response.sendRedirect("FrontController?accion=listar");
                    break;
                }
                case "eliminar": {
                    String dni = request.getParameter("dni");
                    empleadoService.eliminarEmpleado(dni);
                    response.sendRedirect("FrontController?accion=listar");
                    break;
                }
                case "buscarSalarioForm": {
                    request.getRequestDispatcher("/WEB-INF/views/buscarSalario.jsp").forward(request, response);
                    break;
                }
                case "mostrarSalario": {
                    String dni = request.getParameter("dni");
                    Empleado emp = empleadoService.buscarEmpleadoPorDni(dni);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("/WEB-INF/views/verSalario.jsp").forward(request, response);
                    break;
                }
                case "busquedaAvanzada": {
                    request.getRequestDispatcher("/WEB-INF/views/buscarModificar.jsp").forward(request, response);
                    break;
                }
                case "resultadoBusqueda": {
                    String criterio = request.getParameter("criterio");
                    // Buscamos por DNI o listamos filtrando si coincide
                    Empleado emp = empleadoService.buscarEmpleadoPorDni(criterio);
                    List<Empleado> listaResultados = new java.util.ArrayList<>();
                    if (emp != null) {
                        listaResultados.add(emp);
                    } else {
                        // O si buscas por nombre aproximado
                        for (Empleado e : empleadoService.obtenerTodosLosEmpleados()) {
                            if (e.getNombre().toLowerCase().contains(criterio.toLowerCase())) {
                                listaResultados.add(e);
                            }
                        }
                    }
                    request.setAttribute("empleadosEncontrados", listaResultados);
                    request.getRequestDispatcher("/WEB-INF/views/resultadoBusqueda.jsp").forward(request, response);
                    break;
                }
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no soportada: " + accion);
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/resultadoBusqueda.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}