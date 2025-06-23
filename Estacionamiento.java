package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estacionamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Cliente> listaClientes;
    private List<Ticket> listaTickets;

    public Estacionamiento() {
        listaClientes = new ArrayList<>();
        listaTickets = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        // Verificar si ya existe un cliente con la misma patente
        for (Cliente c : listaClientes) {
            if (c.getVehiculo().getPatente().equalsIgnoreCase(cliente.getVehiculo().getPatente())) {
                System.out.println("Error: Ya existe un cliente con la misma patente.");
                return;
            }
        }

        // Buscar una plaza libre
        int plazaAsignada = -1;
        for (int i = 1; i <= 100; i++) {
            if (PlazaDeAparcamiento.estaLibre(i)) {
                PlazaDeAparcamiento.ocuparPlaza(i);
                plazaAsignada = i;
                break;
            }
        }

        if (plazaAsignada == -1) {
            System.out.println("Error: No hay plazas disponibles.");
            return;
        }

        listaClientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre() + " en plaza " + plazaAsignada);

        // Crear ticket automático con fecha y hora simulada
        String fecha = "2025-06-22";
        String hora = "10:00";
        Ticket ticket = new Ticket(plazaAsignada, fecha, hora);
        agregarTicket(ticket);
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.add(ticket);
        System.out.println("Ticket generado para plaza " + ticket.getNumero() +
                           " a las " + ticket.getHoraIngreso());
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void guardarDatos(String archivoClientes, String archivoTickets) {
        Cliente.guardarClientes(listaClientes, archivoClientes);
        Ticket.guardarTickets(listaTickets, archivoTickets);
    }

    public void cargarDatos(String archivoClientes, String archivoTickets) {
        listaClientes = Cliente.cargarClientes(archivoClientes);
        listaTickets = Ticket.cargarTickets(archivoTickets);
    }

    public void listarClientes() {
        System.out.println("Listado de clientes:");
        for (Cliente c : listaClientes) {
            System.out.println(c.toString());
        }
    }

    public void listarTickets() {
        System.out.println("Listado de tickets:");
        for (Ticket t : listaTickets) {
            System.out.println(t.toString());
        }
    }
}
