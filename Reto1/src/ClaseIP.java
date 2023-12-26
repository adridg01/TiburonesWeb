import java.util.Scanner;

public class ClaseIP {
    public static void main(String[] args) {
        //Introducimos un scanner para decir el número binario de la IP.
        //Este paso no nos hará falta porque el usuario introducirá la dirección IP en decimal y para la máscara subred se le dará a elegir entre notación CDIR o decimal.
        //Hace falta un conversor de decimal a binario.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la IP en número binario: ");
        String IPbinario = scanner.nextLine();

        //Determinamos la clase y el tipo de la IP.
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
        // Convertimos la IP binaria a decimal.
        //Este paso no hará falta porque el usuario introducirá la IP en decimal.
        String ipDecimal = convertirBinarioADecimal(IPbinario);

        // Convertimos la IP decimal a un array de números.
        String[] partes = ipDecimal.split("\\.");
        int[] numeros = new int[4];
        for (int i = 0; i < 4; i++) {
            numeros[i] = Integer.parseInt(partes[i]);
        }

        // Verificamos si la IP está en el rango de direcciones privadas.
        if (numeros[0] == 10 || (numeros[0] == 172 && numeros[1] >= 16 && numeros[1] <= 31) || (numeros[0] == 192 && numeros[1] == 168)) {
            return "privada";
        } else {
            return "pública";
        }
    }

    // Convierte una dirección IP binaria a decimal.
    //Este paso no  nos hará falta porque el usuario introducirá la IP en decimal.
    public static String convertirBinarioADecimal(String IPbinario) {
        StringBuilder ipDecimal = new StringBuilder();
        for (int i = 0; i < 32; i += 8) {
            String octeto = IPbinario.substring(i, i + 8);
            int decimal = Integer.parseInt(octeto, 2);
            ipDecimal.append(decimal);
            if (i < 24) {
                ipDecimal.append(".");
            }
        }
        return ipDecimal.toString();
    }
}




















