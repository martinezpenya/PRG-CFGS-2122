package UD05;

public class Anexo3Casting {

    public static void main(String[] args) {
        // Casting Implicito
        Persona encargadoCarniceria = new Encargado("Rosa Ramos", 0, null);
        // Casting Explicito
        Encargado miEncargado = (Encargado) encargadoCarniceria;
        miEncargado.setSueldoBase(1200);
        miEncargado.setSeccion("Carniceria");
        // Muestra los datos de la Persona que es Encargado 
        System.out.println(encargadoCarniceria.toString());
        
        // Muestra los datos de la Persona que es Encargado
        Empleado empleadoCarniceria = new Empleado("Rosa Ramos", 0);        
        System.out.println(empleadoCarniceria instanceof Encargado); //false
        System.out.println(empleadoCarniceria.getClass()); //class Empleado
        System.out.println(empleadoCarniceria.getClass().getSuperclass()); //class Persona
    }
}
