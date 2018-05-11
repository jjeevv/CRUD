/*
 * 
 * Code created by: Jose Espinosa Vazquez
 * 
 */

 /* Paquete */
package crud.emp;

/* Imports */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import crud.bbdd.Basededatos;

/**
 *
 * @author jjeevv
 *
 */
public class Empleados {

    private Connection conexion;
    private ArrayList<Empleado> Empleados;

    /* Agregar */
    public int agregar(Empleado emp) throws SQLException {

        int filas;

        String query = "";
        Basededatos bd = new Basededatos();

        query = "INSERT INTO empleados VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

        PreparedStatement sentencia = bd.conectar().prepareStatement(query);

        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, emp.getFecha_alt());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getDept_no());

        filas = sentencia.executeUpdate();

        /*
        if (sentencia.executeUpdate(query) > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }
         */
        //System.out.println(query);
        sentencia.close();
        bd.conexion.close();

        return filas;
    }

    /* Actualizar */
    public int actualizar(Empleado emp, int emp_no) throws SQLException {

        int filas;
        String query = "";
        Basededatos bd = new Basededatos();

        query = "UPDATE empleados SET apellido=?, oficio=?, dir=?, fecha_alt=?, salario=?, comision=?, dept_no=? WHERE emp_no=?";
        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
        sentenciaP.setString(1, emp.getApellido());
        sentenciaP.setString(2, emp.getOficio());
        sentenciaP.setInt(3, emp.getDir());
        sentenciaP.setDate(4, emp.getFecha_alt());
        sentenciaP.setFloat(5, emp.getSalario());
        sentenciaP.setFloat(6, emp.getComision());
        sentenciaP.setInt(7, emp.getDept_no());
        sentenciaP.setInt(8, emp.getEmp_no());

        filas = sentenciaP.executeUpdate();

        System.out.println("El registro se actualizó exitosamente.");

        sentenciaP.close();
        bd.conexion.close();

        return filas;
    }

    /* Eliminar */
    public int eliminar(int emp_no) throws SQLException {

        int filas;

        String query = "";
        Basededatos bd = new Basededatos();

        query = "DELETE FROM empleados WHERE emp_no = ?";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);

        sentenciaP.setInt(1, emp_no);

        filas = sentenciaP.executeUpdate();

        System.out.println("El registro se eliminó exitosamente.");

        sentenciaP.close();
        bd.conexion.close();

        return filas;

    }

    /* Obtener */
    public Empleado obtener(int emp_no) throws SQLException {

        ResultSet rs;
        String query = "";
        Basededatos bd = new Basededatos();

        query = "SELECT * FROM empleados WHERE Emp_no = ?";

        PreparedStatement sentencia = bd.conectar().prepareStatement(query);

        sentencia.setInt(1, emp_no);
        sentencia.execute();
        rs = sentencia.getResultSet();
        rs.next();
        Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));

        sentencia.close();
        bd.conexion.close();

        return emp;

    }

    /* ArrayList Empleados */
    public ArrayList<Empleado> ListarEmp() throws SQLException {

        String query = "";
        Basededatos bd = new Basededatos();

        ResultSet rs;
        Empleado emp = new Empleado();

        ArrayList<Empleado> empleds = new ArrayList<>();
        query = "SELECT * FROM empleados";

        Statement sentencia = bd.conectar().createStatement();
        ResultSet resultado = sentencia.executeQuery(query);

        rs = sentencia.getResultSet();

        while (rs.next()) {

            emp = new Empleado();
            emp.setEmp_no(rs.getInt(1));
            emp.setApellido(rs.getString(2));
            emp.setOficio(rs.getString(3));
            emp.setDir(rs.getInt(4));
            emp.setFecha_alt(rs.getDate(5));
            emp.setSalario(rs.getFloat(6));
            emp.setComision(rs.getFloat(7));
            emp.setDept_no(rs.getInt(8));
            empleds.add(emp);

        }

        sentencia.close();
        bd.conexion.close();
        return empleds;

    }

    /* Empleados Uno */
    public Empleado ListarEmpUno(int emp_no) throws SQLException {
        /* public ArrayList <Departamento> ListarDepUno() throws SQLException {*/

        String query = "";
        Basededatos bd = new Basededatos();

        ResultSet rs;

        query = "SELECT * FROM Empleados WHERE emp_no = ?";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
        sentenciaP.setInt(1, emp_no);
        sentenciaP.execute();

        //ResultSet rs = sentenciaP.executeQuery(query);
        rs = sentenciaP.getResultSet();
        rs.next();

        Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));

        sentenciaP.close();
        bd.conexion.close();
        return emp;

    }

    /* Empleados BUSCAR */
    public Empleado Buscaremp(String apellido) throws SQLException {
        /* public ArrayList <Departamento> ListarDepUno() throws SQLException {*/

        String query = "";
        Basededatos bd = new Basededatos();

        ResultSet rs;

        query = "SELECT * FROM Empleados WHERE apellido = ?";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
        sentenciaP.setString(1, apellido);
        sentenciaP.execute();

        //ResultSet rs = sentenciaP.executeQuery(query);
        rs = sentenciaP.getResultSet();
        rs.next();

        Empleado emp = new Empleado(rs.getInt("emp_no"), rs.getString("apellido"), rs.getString("oficio"), rs.getInt("dir"), rs.getDate("fecha_alt"), rs.getFloat("salario"), rs.getFloat("comision"), rs.getInt("dept_no"));

        sentenciaP.close();
        bd.conexion.close();
        return emp;

    }

    /* Empleados CREAR */
 /* Empleados BORRAR */
}
