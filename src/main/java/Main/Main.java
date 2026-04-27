package Main;
import modelos.Empleado;
import modelos.Empresa;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Empresa miEmpresa = new Empresa();
        int opcion = 0;

        do {
            try {
                String menu = "--- MENÚ GESTIÓN EMPRESA ---\n" +
                        "1. Registrar Empleado\n" +
                        "2. Ver Lista de Empleados\n" +
                        "--------------------------\n" +
                        "3. Editar Salario Base\n" +
                        "4. Eliminar Empleado\n" +
                        "5. Ver Nómina Total (Reporte)\n" +
                        "6. Salir\n" +
                        "Seleccione una opción:";

                String input = JOptionPane.showInputDialog(null, menu);

                if (input == null) { opcion = 6; }
                else { opcion = Integer.parseInt(input); }

                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario base:"));
                        miEmpresa.agregarEmpleado(new Empleado(nombre, salario));
                        JOptionPane.showMessageDialog(null, "Empleado registrado.");
                        break;

                    case 2:
                        String lista = "--- EMPLEADOS ---\n";
                        for (int i = 0; i < miEmpresa.getListaEmpleados().size(); i++) {
                            Empleado e = miEmpresa.getListaEmpleados().get(i);
                            String desc = e.aplicaDescuento() ? "[Aplica Descuento]" : "[Sin Descuento]";
                            lista += i + ". " + e.getNombre() + " - $" + e.getSalarioBase() + " " + desc + "\n";
                        }
                        JOptionPane.showMessageDialog(null, lista);
                        break;

                    case 3:
                        int idMod = Integer.parseInt(JOptionPane.showInputDialog("Índice a modificar:"));
                        double nuevoSal = Double.parseDouble(JOptionPane.showInputDialog("Nuevo salario:"));
                        miEmpresa.getListaEmpleados().get(idMod).setSalarioBase(nuevoSal);
                        JOptionPane.showMessageDialog(null, "Actualizado.");
                        break;

                    case 4:
                        int idDel = Integer.parseInt(JOptionPane.showInputDialog("Índice a eliminar:"));
                        miEmpresa.getListaEmpleados().remove(idDel);
                        JOptionPane.showMessageDialog(null, "Eliminado.");
                        break;

                    case 5:
                        double total = miEmpresa.calcularNominaTotal();
                        JOptionPane.showMessageDialog(null, "Total Nómina: $" + total);
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Entrada no válida o índice inexistente.");
            }
        } while (opcion != 6);
    }
}