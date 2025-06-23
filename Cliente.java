package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String telefono;
    private Vehiculo vehiculo;

    public Cliente(String nombre, String telefono, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return nombre + "," + telefono + "," + vehiculo.toString();
    }

    public static void guardarClientes(List<Cliente> clientes, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Cliente c : clientes) {
                writer.write(c.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> cargarClientes(String archivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    Vehiculo v = new Vehiculo(partes[3], partes[0], partes[4]);
                    Cliente c = new Cliente(partes[0], partes[1], v);
                    clientes.add(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
