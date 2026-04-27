package modelos;

public class Empleado {
    String nombre;
    double salarioBase;

    public Empleado() {
    }

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void mostrarSalario() {
        System.out.println("Empleado: " + nombre + " | Salario base: " + salarioBase);
    }

    public double calcularBono() {
        return salarioBase * 0.10;
    }

    public double calcularSalarioTotal() {
        return salarioBase + calcularBono();
    }

    public boolean aplicaDescuento() {
        return salarioBase > 400;
    }
}
