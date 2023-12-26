public class Conversor {
    public static String[] convertirIpABinario(String[] ip) {
        String[] binario = new String[4];

        for (int i = 0; i < ip.length; i++) {
            int parteDecimal = Integer.parseInt(ip[i]);
            String parteBinaria = Integer.toBinaryString(parteDecimal);

            // Asegurar que la parte binaria tenga 8 bits
            while (parteBinaria.length() < 8) {
                parteBinaria = "0" + parteBinaria;
            }

            binario[i] = parteBinaria;
        }

        return binario;
    }

    public static void main(String[] args) {
        System.out.println("Ingrese una dirección IP:");
        String[] ip = Recoger.ip();

        System.out.println("Dirección IP ingresada: ");
        for (String parte : ip) {
            System.out.print(parte + ".");
        }

        String[] binario = convertirIpABinario(ip);

        System.out.println("\nDirección IP en binario: ");
        for (String parte : binario) {
            System.out.print(parte + " ");
        }
    }
}
