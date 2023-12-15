import java.util.Scanner;

public class Recoger {
    public static String[] ip(){
        Scanner scan = new Scanner(System.in);
        String[] prueba2;
        boolean estabien;
        String algo2 = "";
        prueba2 = algo2.split("\\.");
        do {
            try {
                int cont = 0;
                algo2 = scan.nextLine();
                prueba2 = algo2.split("\\.");
                estabien = true;
                if (prueba2.length >= 5) {
                    throw new Exception();
                }
                for (int i = 0; i < algo2.length();i++){
                    int algo3 = Integer.parseInt(prueba2[i]);
                    if (algo3 < 0 || algo3 > 255){
                        cont++;
                    }
                }
                if (cont > 0){
                    throw new ArithmeticException();
                }
            } catch (Exception e) {
                System.out.println("Solo puede haber 4 apartados en el array de 0 a 255");
                estabien = false;
            }
        }while (!estabien);

        return prueba2;
    }
}
