import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recoger {

    public static int[] ip(){
        Scanner scan = new Scanner(System.in);
        String[] prueba2;
        int[] a = new int[4];
        boolean estabien;
        String algo2;
        do {
            algo2 = scan.nextLine();
            prueba2 = algo2.split("\\.");
            Pattern pattern = Pattern.compile("[^0-9.]");
            do {
                estabien = true;
                try { //Se comprueba si tiene algo que no sea un numero o punto y tira error si es así
                    for (int i = 0; i < algo2.length();i++){
                        String algo3 = String.valueOf(algo2.charAt(i));
                        Matcher matcher = pattern.matcher(algo3);
                        if (matcher.matches()){
                            estabien = false;
                            throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("Solo puede contener numeros y puntos (formato N1.N2.N3.N4)");
                    algo2 = scan.nextLine();
                    prueba2 = algo2.split("\\.");
                }
                try { //Comprueba que el numero no sea 2....2..2.2 ( El formato )
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
            }while (!estabien);

            try { //Revisa el numero de apartados
                if (prueba2.length >= 5 | prueba2.length < 4) {
                    estabien = false;
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.out.println("Tiene que haber 4 apartados");
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

        int[] aa = new int[4];
        for (int i = 0; i < a.length; i++) {
            aa[i] = Integer.parseInt(prueba2[i]);
        }

        return aa;
    }

    public static int[] mascara(){
        Scanner scan = new Scanner(System.in);
        System.out.println("En que formato vas a pasar la mascara ( 1: Ej. 26 / 2: Ej. 255.255.255.0)");
        boolean termina = true;
        int contc = 0; // todas estas variables son para pasar la mascara
        int conta = 0;
        int contb = 0;
        int[] prueba = new int[4];

        do {
            String seleccion = scan.nextLine();
            if (Integer.parseInt(seleccion) == 1){
                System.out.println("Dime la mascara");

                do {
                    int a = scan.nextInt();
                    termina = true;
                if (a > 0 && a <= 32) { //Pasa la mascara dada en decimal a binario y despues a decimal de nuevo
                    for (int i = 0; i < 32; i++) {
                        conta++;
                        if (i < a) {
                            contc *= 10;
                            contc += 1;
                        } else {
                            contc *= 10;
                        }
                        if (conta == 8) {
                            String algo = Integer.toString(contc);
                            prueba[contb] = Integer.parseInt(algo, 2);
                            contc = 0;
                            conta = 0;
                            contb++;
                        }
                    }
                }else{
                    System.out.println("Mascara se sale de rango o no ha sido introducida correctamente");
                    termina = false;
                }
                }while(!termina);
            } else if (Integer.parseInt(seleccion) == 2){ // Recoge la mascara como si fuera una IP
                System.out.println("Dime la mascara");
                prueba = Recoger.ip();
            } else{
                termina = false;
                System.out.println("Numero introducido incorrecto");
                System.out.println("( 1: Ej. 26 / 2: Ej. 255.255.255.0)");
            }
        } while (!termina);

        return prueba;
    }
}
