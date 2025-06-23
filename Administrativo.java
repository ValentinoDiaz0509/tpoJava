package Clases;

import java.io.Serializable;

public class Administrativo extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    public Administrativo(int dni, String nombre) {
        super(dni, nombre);
    }

    public void registrarSalidaDeVehiculo(int numeroPlaza) {
        if (PlazaDeAparcamiento.desocuparPlaza(numeroPlaza)) {
            System.out.println("Plaza " + numeroPlaza + " desocupada correctamente.");
        } else {
            System.out.println("Error: La plaza " + numeroPlaza + " ya está libre o no existe.");
        }
    }

    public void generarInforme() {
        System.out.println("Generando informe de estado de las plazas...");
        PlazaDeAparcamiento.imprimirEstado();
    }
}
