import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] prueba = new int[4];
        String[] prueba2 = new String[4];
        int a = 16; // Esto es la mascara
        int aaa = 0; // todas estas variables son para pasar la mascara
        int conta = 0;
        int contb = 0;
        String cosofor;

        //Pilla la ip
        System.out.println("Dime una IP");
        String algo2 = scan.nextLine();
        algo2 = algo2.replace("."," ");

        //Intenta pasar a Array ( solo pasa el primer numero de momento )
        for (int i = 0; i < 3; i++){
            cosofor = algo2.substring(0,algo2.indexOf(" "));
            prueba2[i] = cosofor;

        }
        //Se imprime el array y el String
        System.out.println(Arrays.toString(prueba2));
        System.out.println(algo2);

        //Pasa la mascara a binario y después a decimal
        for (int i = 0; i < 32; i++) {
            conta++;
            if (i < a) {
                aaa *= 10;
                aaa += 1;
            } else {
                aaa *= 10;
            }
            if (conta == 8) {
                String algo = Integer.toString(aaa);
                prueba[contb] = Integer.parseInt(algo,2);
                aaa = 0;
                conta = 0;
                contb++;
            }
        }
        System.out.println(Arrays.toString(prueba));
    }
}
