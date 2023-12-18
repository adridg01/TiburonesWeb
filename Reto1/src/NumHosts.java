import java.util.Scanner;

public class NumHosts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la dirección IP: ");
        String direccionIP = scanner.next();

        try {
            validarIP(direccionIP);  // Validar la dirección IP
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;  // Salir del programa si la dirección IP no es válida
        }

        System.out.println("Ingrese la máscara de red (en formato CIDR, por ejemplo, 24): ");
        int mascaradered = scanner.nextInt();

        int hostsDisponibles = calcularHostsDisponibles(mascaradered);    //Calcula el numero de hosts disponibles

        System.out.println("El número de hosts disponibles es: " + hostsDisponibles);

    }

    public static void validarIP(String direccionIP) {

        //Dividir la IP con puntos
        String[] partes = direccionIP.split("\\.");

        //Verificar si la IP tiene 4 partes dividida por puntos
        if (partes.length != 4) {
            throw new IllegalArgumentException("La dirección IP debe tener cuatro partes separadas por puntos.");
        }

        for (String parte : partes) {
            int octeto = Integer.parseInt(parte);

            //Si el numero de la IP no está entre 0 y 255 saldrá una advertencia
            if (octeto < 0 || octeto > 255) {
                throw new IllegalArgumentException("Cada octeto de la dirección IP debe estar en el rango de 0 a 255.");
            }
        }
    }

    public static int calcularHostsDisponibles(int mascaradered) {
        // Calcular el número de hosts disponibles
        return (int) Math.pow(2, 32 - mascaradered) - 2;
    }
}