import java.util.Scanner;

public class PruebaRangoDireccion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la dirección IP al usuario
        System.out.println("Ingrese la dirección IP: ");
        String direccionIP = scanner.next();

        // Solicitar la máscara de subred al usuario
        System.out.println("Ingrese la máscara de subred: ");
        String subnetMask = scanner.next();

        // Comprobar si la IP es válida
        try {
            CalcularRangoIP(direccionIP, subnetMask);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void CalcularRangoIP(String direccionIP, String mascaraIP) {
        // Convertir la dirección IP y la máscara de subred a arreglos de enteros
        int[] direccion = ConvertirDireccionIP(direccionIP);
        int[] mascara = ConvertirDireccionIP(mascaraIP);

        // Calcular la cantidad de bits de host
        int bitshost = 32 - mascara[3];

        // Calcular la cantidad de direcciones disponibles para hosts
        int hostsdisponibles = (int) Math.pow(2, bitshost) - 2;

        // Determinar la dirección de red y la dirección de difusión
        int[] direccionred = new int[4];
        int[] difusiondireccion = new int[4];

        for (int i = 0; i < 4; i++) {
            direccionred[i] = direccion[i] & mascara[i];
            difusiondireccion[i] = (direccion[i] & mascara[i]) | (~mascara[i] & 0xFF);
        }

        // Imprimir resultados
        System.out.println("Dirección de red: " + FormatoDireccionIP(direccionred));
        System.out.println("Dirección de difusión: " + FormatoDireccionIP(difusiondireccion));
        System.out.println("Cantidad de direcciones disponibles: " + hostsdisponibles);
    }

    private static int[] ConvertirDireccionIP(String direccionIP) {
        int[] result = new int[4];
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(direccionIP, ".");  //Divide la cadena en puntos
        int i = 0;
        while (tokenizer.hasMoreTokens()) {  //transforma cada "token" a una variable int
            result[i++] = Integer.parseInt(tokenizer.nextToken());  //token= octeto

        }
        return result;
    }

    private static String FormatoDireccionIP(int[] direccionIP) {  //Devuelve la IP con el orden de los arrays
        return direccionIP[0] + "." + direccionIP[1] + "." + direccionIP[2] + "." + direccionIP[3];
    }
}
