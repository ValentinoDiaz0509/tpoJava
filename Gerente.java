package Clases;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gerente extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    public Gerente(int dni, String nombre) {
        super(dni, nombre);
    }

    public void generarInformeFinanciero(List<Pago> pagos) {
        System.out.println("========== INFORME FINANCIERO ==========");
        double total = 0;
        for (Pago pago : pagos) {
            System.out.println("Método: " + pago.getMetodo() + " - Monto: $" + pago.getMonto());
            total += pago.getMonto();
        }
        System.out.println("----------------------------------------");
        System.out.println("TOTAL INGRESADO: $" + total);
        System.out.println("========================================");
    }

    public void gestionarPersonal(List<Empleado> empleados) {
        System.out.println("========== GESTIÓN DE PERSONAL ==========");
        Collections.sort(empleados, Comparator.comparingInt(Empleado::getDni));

        for (Empleado e : empleados) {
            System.out.println("DNI: " + e.getDni() + " - Nombre: " + e.getNombre());
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total de empleados: " + empleados.size());
        System.out.println("=========================================");
    }
}
