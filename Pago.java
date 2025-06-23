package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;

    private String metodo;
    private double monto;

    public Pago(String metodo, double monto) {
        this.metodo = metodo;
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return metodo + "," + monto;
    }

    public static void guardarPagos(List<Pago> pagos, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Pago p : pagos) {
                writer.write(p.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pago> cargarPagos(String archivo) {
        List<Pago> pagos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    pagos.add(new Pago(partes[0], Double.parseDouble(partes[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pagos;
    }
}
