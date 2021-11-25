package UD03;

import java.io.*;
import java.util.Scanner;

public class P6_Excepciones {

    public static void main(String[] args) {
        int numero = -1;
        int intentos = 0;
        String linea;
        //BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Scanner teclado = new Scanner (System.in);
        do {
            try {
                System.out.print("Introduzca un número entre 0 y 100: ");
                //linea = teclado.readLine();
                linea = teclado.nextLine();
                numero = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Debe introducir un número entre 0 y 100.");
            } catch (Exception e) {
                System.out.println("Error al leer del teclado.");
            } finally {
                intentos++;
            }
        } while (numero < 0 || numero > 100);
        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);
    }
}