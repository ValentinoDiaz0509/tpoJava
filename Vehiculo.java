package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String patente;
    private String marca;
    private String tipo;

    public Vehiculo(String marca, String patente, String tipo) {
        this.marca = marca;
        this.patente = patente;
        this.tipo = tipo;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return patente + "," + marca + "," + tipo;
    }

    public static void guardarVehiculos(List<Vehiculo> vehiculos, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Vehiculo v : vehiculos) {
                writer.write(v.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehiculo> cargarVehiculos(String archivo) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    vehiculos.add(new Vehiculo(partes[1], partes[0], partes[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}
