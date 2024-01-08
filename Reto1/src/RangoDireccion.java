public class RangoDireccion {

    public static void CalcularRangoIP(int[] direccionIP, int[] mascaraIP) {
        // Calcular la cantidad de bits de host
        int bitshost = 32 - mascaraIP[3];

        // Calcular la cantidad de direcciones disponibles para hosts
        int hostsdisponibles = (int) Math.pow(2, bitshost) - 2;

        // Determinar la dirección de red y la dirección de difusión
        int[] direccionred = new int[4];
        int[] difusiondireccion = new int[4];

        for (int i = 0; i < 4; i++) {
            direccionred[i] = direccionIP[i] & mascaraIP[i];
            difusiondireccion[i] = (direccionIP[i] & mascaraIP[i]) | (~mascaraIP[i] & 0xFF);
        }

        // Imprimir resultados
        System.out.println("Dirección de red: " + FormatoDireccionIP(direccionred));
        System.out.println("Dirección de difusión: " + FormatoDireccionIP(difusiondireccion));
        System.out.println("Cantidad de direcciones disponibles: " + hostsdisponibles);
    }

    private static String FormatoDireccionIP(int[] direccionIP) {  //Devuelve la IP con el orden de los arrays
        return direccionIP[0] + "." + direccionIP[1] + "." + direccionIP[2] + "." + direccionIP[3];
    }
}
