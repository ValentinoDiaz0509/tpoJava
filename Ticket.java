package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private String fechaIngreso;
    private String horaIngreso;
    private String fechaSalida;
    private String horaSalida;

    public Ticket(int numero, String fechaIngreso, String horaIngreso) {
        this.numero = numero;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.fechaSalida = "";
        this.horaSalida = "";
    }

    public int getNumero() {
        return numero;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return numero + "," + fechaIngreso + "," + horaIngreso + "," + fechaSalida + "," + horaSalida;
    }

    public static void guardarTickets(List<Ticket> tickets, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Ticket t : tickets) {
                writer.write(t.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Ticket> cargarTickets(String archivo) {
        List<Ticket> tickets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    Ticket t = new Ticket(Integer.parseInt(partes[0]), partes[1], partes[2]);
                    t.setFechaSalida(partes[3]);
                    t.setHoraSalida(partes[4]);
                    tickets.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
