import java.util.ArrayList;
import java.util.List;

public class Rescate implements Runnable {

    private Balsa balsa;
    private Barco barco;

    public Rescate(Balsa balsa, Barco barco) {
        this.balsa = balsa;
        this.barco = barco;
    }

    @Override
    public void run() {
        while (true) {
            List<Pasajero> rescatados = new ArrayList<>();
            // Intentar llenar la balsa
            for (int i = 0; i < balsa.getCapacidad(); i++) {
                Pasajero p = barco.obtenerPasajero();
                if (p != null) {
                    rescatados.add(p);
                } else {
                    break; // No hay mas
                }
            }

            if (rescatados.isEmpty()) {
                break; // Barco vacío y balsa vacía
            }

            try {
                // Simular tiempo de ida y vuelta
                Thread.sleep(balsa.getTiempoMs());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            System.out.println("Balsa " + balsa.getNombre() + " ha rescatado a: " + rescatados + " | Quedan: " + barco.getPasajerosRestantes() + " personas en el barco");

            if (!barco.hayPasajeros()) {
                break;
            }
        }
    }
}
