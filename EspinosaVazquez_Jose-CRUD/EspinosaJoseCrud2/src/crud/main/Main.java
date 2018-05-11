/*
 * 
 * Code created by: Jose Espinosa Vazquez
 * 
 */

 /* Paquete */
package crud.main;

/* Imports */
import crud.emp.Empleado;
import crud.emp.Empleados;
import crud.dep.Departamento;
import crud.dep.Departamentos;
import crud.dep.Menudep;
import crud.emp.Menuemp;
import crud.bbdd.Basededatos;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jjeevv
 *
 */
public class Main {

    public static void main(String[] args) throws SQLException, ParseException {

        /* Variables */
        Departamento dept = null;
        Departamentos depts = new Departamentos();

        Empleado empt = null;
        Empleados empts = new Empleados();

        int opcion;

        Menudep menudp = new Menudep();
        Menuemp menuem = new Menuemp();

        //boolean seguir =true;
        //while(seguir){
        /* Opciones del Menu */
        System.out.println("\n");

        System.out.println(
                "+---------- MENU ----------+");
        System.out.println(
                "| <1> Listar Departamentos |  \n"
                + "| <2> Listar Empleados     |  \n"
                + "| <3> Buscar Departamento  |  \n"
                + "| <4> Buscar Empleado      |  \n"
                + "| <5> Crear  Departamento  |  \n"
                + "| <6> Crear  Empleado      |  \n"
                + "| <7> Borrar Departamento  |  \n"
                + "| <8> Borrar Empleado      |    "
        );
        System.out.println(
                "+--------------------------+");

        System.out.println("\n");

        Scanner sc = new Scanner(System.in);

        /* Leer Numeros del Menu */
        opcion = sc.nextInt();

        /* Switch del Menu */
        switch (opcion) {

            /* Opcion 1 - Listar Departamentos */
            case 1:

                menudp.listadodep();

                break;

            /* Opcion 2 - Listar Empleados */
            case 2:

                menuem.listadoemp();

                break;

            /* Opcion 3 - Buscar Departamentos */
            case 3:

                menudp.buscar();

                break;

            /* Opcion 4 - Buscar Empleado */
            case 4:

                menuem.buscar();

                break;

            /* Opcion 5 - Crear Departamentos */
            case 5:

                menudp.crear();

                break;

            /* Opcion 6 - Crear Empleado */
            case 6:

                menuem.crear();

                break;

            /* Opcion 7 - Borrar Departamentos */
            case 7:

                menudp.borrar();

                break;

            /* Opcion 8 - Borrar Empleado */
            case 8:

                menuem.borrar();

                break;

            /* Opcion 9 - Cerrar Menu */
            //}
        }
        /* Creando Empleados Nuevos */

        //Empleado empdats = new Empleado(1112, "JOSE", "BOSS", 1235, Date.valueOf(LocalDate.now()), 0, 0, 10);
        //Empleados empconex = new Empleados();
        //empconex.agregar(empdats);
        //empconex.eliminar(1112);
        //empconex.agregar(empdats);
        //empconex.actualizar(empdats, 1112);
        //empconex.obtener(1112);
    }

}
