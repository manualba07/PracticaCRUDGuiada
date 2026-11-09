package com.nomina.dao;

import com.nomina.conexion.Conexion;
import com.nomina.excepciones.DatosNoCorrectosException;
import com.nomina.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {

    /* Método para insertar un nuevo empleado en la base de datos*/
    public boolean insertar(Empleado emp) {
        String sql = "INSERT INTO empleados (dni, nombre, categoria, anyos_Trabajados, sexo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getDni());
            pstmt.setString(2, emp.getNombre());
            pstmt.setInt(3, emp.getCategoria());
            pstmt.setInt(4, emp.getAñosTrabajados());
            pstmt.setString(5, String.valueOf(emp.getSexo()));
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener la lista de todos los empleados 
    public List<Empleado> obtenerTodos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                int categoria = rs.getInt("categoria");
                int anyos = rs.getInt("anyos_Trabajados"); 
                String sexoStr = rs.getString("sexo");
                char sexo = (sexoStr != null && !sexoStr.isEmpty()) ? sexoStr.charAt(0) : 'O';
                
                Empleado emp = new Empleado(nombre, dni, sexo, categoria, anyos);
                lista.add(emp);
            }
            System.out.println(" EMPLEADOS: " + lista.size());
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        return lista;
    }

    // Método para buscar un empleado concreto por su dni
    public Empleado obtenerPorDni(String dniBuscado) {
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        Empleado emp = null;
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, dniBuscado);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dni = rs.getString("dni");
                    String nombre = rs.getString("nombre");
                    int categoria = rs.getInt("categoria");
                    int anyos = rs.getInt("anyos_Trabajados"); 
                    String sexoStr = rs.getString("sexo");
                    char sexo = (sexoStr != null && !sexoStr.isEmpty()) ? sexoStr.charAt(0) : 'O';
                    
                    emp = new Empleado(nombre, dni, sexo, categoria, anyos);
                }
            }
        } catch (SQLException | DatosNoCorrectosException e) {
            System.out.println("Error al obtener empleado por dni: " + e.getMessage());
        }
        return emp;
    }

    // Método para actualizar los datos de un empleado existente
    public boolean actualizar(Empleado emp) {
        String sql = "UPDATE empleados SET nombre = ?, categoria = ?, anyos_Trabajados = ?, sexo = ? WHERE dni = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, emp.getNombre());
            pstmt.setInt(2, emp.getCategoria());
            pstmt.setInt(3, emp.getAñosTrabajados());
            pstmt.setString(4, String.valueOf(emp.getSexo()));
            pstmt.setString(5, emp.getDni());
            
            int filas = pstmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un empleado de la base de datos por su DNI
    public boolean eliminar(String dni) {
        String sql = "DELETE FROM empleados WHERE dni = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, dni);
            int filas = pstmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }
}