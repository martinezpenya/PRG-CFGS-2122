package UD02;

public class Pajaro {

    String nombre;
    int posX, posY;

    public Pajaro() {

    }

    public Pajaro(String nombre, int posX, int posY) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
    }

    double volar(int posX, int posY) {
        double desplazamiento = Math.sqrt(posX * posX + posY * posY);
        this.posX = posX;
        this.posY = posY;
        return desplazamiento;
    }

    public static void main(String[] args) {
        //creamos el objeto con parámetros
        Pajaro pajaro1 = new Pajaro("WoodPecker", 50, 50);
        double d1 = pajaro1.volar(50, 50);
        System.out.println("El desplazamiento de " + pajaro1.nombre + " ha sido " + d1);

        Pajaro pajaro2 = new Pajaro();
        //damos nombre y cambiamos la posición de "Piolin" a mano
        pajaro2.nombre = "Piolín";
        pajaro2.posX = 30;
        pajaro2.posY = 30;
        double d2 = pajaro2.volar(pajaro2.posX, pajaro2.posY);
        System.out.println("El desplazamiento de " + pajaro2.nombre + " ha sido " + d2);
    }
}
