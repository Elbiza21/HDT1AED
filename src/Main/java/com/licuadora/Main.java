package hdt1;

import com.licuadora.BlenderImpl;
import com.licuadora.IBlender;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IBlender blender = new BlenderImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Bienvenido al programa de la licuadora");

        while (true) {
            try {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Encender/Apagar la licuadora");
                System.out.println("2. Llenar la licuadora (cantidad específica)");
                System.out.println("3. Llenar la licuadora al máximo");
                System.out.println("4. Incrementar velocidad");
                System.out.println("5. Reducir velocidad");
                System.out.println("6. Consultar velocidad actual");
                System.out.println("7. Consultar si está llena");
                System.out.println("8. Vaciar la licuadora completamente");
                System.out.println("9. Vaciar una cantidad específica");
                System.out.println("10. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        byte status = blender.switchPowerStatus();
                        System.out.println(status == 1 ? "Licuadora encendida." : "Licuadora apagada.");
                        break;

                    case 2:
                        if (blender.checkPowerStatus() == 0) {
                            System.out.println("Encienda la licuadora primero.");
                        } else {
                            System.out.print("Ingrese el contenido: ");
                            String content = scanner.next();
                            System.out.print("Ingrese la cantidad en ml: ");
                            float amount = scanner.nextFloat();
                            blender.fillBlender(content, amount);
                            System.out.println("Licuadora llenada con " + amount + " ml de " + content + ".");
                        }
                        break;

                    case 3:
                        if (blender.checkPowerStatus() == 0) {
                            System.out.println("Encienda la licuadora primero.");
                        } else {
                            System.out.print("Ingrese el contenido: ");
                            String content = scanner.next();
                            blender.fillBlender(content);
                            System.out.println("Licuadora llenada al máximo con " + content + ".");
                        }
                        break;

                    case 4:
                        try {
                            blender.increaseSpeed();
                            System.out.println("Velocidad incrementada a: " + blender.checkSpeed());
                        } catch (IllegalStateException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        blender.decreaseSpeed();
                        System.out.println("Velocidad reducida a: " + blender.checkSpeed());
                        break;

                    case 6:
                        System.out.println("Velocidad actual: " + blender.checkSpeed());
                        break;

                    case 7:
                        System.out.println(blender.isFull() ? "La licuadora está llena." : "La licuadora no está llena.");
                        break;

                    case 8:
                        blender.emptyBlender();
                        System.out.println("Licuadora vaciada completamente.");
                        break;

                    case 9:
                        System.out.print("Ingrese la cantidad a vaciar en ml: ");
                        float amount = scanner.nextFloat();
                        try {
                            blender.emptyBlender(amount);
                            System.out.println("Se vaciaron " + amount + " ml de la licuadora.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 10:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        return;

                    default:
                        System.out.println("Opción no válida. Por favor, intente nuevamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar entrada incorrecta
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
}
