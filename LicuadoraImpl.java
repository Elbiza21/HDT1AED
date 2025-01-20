// Implementación de la licuadora LicuadoraImpl.java
public class LicuadoraImpl implements Licuadora {
    private boolean encendida;
    private boolean llena;
    private int velocidad;
    private String contenido;

    public LicuadoraImpl() {
        this.encendida = false;
        this.llena = false;
        this.velocidad = 0;
    }

    @Override
    public void encender() {
        if (!llena) {
            System.out.println("No se puede encender una licuadora vacía.");
            return;
        }
        encendida = true;
        System.out.println("Licuadora encendida.");
    }

    @Override
    public void llenar(String contenido) {
        if (encendida) {
            System.out.println("Apague la licuadora antes de llenarla.");
            return;
        }
        this.contenido = contenido;
        this.llena = true;
        System.out.println("Licuadora llena con: " + contenido);
    }

    @Override
    public void incrementarVelocidad() {
        if (!encendida || !llena) {
            System.out.println("Primero encienda y llene la licuadora.");
            return;
        }
        if (velocidad < 10) {
            velocidad++;
            System.out.println("Velocidad incrementada a: " + velocidad);
        } else {
            System.out.println("Velocidad máxima alcanzada.");
        }
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public boolean estaLlena() {
        return llena;
    }

    @Override
    public void vaciar() {
        if (encendida) {
            System.out.println("Apague la licuadora antes de vaciarla.");
            return;
        }
        llena = false;
        contenido = null;
        System.out.println("Licuadora vacía.");
    }
}
