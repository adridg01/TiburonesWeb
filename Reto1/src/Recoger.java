import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Recoger {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ip()));
    }
    public static String[] ip(){
        Scanner scan = new Scanner(System.in);
        String[] prueba2;
        boolean estabien;
        String algo2;
        do {
            algo2 = scan.nextLine();
            prueba2 = algo2.split("\\.");
            do {
                estabien = true;
                try { //Comprueba que el numero no sea 2....2..2.2
                    for (String s : prueba2) {
                        if (Objects.equals(s, "")){
                            estabien = false;
                            throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("El numero tiene que estar en el siguiente formato N1.N2.N3.N4");
                    algo2 = scan.nextLine();
                    prueba2 = algo2.split("\\.");
                }
                try {
                    for (String s : prueba2) {
                        if (Objects.equals(s, "[a-zA-Z]")){
                            estabien = false;
                            throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("El numero no puede contener letras");
                    algo2 = scan.nextLine();
                    prueba2 = algo2.split("\\.");
                }
            }while (!estabien);

            try { //Revisa el numero de apartados
                if (prueba2.length >= 5) {
                    estabien = false;
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.out.println("Solo puede haber 4 apartados");
            }
                try { //Revisa que entre en el rango la ip
                    for (String s : prueba2) {
                        int algo3 = Integer.parseInt(s);
                        if (algo3 < 0 || algo3 > 255) {
                            estabien = false;
                            throw new ArithmeticException();
                        }
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Tienen que estar entre 0 y 255");
                }
        }while (!estabien);
        return prueba2;
    }
}
