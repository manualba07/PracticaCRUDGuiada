package com.nomina.model;

import com.nomina.excepciones.DatosNoCorrectosException;

public class Empleado extends Persona {

    /*Atributos Empleados*/

    private int categoria;
    public int anyos_Trabajados;


    /**Constructor Empleado con nombre,dni y sexo*/

    public Empleado(String nombre, String dni, char sexo)throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
    }

    /**Constructor Empleado con nombre,dni, sexo, categoria y años trabajados*/
    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos_Trabajados) throws DatosNoCorrectosException{
        super(nombre, dni, sexo);
        if(categoria<0 || categoria>10){
            System.out.println("No valido");
        }else{
            this.categoria = categoria;
        }
        if(anyos_Trabajados<0){
            System.out.println("No valido");
        }else{
            this.anyos_Trabajados = anyos_Trabajados;
        }

    }

    /** Set de categoria*/

    public void setCategoria(int categoria)throws DatosNoCorrectosException {
        this.categoria = categoria;
    }

    /** Get de categoria*/
    public int getCategoria(){
        return categoria;
    }

    /** Get de año0sTrabajados*/
    public int getAñosTrabajados() {
        return anyos_Trabajados;
    }

    /** Set de año0sTrabajados*/
    public void setanyos_Trabajados(int anyos_Trabajados) {
        this.anyos_Trabajados = anyos_Trabajados;
    }

    /**Método para incrementar los años trabajados*/

    public void incrAnyo(){
        anyos_Trabajados++;;
    }

    /**Método imprime*/

    public void imprime(String dni, String nombre,char sexo,int categoria,int anyos_Trabajados){
        System.out.println(dni+" "+nombre+" "+sexo+" Años trabajados:"+anyos_Trabajados+" Categoria:"+categoria);

    }
}
