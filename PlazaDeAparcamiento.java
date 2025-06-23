package Clases;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PlazaDeAparcamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Map<Integer, Boolean> plazas = new HashMap<>();

    static {
        for (int i = 1; i <= 100; i++) {
            plazas.put(i, true); // true = libre, false = ocupada
        }
    }

    public static boolean ocuparPlaza(int numero) {
        if (plazas.containsKey(numero) && plazas.get(numero)) {
            plazas.put(numero, false);
            return true;
        }
        return false;
    }

    public static boolean desocuparPlaza(int numero) {
        if (plazas.containsKey(numero) && !plazas.get(numero)) {
            plazas.put(numero, true);
            return true;
        }
        return false;
    }

    public static boolean estaLibre(int numero) {
        return plazas.getOrDefault(numero, false);
    }

    public static void guardarEstado(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<Integer, Boolean> entry : plazas.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarEstado(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            plazas.clear();
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    int numero = Integer.parseInt(partes[0]);
                    boolean libre = Boolean.parseBoolean(partes[1]);
                    plazas.put(numero, libre);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirEstado() {
        for (Map.Entry<Integer, Boolean> entry : plazas.entrySet()) {
            System.out.println("Plaza " + entry.getKey() + ": " + (entry.getValue() ? "Libre" : "Ocupada"));
        }
    }
}
