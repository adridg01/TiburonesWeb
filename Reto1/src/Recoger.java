import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recoger {

    public static int[] ip(){
        Scanner scan = new Scanner(System.in);
        String[] IPsinPuntos;
        int[] a = new int[4];
        boolean estabien;
        String IP;
        do {
            IP = scan.nextLine();
            IPsinPuntos = IP.split("\\.");
            Pattern pattern = Pattern.compile("[^0-9.]");
            do {
                estabien = true;
                try { //Se comprueba si tiene algo que no sea un numero o punto y tira error si es así
                    for (int i = 0; i < IP.length();i++){
                        String caracter = String.valueOf(IP.charAt(i));
                        Matcher matcher = pattern.matcher(caracter);
                        if (matcher.matches()){
                            estabien = false;
                            throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("Solo puede contener numeros y puntos (formato N1.N2.N3.N4)");
                    IP = scan.nextLine();
                    IPsinPuntos = IP.split("\\.");
                }
                try { //Comprueba que el numero no sea 2....2..2.2 ( El formato )
                    for (String s : IPsinPuntos) {
                        if (Objects.equals(s, "")){
                            estabien = false;
                            throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("El numero tiene que estar en el siguiente formato N1.N2.N3.N4");
                    IP = scan.nextLine();
                    IPsinPuntos = IP.split("\\.");
                }
            }while (!estabien);

            try { //Revisa el numero de apartados
                if (IPsinPuntos.length >= 5 | IPsinPuntos.length < 4) {
                    estabien = false;
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.out.println("Tiene que tener 4 octetos");
            }
            try { //Revisa que entre en el rango la ip
                for (String s : IPsinPuntos) {
                    int octetos = Integer.parseInt(s);
                    if (octetos < 0 || octetos > 255) {
                        estabien = false;
                        throw new ArithmeticException();
                    }
                }
            } catch (ArithmeticException e) {
                System.out.println("El número de cada octeto tiene que estar situado entre 0 y 255 (ambos inclusive)");
            }
        }while (!estabien);

        int[] IpArray = new int[4];
        for (int i = 0; i < a.length; i++) {
            IpArray[i] = Integer.parseInt(IPsinPuntos[i]);
        }

        return IpArray;
    }

    public static int[] mascara(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pulsa 1 o 2 para elegir en que formato vas pasar la máscara ( 1: Notación CDIR Ej. 26 / 2: Notación de decimal Ej. 255.255.255.0 )");
        boolean termina;
        int contc = 0; // todas estas variables son para pasar la mascara
        int conta = 0;
        int contb = 0;
        Pattern pattern = Pattern.compile("[^0-9]");

        int[] mascara = new int[4];

        do {
            String seleccion = scan.nextLine();
            for (int i = 0; i < seleccion.length();i++){
                String caracter = String.valueOf(seleccion.charAt(i));
                Matcher matcher2 = pattern.matcher(caracter);
                if (matcher2.matches()){
                    seleccion = String.valueOf(3);
                }
            }
            if(Objects.equals(seleccion, "")){
                seleccion = String.valueOf(3);
            }
            if (Integer.parseInt(seleccion) == 1){
                System.out.println("Introduce la mascara");
                do {
                    String MString = scan.nextLine();
                    for (int i = 0; i < MString.length();i++){
                        String caracter = String.valueOf(MString.charAt(i));
                        Matcher matcher2 = pattern.matcher(caracter);
                        if (matcher2.matches()){
                            MString = String.valueOf(33);
                        }
                    }
                    if(Objects.equals(MString, "")){
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
                                mascara[contb] = Integer.parseInt(algo, 2);
                                contc = 0;
                                conta = 0;
                                contb++;
                            }
                        }
                    }else{
                        System.out.println("La máscara se sale de rango o no ha sido introducida correctamente");
                        termina = false;
                    }
                }while(!termina);
            } else if (Integer.parseInt(seleccion) == 2){ // Recoge la mascara como si fuera una IP
                do {
                termina = true;

                System.out.println("Introduce la mascara");
                mascara = Recoger.ip();
                for (int i = 0; i < 3;){
                    if(mascara[i] < 255 & mascara[i + 1] > 0){
                        termina = false;
                        i = 5;
                        System.out.println("El valor de algun octeto es mayor que el anterior");
                    }else if (mascara[i] == 255 | mascara[i] < 255){
                        i++;
                    }
                }
                } while(!termina);
            } else{
                termina = false;
                System.out.println("Número introducido incorrecto / Letras no aceptadas");
                System.out.println("Pulsa 1 o 2 (1: Notación CDIR Ej. 26 / 2: Notación de decimal Ej. 255.255.255.0))");
            }
        } while (!termina);

        return mascara;
    }
}
