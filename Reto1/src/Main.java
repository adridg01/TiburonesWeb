import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean repetir;
        boolean fallo;
        do {


        System.out.println("""
                  ▄▀▀ ▄▀▄ █   ▄▀▀ █ █ █   ▄▀▄ █▀▄ ▄▀▄ █▀▄ ▄▀▄   █ █▀▄
                  ▀▄▄ █▀█ █▄▄ ▀▄▄ ▀▄█ █▄▄ █▀█ █▄▀ ▀▄▀ █▀▄ █▀█   █ █▀\s
                """);
        // Pide la IP
        System.out.println("Introduce una IP:");
        int[] ip = Recoger.ip();
        System.out.println("Dirección IP ingresada: " + Arrays.toString(ip));

        // Pide la máscara
        int[] mascara = Recoger.mascara();
        System.out.println("Máscara ingresada: " + Arrays.toString(mascara));


        // Rango de direcciones, dirección de difusión y dirección de subred
        System.out.println("""
                 
                 /~______________~\\\s
                 .----------------.\s
                (| Información IP |)
                 '----------------'\s
                 \\_~~~~~~~~~~~~~~_/\s\r""".indent(12));

        RangoDireccion.CalcularRangoIP(ip,mascara);

        // Utiliza la ClaseIP para determinar la clase y el tipo de la IP
        System.out.println("""
                
                /~______________~\\\s
                .----------------.\s
                  (| Clase Ip |)
                '----------------'\s
                \\_~~~~~~~~~~~~~~_/\s""".indent(13));


        char clase = ClaseIP.determinarClase(ip);
        String tipo = ClaseIP.determinarTipo(ip);
        System.out.println("La dirección IP es " + tipo + " y de clase " + clase);

        //Convierte la ip a binario
        System.out.println("""
                     
                     /~______________~\\\s
                     .----------------.\s
                (| Ip y Mascara en binario |)
                     '----------------'\s
                     \\_~~~~~~~~~~~~~~_/\s""".indent(8));


        String binarioip= (Arrays.toString(Conversor.convertirIpABinario(ip)));
        System.out.println("La conversion de la ip a binario es: " + binarioip);

        String binariomasc= (Arrays.toString(Conversor.convertirIpABinario(mascara)));
        System.out.println("La conversion de la mascara a binario es: " + binariomasc);

        System.out.println("\nQuieres calcular otra IP? (1| Si / 2| No)");
        do {
            repetir = true;
            fallo = true;
            String respuesta = scan.nextLine();
        if (Objects.equals(respuesta, "1")){
            System.out.println("\n-- Repitiendo --");
            repetir = false;
        } else if (Objects.equals(respuesta, "2")){
            System.out.println("Apagando Programa");
        } else{
            System.out.println("|Error| solo se puede introducir 1(Si) o 2(No)");
            fallo = false;
        }
        }while (!fallo);
        }while(!repetir);
    }
}
