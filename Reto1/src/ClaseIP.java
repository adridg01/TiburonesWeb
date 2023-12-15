import java.util.Scanner;

public class ClaseIP {
    public static void main(String[] args) {
        //Introducimos un scanner para decir el número binario de la IP.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la IP en número binario: ");
        String IPbinario = scanner.nextLine();

        char clase = determinarClase(IPbinario);
        System.out.println("La dirección IP es de clase " + clase);

        // Determinamos si la IP es pública o privada.
        String tipo = determinarTipo(IPbinario);
        System.out.println("La dirección IP es " + tipo);
    }

    //Determinamos la clase de IP que tenemos.
    public static char determinarClase(String IPbinario) {
        //Cogemos el primer dígito del binario.
        char primerBit = IPbinario.charAt(0);

        //Si su primer dígito empieza por 0 será de clase A.
        if (primerBit == '0') {
            return 'A';

            //Si sus dos primeros dígitos son 10 será de clase B.
        }
        if (primerBit == '1' && IPbinario.charAt(1) == '0') {
            return 'B';

            //Si sus tres primeros dígitos son 110 será de clase C.
        }
        if (primerBit == '1' && IPbinario.charAt(1) == '1' && IPbinario.charAt(2) == '0') {
            return 'C';

            //Si sus cuatro primeros dígitos son 1110 será de clase D.
        }
        if (primerBit == '1' && IPbinario.charAt(1) == '1' && IPbinario.charAt(2) == '1' && IPbinario.charAt(3) == '0') {
            return 'D';

            //Si no es ninguna de las anteriores solo podría ser de clase E, siendo sus cuatro primeros dígitos 1111.
        } else {
            return 'E';
        }
    }

    //Determinamos el tipo de IP (pública o privada).
    public static String determinarTipo(String IPbinario) {
        // Convertimos la IP binaria a decimal para facilitar la comparación.

    }
}












