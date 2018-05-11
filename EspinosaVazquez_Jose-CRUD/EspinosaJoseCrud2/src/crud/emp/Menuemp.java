/*
 * 
 * Code created by: Jose Espinosa Vazquez
 * 
 */

 /* Paquete */
package crud.emp;

/* Imports */
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author jjeevv
 *
 */
public class Menuemp {

    Scanner sc = new Scanner(System.in);

    /* OPCION DE LISTADO DE EMPLEADOS DE TODOS O UNO */
    public void listadoemp() throws SQLException {

        Empleado empt;
        Empleado empsi = new Empleado();
        Empleados empts1 = new Empleados();
        Empleados empts = new Empleados();

        System.out.println(" <1> Todos | <2> Uno ");

        switch (Integer.parseInt(sc.nextLine())) {

            case 1:

                ArrayList<Empleado> emps = new ArrayList<>();

                emps = empts.ListarEmp();

                System.out.println("\n");
                System.out.println("+-------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-14s | %n", "NºEmpleado", "Apellido", "Oficio");
                System.out.println("+_________________________________________________+");

                for (int i = 0; i < emps.size(); i++) {

                    System.out.printf("|%-15d |%-15s |%-15s| %n", emps.get(i).getEmp_no(), emps.get(i).getApellido(), emps.get(i).getOficio());

                }

                System.out.println("+-------------------------------------------------+");

                break;

            case 2:

                System.out.println("\n");
                System.out.println("Introduce el Numero del Empleado");

                empsi = empts1.ListarEmpUno(sc.nextInt());

                System.out.println("\n");
                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s | %n", "NºEmpleado", "Apellido", "Oficio", "Direccion", "Fecha", "Salario", "Comision", "NºDepartamento");
                System.out.println("_________________________________________________________________________________________________________________________________________ ");
                System.out.printf(
                        "|%-15d |%-15s |%-15s |%-15d |%-15s |%-15f |%-15f |%-15d | %n",
                        empsi.getEmp_no(),
                        empsi.getApellido(),
                        empsi.getOficio(),
                        empsi.getDir(),
                        empsi.getFecha_alt(),
                        empsi.getSalario(),
                        empsi.getComision(),
                        empsi.getDept_no()
                );

                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

                break;

        }

    }

    /* Opcion de BUSQUEDA */
    public void buscar() throws SQLException {

        Empleado empt;
        Empleado empsi = new Empleado();
        Empleados empts1 = new Empleados();
        Empleados empts = new Empleados();

        System.out.println("Introduce el Nombre del Empleado: ");

        empsi = empts1.Buscaremp(sc.nextLine());

        System.out.println("\n");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s | %n", "NºEmpleado", "Apellido", "Oficio", "Direccion", "Fecha", "Salario", "Comision", "NºDepartamento");
        System.out.println("_________________________________________________________________________________________________________________________________________ ");

        System.out.printf(
                "|%-15d |%-15s |%-15s |%-15d |%-15s |%-15f |%-15f |%-15d | %n",
                empsi.getEmp_no(),
                empsi.getApellido(),
                empsi.getOficio(),
                empsi.getDir(),
                empsi.getFecha_alt(),
                empsi.getSalario(),
                empsi.getComision(),
                empsi.getDept_no()
        );

        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

    }

    /* Opcion de CREACION */
    public void crear() throws SQLException, ParseException {

        Empleado empt = null;
        Empleados empts = new Empleados();

        int emp_no;
        String apellido;
        String oficio;
        int dir;
        String fecha;
        Date fecha_alt;
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        float salario;
        float comision;
        int dept_no;

        System.out.println("Escribe el Numero del Empleado");
        emp_no = sc.nextInt();
        System.out.println("Escribe el Apellido del Empleado");
        apellido = sc.next();
        System.out.println("Escribe el Oficio del Empleado");
        oficio = sc.next();
        System.out.println("Escribe la Direccion del Empleado");
        dir = sc.nextInt();
        System.out.println("Escribe la Fecha > yyyy/mm/dd");
        fecha = sc.next();
        java.util.Date ud = df.parse(fecha);
        long ms = ud.getTime();
        fecha_alt = new java.sql.Date(ms);
        //fecha_alt = (Date) df.parse(fecha);
        System.out.println("Escribe el Salario del Empleado");
        salario = sc.nextFloat();
        System.out.println("Escribe la Comision del Empleado");
        comision = sc.nextFloat();
        System.out.println("Escribe el Numero del Departamento");
        dept_no = sc.nextInt();

        empt = new Empleado(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no);

        empts.agregar(empt);
        System.out.println("Se ha agregado correctamente el Empleado");

    }

    /* Opcion de BORRADO */
    public void borrar() throws SQLException {

        Empleados empts = new Empleados();
        int emp_no;

        System.out.println("Introduce el Numero del Empleado para borrar");

        emp_no = sc.nextInt();
        empts.eliminar(emp_no);

        System.out.println("Se ha eliminado correctamente el Empleado");

    }

}
