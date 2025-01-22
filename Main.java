package hdt1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IBlender blender = new BlenderImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Prender la licuadora");
            System.out.println("2. Llenar la licuadora");
            System.out.println("3. Incrementar velocidad");
            System.out.println("4. Consultar velocidad");
            System.out.println("5. Consultar si está llena");
            System.out.println("6. Vaciar licuadora");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> blender.switchPowerStatus();
                case 2 -> {
                    System.out.print("Ingrese contenido: ");
                    String content = scanner.next();
                    blender.fillBlender(content, 500);
                }
                case 3 -> blender.increaseSpeed();
                case 4 -> System.out.println("Velocidad actual: " + blender.checkSpeed());
                case 5 -> System.out.println("¿Está llena? " + blender.isFull());
                case 6 -> blender.emptyBlender();
            }
        } while (opcion != 7);
    }
}
