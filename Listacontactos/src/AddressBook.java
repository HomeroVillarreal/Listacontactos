import java.io.*;
import java.util.*;

public class AddressBook
{
    private final Map<String, String> Agenda;
    private final String BD;
    public AddressBook(String BD)
    {
        this.Agenda=new HashMap<>();
        this.BD=BD;
    }
    public void load()
    {
        try (BufferedReader reader=new BufferedReader(new FileReader(BD)))
        {
            String Celda;
            while ((Celda=reader.readLine()) != null)
            {
                String[] celda=Celda.split(",");
                String numero=celda[0];
                String nombre=celda[1];
                Agenda.put(numero,nombre);
            }
            System.out.println("La informacion se cargo correctamente.");
        }
        catch (IOException any)
        {
            System.out.println("No existe base de datos, crearemos una para esta sesion.");
        }
    }
    public void save()
    {
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(BD)))
        {
            for (Map.Entry<String, String> entry : Agenda.entrySet())
            {
                String numero=entry.getKey();
                String nombre=entry.getValue();
                String linea=numero+","+nombre;
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("La informacion se proceso correctamente.");
        }
        catch (IOException any)
        {
            System.out.println("Error cargando la informacion: ");
        }
    }
    public void list()
    {
        System.out.println("Contactos:");
        System.out.println("----------");
            int count = 0;
            for (Map.Entry<String, String> entry : Agenda.entrySet())
            {
                String numero = entry.getKey();
                String nombre = entry.getValue();
                System.out.println("#" + count + "  " + numero + " : " + nombre);
                count++;
            }
            System.out.println("----------");
    }
    public void create(String numero, String nombre)
    {
        Agenda.put(numero, nombre);
        System.out.println("Contacto creado con exito: "+numero+" : "+nombre);
    }
    public void delete(String numero)
    {
        if (Agenda.containsKey(numero))
        {
            String nombre=Agenda.remove(numero);
            System.out.println("Contacto se borro con exito: "+numero+" : "+nombre);
        }
        else
        {
            System.out.println("No exite ese contacto: "+numero);
        }
    }
}