package modelos;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    List<Empleado> listaEmpleados = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void agregarEmpleado(Empleado e) {
        listaEmpleados.add(e);
    }

    public double calcularNominaTotal() {
        double total = 0;
        for (Empleado e : listaEmpleados) {
            total += e.calcularSalarioTotal();
        }
        return total;
    }
}
