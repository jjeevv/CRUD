/*
 * 
 * Code created by: Jose Espinosa Vazquez
 * 
 */

 /* Paquete */
package crud.dep;

/* Imports */
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jjeevv
 *
 */
public class Menudep {

    Scanner sc = new Scanner(System.in);

    /* Opcion de LISTADO */
    public void listadodep() throws SQLException {

        Departamento dept;
        Departamentos depts = new Departamentos();
        Departamentos depts1 = new Departamentos();
        Departamento depi = new Departamento();

        ArrayList<Departamento> deptm = new ArrayList<>();

        /*
        Departamentos deps = new Departamentos();
        Departamento depi = new Departamento();        
         */
        Scanner sc = new Scanner(System.in);

        System.out.println(" 1 - Todos | 2 - Uno ");
        System.out.println("\n");

        switch (Integer.parseInt(sc.nextLine())) {

            case 1:

                /*
                deps.ListarDep();
                deps = depts.ListarDep();
                 */
                deptm = depts.ListarDep();

                System.out.println("\n");
                System.out.println("+-------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s | %n", "NºDepartamento", "Nombre", "Localizacion");
                System.out.println("+_________________________________________________+");

                for (int i = 0; i < deptm.size(); i++) {

                    System.out.printf("|%-15d |%-15s |%-15s| %n", deptm.get(i).getDept_no(), deptm.get(i).getDnombre(), deptm.get(i).getLoc());

                }

                System.out.println("+-------------------------------------------------+");

                break;

            case 2:

                /*
                int leerdep;                
                leerdep = sc.nextInt();
                 */
                System.out.println("\n");
                System.out.println("Introduce el Numero del Departamento");

                depi = depts1.ListarDepUno(sc.nextInt());

                System.out.println("\n");
                System.out.println("+-------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s | %n", "NºDepartamento", "Nombre", "Localizacion");
                System.out.println("+_________________________________________________+");

                System.out.printf("|%-15d |%-15s |%-15s| %n", depi.getDept_no(), depi.getDnombre(), depi.getLoc());

                System.out.println("+-------------------------------------------------+");

                break;

        }

    }

    /* Opcion de BUSQUEDA */
    public void buscar() throws SQLException {

        Departamento dept;
        Departamentos depts = new Departamentos();
        Departamentos depts1 = new Departamentos();
        Departamento depi = new Departamento();

        System.out.println("\n");
        System.out.println("Introduce el Nombre del Departamento");    
        
        depi = depts1.BuscarDep(sc.nextLine());

        System.out.println("\n");
        System.out.println("+----------------------------------+");
        System.out.printf("|%-15s |%-15s | %n", "NºDepartamento", "Nombre Dep");
        System.out.println("____________________________________");
        System.out.printf("|%-15d |%-15s | %n", depi.getDept_no(), depi.getDnombre());
        System.out.println("+----------------------------------+");
        
    }

    /* Opcion de CREACION */
    public void crear() throws SQLException {

        Departamento dept = null;
        Departamentos depts = new Departamentos();
        int dept_no;
        String dnombre;
        String loc;

        System.out.println("Escribe el Numero del Departamento");
        dept_no = sc.nextInt();
        System.out.println("Escribe el Nombre del Departamento");
        dnombre = sc.next();
        System.out.println("Escribe la Localizacion del Departamento");
        loc = sc.next();

        dept = new Departamento(dept_no, dnombre, loc);

        depts.agregar(dept);
        System.out.println("Se ha agregado correctamente el Departamento");

    }

    /* Opcion de BORRADO */
    public void borrar() throws SQLException {

        Departamentos depts = new Departamentos();
        int dept_no;

        System.out.println("Escribe el numero del Departamento para borrar");

        dept_no = sc.nextInt();
        depts.eliminar(dept_no);

        System.out.println("Se ha eliminado correctamente el Departamento: " + dept_no);

    }

}
