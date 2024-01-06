import java.util.Arrays;
public class ClaseIP {

    //Determinamos la clase de IP que tenemos.
    public static char determinarClase(int[] ip) {
        //Cogemos el primer octeto de la IP.
        int primerOcteto = ip[0];

        // Si el primer octeto es menor o igual a 127, es de clase A.
        if (primerOcteto <= 127) {
            return 'A';

            // Si el primer octeto está entre 128 y 191 (inclusive), es de clase B.
        } else if (primerOcteto >= 128 && primerOcteto <= 191) {
            return 'B';

            // Si el primer octeto está entre 192 y 223 (inclusive), es de clase C.
        } else if (primerOcteto >= 192 && primerOcteto <= 223) {
            return 'C';

            // Si el primer octeto está entre 224 y 239 (inclusive), es de clase D.
        } else if (primerOcteto >= 224 && primerOcteto <= 239) {
            return 'D';

            // Si no es ninguna de las anteriores, solo podría ser de clase E, siendo el rango de 240 a 255.
        } else {
            return 'E';
        }
    }

    //Determinamos el tipo de IP (pública o privada).
    public static String determinarTipo(int[] ip) {
        // Verificamos si la IP está en el rango de direcciones privadas.
        if (ip[0] == 10 || (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 31) || (ip[0] == 192 && ip[1] == 168)) {
            return "privada";
        } else {
            return "pública";
        }
    }
}
