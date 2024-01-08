import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Pide la IP
        System.out.println("Dime una IP:");
        int[] ip = Recoger.ip();
        System.out.println("Dirección IP ingresada: " + Arrays.toString(ip));

        // Pide la máscara
        int[] mascara = Recoger.mascara();
        System.out.println("Máscara ingresada: " + Arrays.toString(mascara));
        //Convierte la ip a binario
        String binario= (Arrays.toString(Conversor.convertirIpABinario(ip)));
        System.out.println("La conversion de la ip es: " + binario);
        // Utiliza la ClaseIP para determinar la clase y el tipo de la IP
        char clase = ClaseIP.determinarClase(ip);
        System.out.println("La dirección IP es de clase " + clase);

        // Determina si la IP es pública o privada
        String tipo = ClaseIP.determinarTipo(ip);
        System.out.println("La dirección IP es " + tipo);

        // Rango de direcciones, dirección de difusión y dirección de subred
        RangoDireccion.CalcularRangoIP(ip,mascara);
    }
}
