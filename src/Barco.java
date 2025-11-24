import java.util.ArrayList;
import java.util.List;

public class Barco {

    private final List<Pasajero> pasajeros = new ArrayList<>();

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    public boolean hayPasajeros(){
        return !pasajeros.isEmpty();
    }

    public synchronized Pasajero obtenerPasajero() {
        if (pasajeros.isEmpty()) {
            return null;
        }

        Pasajero seleccionado = pasajeros.get(0);
        for (Pasajero p : pasajeros) {
            if (p.getPrioridad() < seleccionado.getPrioridad()) {
                seleccionado = p;
            }
        }
        pasajeros.remove(seleccionado);
        return seleccionado;
    }

    public synchronized int getPasajerosRestantes() {
        return pasajeros.size();
    }

}
