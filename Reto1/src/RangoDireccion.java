
public class RangoDireccion {

    public static void CalcularRangoIP(int[] direccionIP, int[] mascaraIP) {
        // Calcular la cantidad de bits de host
        int bitshost = 0;
        for (int i = 0; i < 4; i++) {
            bitshost += Integer.bitCount(~mascaraIP[i] & 0xFF);
        }

        // Calcular la cantidad de direcciones disponibles para hosts
        int hostsdisponibles = (int) Math.pow(2, bitshost) -2;

        // Determinar la dirección de red y la dirección de difusión
        int[] direccionred = new int[4];
        int[] difusiondireccion = new int[4];

        for (int i = 0; i < 4; i++) {
            direccionred[i] = direccionIP[i] & mascaraIP[i];
            difusiondireccion[i] = (direccionIP[i] | ~mascaraIP[i]) & 0xFF;
        }

        // Ajustar el último octeto de la dirección de difusión
        difusiondireccion[3] = Math.min(difusiondireccion[3], hostsdisponibles +2);

        // Imprimir resultados
        System.out.println("Dirección de subred: " + FormatoDireccionIP(direccionred));
        System.out.println("Dirección de difusión: " + FormatoDireccionIP(difusiondireccion));
        System.out.println("Cantidad de hosts disponibles: " + hostsdisponibles);

        // Imprimir rango de hosts
        int[] primeraDireccionHost = direccionred.clone();
        primeraDireccionHost[3]++;
        int[] ultimaDireccionHost = difusiondireccion.clone();
        ultimaDireccionHost[3]--;

        System.out.println("Rango de direcciones disponibles: " + FormatoDireccionIP(primeraDireccionHost) + " - " + FormatoDireccionIP(ultimaDireccionHost));
    }

    public static String FormatoDireccionIP(int[] direccionIP) {
        return direccionIP[0] + "." + direccionIP[1] + "." + direccionIP[2] + "." + direccionIP[3];
    }
}
