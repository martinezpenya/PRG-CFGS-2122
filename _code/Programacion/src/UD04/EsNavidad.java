package UD04;

/**
 *
 * @author davmar
 */
public class EsNavidad {

    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("ERROR:");
            System.out.println("Llame al programa de la siguiente forma:");
            System.out.println("java EsNavidad dia mes");
        } else {
            // args[0] es el día
            // args[1] es el mes
            if ((Integer.valueOf(args[0]) == 25) && (Integer.valueOf(args[1]) == 12)) {
                    System.out.println("ES NAVIDAD!");
            } else {
                System.out.println("No es navidad.");
            }
        }
    }
}
