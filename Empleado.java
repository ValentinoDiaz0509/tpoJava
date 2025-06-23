package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int dni;

    public Empleado(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return dni + "," + nombre;
    }

    public static void guardarEmpleados(List<Empleado> empleados, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Empleado e : empleados) {
                writer.write(e.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Empleado> cargarEmpleados(String archivo) {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    empleados.add(new Empleado(Integer.parseInt(partes[0]), partes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
