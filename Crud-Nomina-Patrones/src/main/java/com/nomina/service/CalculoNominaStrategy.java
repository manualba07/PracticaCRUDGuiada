package com.nomina.service;

public interface CalculoNominaStrategy {
    double calcularSueldoNeto(double sueldoBase);
}

class NominaEstandarStrategy implements CalculoNominaStrategy {
    @Override
    public double calcularSueldoNeto(double sueldoBase) {
        return sueldoBase * 0.85; // 15% de retención
    }
}

class NominaDirectivoStrategy implements CalculoNominaStrategy {
    @Override
    public double calcularSueldoNeto(double sueldoBase) {
        return (sueldoBase + 500) * 0.80; // Plus y 20% retención
    }
}