/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD04;

/**
 *
 * @author davmar
 */
public class NewClass {

    public static double pluviosidadMediaAscendente(double lluvia[]) {
        double suma = 0;
        //Recorremos el array
        for (int i = 0; i < lluvia.length; i++) {
            suma += lluvia[i];
        }
        double media = suma / lluvia.length;
        return media;
    }
    public static void main(String[] args) {
        double[] lluviasEnero = new double[31];
        double[] lluviasFebrero = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,5,7.7,9.2,0,0,0,0,0,0,0,0,0,0};
        
        System.out.println(pluviosidadMediaAscendente(lluviasEnero));
        System.out.println(pluviosidadMediaAscendente(lluviasFebrero));
    }
}
