package Clases;

import java.io.Serializable;

public class Operador extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    public Operador(int dni, String nombre) {
        super(dni, nombre);
    }

    public void enviarMails() {
        System.out.println("Se envía un mail");
    }

    public void registrarPago(Pago pago) {
        System.out.println("Registrando pago: " + pago.toString());
    }

    public void imprimirTicket(Ticket ticket) {
        System.out.println("Imprimiendo ticket: " + ticket.toString());
    }
}
