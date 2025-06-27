package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class GarageUI extends JFrame {
    private Estacionamiento estacionamiento;
    private List<Pago> pagos = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();

    private JTextField nombreField, telefonoField, marcaField, patenteField, tipoField, montoField, metodoField;
    private JTextField salidaPlazaField;
    private JTextArea consola;

    public GarageUI() {
        estacionamiento = new Estacionamiento();

        setTitle("Garage Privado");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelInputs = new JPanel(new GridLayout(9, 2));

        nombreField = new JTextField();
        telefonoField = new JTextField();
        marcaField = new JTextField();
        patenteField = new JTextField();
        tipoField = new JTextField();
        montoField = new JTextField();
        metodoField = new JTextField();

        panelInputs.add(new JLabel("Nombre:")); panelInputs.add(nombreField);
        panelInputs.add(new JLabel("Teléfono:")); panelInputs.add(telefonoField);
        panelInputs.add(new JLabel("Marca:")); panelInputs.add(marcaField);
        panelInputs.add(new JLabel("Patente:")); panelInputs.add(patenteField);
        panelInputs.add(new JLabel("Tipo de Vehículo:")); panelInputs.add(tipoField);
        panelInputs.add(new JLabel("Monto a pagar:")); panelInputs.add(montoField);
        panelInputs.add(new JLabel("Método de pago:")); panelInputs.add(metodoField);

        JButton registrarButton = new JButton("Registrar Entrada");
        registrarButton.addActionListener(e -> registrarEntrada());

        salidaPlazaField = new JTextField();
        JButton salidaButton = new JButton("Registrar Salida");
        salidaButton.addActionListener(e -> registrarSalida());

        panelInputs.add(new JLabel("Número de Plaza para salida:")); panelInputs.add(salidaPlazaField);
        panelInputs.add(registrarButton); panelInputs.add(salidaButton);

        add(panelInputs, BorderLayout.NORTH);

        consola = new JTextArea();
        consola.setEditable(false);
        add(new JScrollPane(consola), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2));
        JButton listarClientes = new JButton("Listar Clientes");
        listarClientes.addActionListener(e -> listarClientes());

        JButton listarTickets = new JButton("Listar Tickets");
        listarTickets.addActionListener(e -> listarTickets());

        JButton estadoPlazas = new JButton("Estado de Plazas");
        estadoPlazas.addActionListener(e -> PlazaDeAparcamiento.imprimirEstado());

        JButton informeFinanciero = new JButton("Informe Gerente");
        informeFinanciero.addActionListener(e -> generarInformeGerente());

        panelBotones.add(listarClientes);
        panelBotones.add(listarTickets);
        panelBotones.add(estadoPlazas);
        panelBotones.add(informeFinanciero);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private void registrarEntrada() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String marca = marcaField.getText();
        String patente = patenteField.getText();
        String tipo = tipoField.getText();
        String metodo = metodoField.getText();
        double monto = Double.parseDouble(montoField.getText());

        Vehiculo vehiculo = new Vehiculo(marca, patente, tipo);
        Cliente cliente = new Cliente(nombre, telefono, vehiculo);

        estacionamiento.agregarCliente(cliente);

        Pago pago = new Pago(metodo, monto);
        pagos.add(pago);
        consola.append("Cliente " + nombre + " ingresado. Pago: $" + monto + " (" + metodo + ")\n");

        Cliente.guardarClientes(estacionamiento.getListaClientes(), "clientes.txt");
        Ticket.guardarTickets(estacionamiento.getListaTickets(), "tickets.txt");
        Pago.guardarPagos(pagos, "pagos.txt");

        limpiarCampos();
    }

    private void registrarSalida() {
        try {
            int plaza = Integer.parseInt(salidaPlazaField.getText());
            if (PlazaDeAparcamiento.desocuparPlaza(plaza)) {
                consola.append("Plaza " + plaza + " desocupada.\n");
            } else {
                consola.append("Error al liberar plaza.\n");
            }
        } catch (NumberFormatException e) {
            consola.append("Número de plaza inválido.\n");
        }
    }

    private void listarClientes() {
        consola.append("==== CLIENTES ====\n");
        for (Cliente c : estacionamiento.getListaClientes()) {
            consola.append(c.toString() + "\n");
        }
    }

    private void listarTickets() {
        consola.append("==== TICKETS ====\n");
        for (Ticket t : estacionamiento.getListaTickets()) {
            consola.append(t.toString() + "\n");
        }
    }

    private void generarInformeGerente() {
        Gerente gerente = new Gerente(12345678, "Pedro Gerente");
        gerente.generarInformeFinanciero(pagos);
        gerente.gestionarPersonal(empleados);
    }

    private void limpiarCampos() {
        nombreField.setText("");
        telefonoField.setText("");
        marcaField.setText("");
        patenteField.setText("");
        tipoField.setText("");
        montoField.setText("");
        metodoField.setText("");
        salidaPlazaField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GarageUI().setVisible(true);
        });
    }
}

