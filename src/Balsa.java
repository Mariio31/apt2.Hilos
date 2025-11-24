public class Balsa {

    private String nombre;
    private int capacidad;
    private int tiempoMs;

    public Balsa(String nombre, int capacidad, int tiempoMs) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempoMs = tiempoMs;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTiempoMs() {
        return tiempoMs;
    }

}
