import java.util.*;

/**
 * @author Homero Villarreal
 * */

public class Main
{
    public static void main(String[] args)
    {
        AddressBook addressBook=new AddressBook("contactos.txt");
        addressBook.load();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Menu de tu lista");
            System.out.println("1. Mostrar contactos");
            System.out.println("2. Crear nuevo contacto");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Salir");
            System.out.println("Ingresa el numero de tu seleccion: ");
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op)
            {
                case 1:
                    System.out.println("----------");
                    addressBook.list();
                    break;
                case 2:
                    System.out.println("Ingresa el numero del contacto: ");
                    String numero=scanner.nextLine();
                    System.out.println("Ingresa el nombre del contacto: ");
                    String nombre=scanner.nextLine();
                    addressBook.create(numero,nombre);
                    addressBook.save();
                    break;
                case 3:
                    System.out.println("Ingresa el numero del contacto: ");
                    String borr=scanner.nextLine();
                    addressBook.delete(borr);
                    addressBook.save();
                    break;
                case 4:
                    System.out.println("Cerrando app...");
                    return;
                default:
                    System.out.println("No es una opcion valida.");
            }
        }
    }
}