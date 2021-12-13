/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD04;

import java.util.Scanner;

/**
 *
 * @author davmar
 */
public class array_1 {

    public static void main(String[] args) {
        int[] edad = new int[10];
        int a = 0;
        int b = 1;
        Scanner teclado = new Scanner (System.in);
        System.out.print("Introduce el dato para el componente 0: ");
        edad[0] = teclado.nextInt(); //25
        System.out.println("El componente [0] vale " + edad[0]);
        edad[1] = edad[0] + 1;
        edad[2] = edad[0] + edad[1];
        edad[2]++;
        System.out.println(a);//2 //3
        System.out.println("El componente [1] vale " + edad[1]); //26
        System.out.println("El componente [2] vale " + edad[2]); //52
        System.out.println(edad[8]);//0
        edad[3]++;
        //incrementar todas las posiciones de edad en 1
        for(int i=0;i<10;i++){
            edad[i]++;
        } 
    }
}
