import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Crear pasajeros
        List<Pasajero> pasajeros = new ArrayList<>();
        Random random = new Random();
        // 352 personas
        // Prioridades: 1 (Niños), 2 (Adultos), 3 (Ancianos), 4 (Tripulación)
        for (int i = 1; i <= 352; i++) {
            int prioridad = random.nextInt(4) + 1; // 1 a 4
            pasajeros.add(new Pasajero(i, prioridad));
        }

        Barco barco = new Barco(pasajeros);

        // Crear balsas (tiempos en ms)
        Balsa acasta = new Balsa("Acasta", 1, 500);
        Balsa banff = new Balsa("Banff", 2, 1000);
        Balsa cadiz = new Balsa("Cadiz", 3, 2000);
        Balsa deimos = new Balsa("Deimos", 4, 4000);
        Balsa expedicion = new Balsa("Expedición", 5, 8000);

        // Crear hilos de rescate
        Thread t1 = new Thread(new Rescate(acasta, barco));
        Thread t2 = new Thread(new Rescate(banff, barco));
        Thread t3 = new Thread(new Rescate(cadiz, barco));
        Thread t4 = new Thread(new Rescate(deimos, barco));
        Thread t5 = new Thread(new Rescate(expedicion, barco));

        // Iniciar rescate
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}