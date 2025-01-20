// Interfaz Licuadora.java
public interface Licuadora {
    void encender();
    void llenar(String contenido);
    void incrementarVelocidad();
    int getVelocidad();
    boolean estaLlena();
    void vaciar();
}
