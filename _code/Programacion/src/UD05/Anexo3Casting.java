package UD05;

public class Anexo3Casting {

    public static void main(String[] args) {
        // Casting Implicito
        Persona encargadoCarniceria = new Encargado("Rosa Ramos", 1200,
                "Carniceria");

        // No tenemos disponibles los métodos de la clase Encargado:
        //EncargadaCarniceria.setSueldoBase(1200);
        //EncargadaCarniceria.setSeccion("Carniceria");
        //Pero al imprimir se imprime con el método más específico (luego lo vemos)
        System.out.println(encargadoCarniceria);

        // Casting Explicito
        Encargado miEncargado = (Encargado) encargadoCarniceria;
        //Tenemos disponibles los métodos de la clase Encargado:       
        miEncargado.setSueldoBase(1200);
        miEncargado.setSeccion("Carniceria");
        //Al imprimir se imprime con el método más específico de nuevo.
        System.out.println(miEncargado);
    }
}