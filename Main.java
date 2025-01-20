import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Licuadora licuadora = new LicuadoraImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Prender la licuadora");
            System.out.println("2. Llenar la licuadora");
            System.out.println("3. Incrementar velocidad");
            System.out.println("4. Consultar velocidad");
            System.out.println("5. Consultar si está llena");
            System.out.println("6. Vaciar la licuadora");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    licuadora.encender();
                    break;
                case 2:
                    System.out.print("Ingrese el contenido a licuar: ");
                    String contenido = scanner.nextLine();
                    licuadora.llenar(contenido);
                    break;
                case 3:
                    licuadora.incrementarVelocidad();
                    break;
                case 4:
                    System.out.println("Velocidad actual: " + licuadora.getVelocidad());
                    break;
                case 5:
                    System.out.println("¿Licuadora llena? " + licuadora.estaLlena());
                    break;
                case 6:
                    licuadora.vaciar();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}
