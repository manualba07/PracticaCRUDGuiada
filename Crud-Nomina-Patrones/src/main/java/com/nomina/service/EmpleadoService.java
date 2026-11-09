package com.nomina.service;

import com.nomina.dao.EmpleadoDAO;
import com.nomina.model.Empleado;
import com.nomina.excepciones.DatosNoCorrectosException;
import com.nomina.service.CalculoNominaStrategy;
import java.util.List;

public class EmpleadoService {
    private EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    // Llama al método real de tu DAO: obtenerTodos()
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoDAO.obtenerTodos();
    }

    // Llama al método real de tu DAO: obtenerPorDni()
    public Empleado buscarEmpleadoPorDni(String dni) throws DatosNoCorrectosException {
        if (dni == null || dni.trim().isEmpty()) {
            throw new DatosNoCorrectosException("El DNI proporcionado no es válido.");
        }
        return empleadoDAO.obtenerPorDni(dni);
    }

    // Llama al método real de tu DAO: insertar()
    public boolean guardarEmpleado(Empleado empleado) throws DatosNoCorrectosException {
        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            throw new DatosNoCorrectosException("El nombre del empleado es obligatorio.");
        }
        return empleadoDAO.insertar(empleado);
    }

    // Llama al método real de tu DAO: actualizar()
    public boolean actualizarEmpleado(Empleado empleado) {
        return empleadoDAO.actualizar(empleado);
    }

    // Llama al método real de tu DAO: eliminar()
    public boolean eliminarEmpleado(String dni) {
        return empleadoDAO.eliminar(dni);
    }

    // Integración del Patrón Strategy para calcular la nómina
    public double calcularNomina(double sueldoBase, CalculoNominaStrategy estrategia) {
        return estrategia.calcularSueldoNeto(sueldoBase);
    }
}