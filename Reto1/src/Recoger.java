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
        String IP;
        do {
            IP = scan.nextLine();
            prueba2 = IP.split("\\.");
            Pattern pattern = Pattern.compile("[^0-9.]");
            do {
                estabien = true;
                try { //Se comprueba si tiene algo que no sea un numero o punto y tira error si es así
                    for (int i = 0; i < IP.length();i++){
                        String algo3 = String.valueOf(IP.charAt(i));
                        Matcher matcher = pattern.matcher(algo3);
                        if (matcher.matches()){
                            estabien = false;
                            throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("Solo puede contener numeros y puntos (formato N1.N2.N3.N4)");
                    IP = scan.nextLine();
                    prueba2 = IP.split("\\.");
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
                    IP = scan.nextLine();
                    prueba2 = IP.split("\\.");
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
        Pattern pattern = Pattern.compile("[^0-32]");

        int[] prueba = new int[4];

        do {
            String seleccion = scan.nextLine();
            Matcher matcher = pattern.matcher(seleccion);
            if (matcher.matches()){
                seleccion = String.valueOf(3);
            }
            if (Integer.parseInt(seleccion) == 1){
                System.out.println("Dime la mascara");

                do {
                    String MString = scan.nextLine();
                    matcher = pattern.matcher(MString);
                    if (matcher.matches()){
                        MString = String.valueOf(33);
                    }
                    int MInt = Integer.parseInt(MString);
                    termina = true;
                if (MInt > 0 && MInt <= 32) { //Pasa la mascara dada en decimal a binario y despues a decimal de nuevo
                    for (int i = 0; i < 32; i++) {
                        conta++;
                        if (i < MInt) {
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
                System.out.println("Numero introducido incorrecto / Letras no aceptadas");
                System.out.println("(1: Ej. 26 / 2: Ej. 255.255.255.0)");
            }
        } while (!termina);

        return prueba;
    }
}
