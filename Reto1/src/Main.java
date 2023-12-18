import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        //Pilla la ip
        System.out.println("Dime una IP");
        String[] ip = Recoger.ip();
        System.out.println(Arrays.toString(ip));
        int[] mascara = Recoger.mascara();
        System.out.println(Arrays.toString(mascara));

    }
}
