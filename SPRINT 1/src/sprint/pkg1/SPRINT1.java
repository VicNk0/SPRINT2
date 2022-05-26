package sprint.pkg1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author victor
 */
public class SPRINT1 {
    public static Scanner lector = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //LLAMAMOS A LA RUTA DONDE ESTÁ EL ARCHIVO
        File tables = new File("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\tables.txt.");
        Scanner leerfichero = new Scanner(tables, "ISO-8859-1");        
        Empleado[] empleados = new Empleado[100];        
        //ABRIMOS ARRAY PARA LISTAR LAS MESAS
        ArrayList<String> listamesas = new ArrayList<>();
        try {
            while (leerfichero.hasNext()) {
                listamesas.add(leerfichero.nextLine());
            }

            leerfichero.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }        
        //Recorremos el fichero y lo almacenamos en el Array dinámico Listamesas
        try {
            while (leerfichero.hasNext()) {
                listamesas.add(leerfichero.nextLine());
            }

            leerfichero.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }
        
        int op = Menu();
        //MENU LOGIN PARA ENTRAR COMO ADMIN O CAMARERO
        if (op == 1){
            boolean login = Login(empleados);
            if (login == true){
                MenuAdmin(empleados);
            }
        } else if (op == 2){
            menuCamarero(leerfichero, listamesas, tables);
        
        }
    }
    
    public static void menuCamarero(Scanner lectorfichero, ArrayList listamesas, File tables) {
        boolean salir = false;
        do {
            int i = 0;
            while (i < 1 || i > 5) {
                System.out.println("INICIANDO...");
                String x = lector.nextLine();
                System.out.println("------ MENU CAMARERO -----");
                System.out.println("-------------");
                System.out.println("1. --Crear Mesa");
                System.out.println("2. --Borrar Mesa");
                System.out.println("3. --Listar Mesas");
                System.out.println("4. --Cerrar sesion");
                System.out.println("Selecciona la opción: ");
                i = lector.nextInt();
            }
            switch (i) {
                case 1:
                    CrearMesa(tables);
                    break;

                case 2:
                    EliminarMesa(tables);                    
                    break;
                case 3:
                    listarmesas(listamesas);
                    break;
                case 4:
                    salir = false;
                    break;
            }
        } while (salir = true);
    }
    
    
    public static void MenuAdmin(Empleado[] empleados){
        boolean salir = false;
        do {
            int i = 0;
            while (i < 1 || i > 4) {
                System.out.println("---- MENU ADMIN -----");
                System.out.println("1. -- Crear Camareros");
                System.out.println("2. -- Ver Camareros");
                System.out.println("3. -- Entrar Como Camarero");
                CrearArchivoDat();
                switch (i) {
                    case 1: //Indica la ruta a una carpeta, crea/escriu al arxiu
                        CrearCamarero();
                        break;
                    case 2:
                        MostrarCamarero();
                        break;
                    case 3:
                }

            }
        }while (salir = true);
    }
    
    public static void CrearMesa(File tables) {
        
        try{           
            FileWriter añadir = new FileWriter(tables, true);
            String linea = pedirdatos();
            añadir.write(linea);
            añadir.close();
        } catch (Exception e){
            System.out.println("No se ha podido añadir una mesa");
        }
    }

    public static String pedirdatos(){
        String nombre, descripcion, niños, ventilador, jardin;
        int capacidad, adultos;
        boolean nenes, venti, jar;
        System.out.print("Nombre de la nueva mesa: ");
        nombre = lector.next();
        System.out.print("Descripcion de la mesa: ");
        descripcion = lector.next();
        System.out.print("Capacidad maxima de personas en la mesa: ");
        capacidad = lector.nextInt();
        System.out.print("Hay sillas de niños en la mesa? ");
        niños = lector.next().toLowerCase();
        String linea = "\n" + nombre + "," + descripcion + "," + capacidad + "," + niños;
        return linea;
    }
    
    
    
    public static void EscribirArchivo() {
        File fichero = new File("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\tables.txt");

        try {
            // El true al final indica que escribiremos al final del fichero añadiendo texto
            FileWriter writer = new FileWriter(fichero, true);
            writer.write("Me alegro.\n");
            writer.write("Un saludo.\n");
            writer.write("Buenas Tardes.\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al crear/escribir en el fichero");
        }
    }

    public static void EliminarMesa(File tables) {        
        // Array para guardar todas las líneas leídas del fichero
        ArrayList<String> lineas = new ArrayList<>();

        // Abrimos el fichero de texto para leerlo en memoria
        try {
            Scanner lectorFichero = new Scanner(tables);
            int i = 0;
            while (lectorFichero.hasNext()) {
                lineas.add(lectorFichero.nextLine());
            }
            lectorFichero.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/leer el fichero");
        }
        // Abrimos el fichero para eliminar
        try {
            FileWriter writer = new FileWriter(tables);
            
            for (String linea : lineas) {
                if (!"NULL;".equals(linea)) {
                    writer.write(linea + "NULL;");
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al abrir/sobreescribir el fichero");
        }
        
                
    }
    
    public static void listarmesas(ArrayList listamesas){
        System.out.println(listamesas);
    }

    public static int pideEntero(Scanner in) {
        int n = 0;
        boolean correcte = false;

        do {
            if (!in.hasNextInt()) {
                System.out.println("No és un nombre enter");
            } else {
                n = in.nextInt();
                correcte = true;
            }
            in.nextLine();
        } while (!correcte);
        return n;
    }
    
    // GUARDAR FICHERO
     public static void CrearArchivoDat(){
         //ObjectInputStream Crearficherodat = null;
     try{
            //Crearficherodat = new ObjectInputStream(new FileInputStream("C:\\Users\\Tavito\\OneDrive\\Escritorio\\SPRINT1\\src\\sprint\\pkg1\\usuario.dat"));
            ObjectOutputStream ficherodat = new ObjectOutputStream(new FileOutputStream("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\usuario.dat"));
            Empleado[] persona = new Empleado[100];
            persona[0] = new Empleado();
            persona[0].user = "admin";
            persona[0].password = "root";
            persona[0].rol = "administrador";

            ficherodat.writeObject(persona);
            ficherodat.close();
        } catch (IOException e) {
            System.out.println("No se ha podido generar el fichero dat");
        }
     } 
     
     public static void CrearCamarero(){
         Empleado[] empleados = null;
         ObjectInputStream ficherodat = null;
         String user, password;
        try{
            ObjectOutputStream escribirficherodat = new ObjectOutputStream(new FileOutputStream("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\usuario.dat"));
            ficherodat = new ObjectInputStream(new FileInputStream("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\usuario.dat"));
            empleados = (Empleado[]) ficherodat.readObject();
            for (int i = 0; i < empleados.length; i++){
                if (empleados[i] == null){
                    System.out.print("Dame el nombre del nuevo usuario");
                    user = lector.nextLine();
                    System.out.print("Dame la password del nuevo usuario");
                    password = lector.nextLine();
                    empleados[i].user = user;
                    empleados[i].password = password;
                    empleados[i].rol = "camarero";
                    i = 9999;

                }
            }
            escribirficherodat.writeObject(empleados);

        } catch(Exception e){
            System.out.println("Error al cargar el fichero");
        }
     }
        // ------------
        // LEER FICHERO
        
     public static void MostrarCamarero(){
        try {
            // A partir de aquí accederemos al fichero a leer mediante la variable fichero
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("C:\\Users\\alumne\\Desktop\\SPRINT 1\\src\\sprint\\pkg1\\fichero.dat"));
            
            // Creamos un nuevo array de Empleados
            // Y rellenamos con lo recuperado de leer el fichero mediante readObject
            // readObject recibe todo un array de Empleados y por eso lo casteamos (Empleado[])
            Empleado[] personal_recuperado = (Empleado[]) fichero.readObject();
            
            // Recorremos todo el array de Empleados
            for (Empleado empleado : personal_recuperado) {
                // Tenemos en cuenta que algunas posiciones del array valen null
                // En ese caso no leas la información del empleado
                if (empleado != null) {
                    System.out.println("Nombre: " + empleado.nombre);
                    System.out.println("Sueldo: " + empleado.sueldo);
                    System.out.println("Fecha: " + empleado.dia + "/" + empleado.mes + "/" + empleado.año);
                    System.out.println("--------------------");
                }
            }
            
            // Cerramos el fichero
            fichero.close();
           
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al leer el fichero");
        }
     }
     
     public static int Menu(){
        int op;
        boolean menu = false;
        do{
            System.out.print("1. Admin o 2. Camarero");
            op = lector.nextInt();
            if (op < 1 || op > 2)
                System.out.println("Opción invalida, por favor escoja una de las siguientes opciones: ");
        } while(menu = false);
        return op;
    }
     
    public static boolean Login(Empleado[] empleados) {        
        boolean Login = false;
        int i = 0;
        String user, password;
        do {
            System.out.print("Introdce el nombre de usuario: ");
            user = lector.nextLine();
            System.out.print("Introdce la password: ");
            password = lector.nextLine();
            for (int x = 0; x < empleados.length; x++) {
                if (user.equals(empleados[x].user) && password.equals(empleados[x].password)) {
                    i = 4;
                    Login = true;
                }
            }
            if (i != 4) {
                System.out.println("Error pruebe otra vez");
            }
        } while (i < 3);        
        return Login;               
    }

}
     
   
    

