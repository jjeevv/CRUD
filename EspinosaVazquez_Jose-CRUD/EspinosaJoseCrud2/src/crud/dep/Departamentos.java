/*
 * 
 * Code created by: Jose Espinosa Vazquez
 * 
 */

 /* Paquete */
package crud.dep;

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
public class Departamentos {

    private Connection conexion;
    private ArrayList<Departamento> departamentos;

    /* Agregar */
    public int agregar(Departamento dep) throws SQLException {

        int filas;

        String query = "";
        Basededatos bd = new Basededatos();

        query = "INSERT INTO departamentos VALUES ( ?, ?, ? )";

        PreparedStatement sentencia = bd.conectar().prepareStatement(query);

        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());

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
    public void actualizar(Departamento dep, int dept_no) throws SQLException {
        String query = "";
        Basededatos bd = new Basededatos();
        try {
            query = "UPDATE departamentos SET dnombre=?, loc=? where dept_no=?";
            PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
            sentenciaP.setString(1, dep.getDnombre());
            sentenciaP.setString(2, dep.getLoc());
            sentenciaP.setInt(3, dep.getDept_no());

            sentenciaP.executeUpdate();
            System.out.println("El registro se actualizó exitosamente.");
            sentenciaP.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* Eliminar */
    public int eliminar(int dept_no) throws SQLException {

        int filas;

        String query = "";
        Basededatos bd = new Basededatos();

        query = "DELETE FROM departamentos WHERE dept_no = ?";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);

        sentenciaP.setInt(1, dept_no);

        filas = sentenciaP.executeUpdate();

        System.out.println("El registro se eliminó exitosamente.");

        sentenciaP.close();
        bd.conexion.close();

        return filas;

    }

    /* Obtener */
    public void obtener(Departamento dep) throws SQLException {
        String query = "";
        Basededatos bd = new Basededatos();
        try {
            query = "SELECT * FROM Departamentos WHERE dept_no = '" + dep.getDept_no() + "';";
            Statement sentencia = bd.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                int dept_no = resultado.getInt("dept_no");
                String dnombre = resultado.getString("dnombre");
                String loc = resultado.getString("loc");

                // Imprimir los resultados.
                System.out.format("%d, %s, %s\n", dept_no, dnombre, loc);
            }

            sentencia.close();
            bd.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* ArrayList Departamentos */
    public ArrayList<Departamento> ListarDep() throws SQLException {

        String query = "";
        Basededatos bd = new Basededatos();

        Departamento dept = new Departamento();

        ArrayList<Departamento> departs = new ArrayList<>();
        query = "SELECT * FROM departamentos";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
        ResultSet rs = sentenciaP.executeQuery(query);

        rs = sentenciaP.getResultSet();
        rs.first();

        while (rs.next()) {

            dept = new Departamento();
            dept.setDept_no(rs.getInt(1));
            dept.setDnombre(rs.getString(2));
            dept.setLoc(rs.getString(3));
            departs.add(dept);

        }

        sentenciaP.close();
        bd.conexion.close();
        return departs;

    }

    /* Departamentos Uno */
    public Departamento ListarDepUno(int dept_no) throws SQLException {
        /* public ArrayList <Departamento> ListarDepUno() throws SQLException {*/

        String query = "";
        Basededatos bd = new Basededatos();

        ResultSet rs;

        query = "SELECT * FROM Departamentos WHERE dept_no = ?";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
        sentenciaP.setInt(1, dept_no);
        sentenciaP.execute();

        //ResultSet rs = sentenciaP.executeQuery(query);
        rs = sentenciaP.getResultSet();
        rs.next();

        Departamento dept = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));

        sentenciaP.close();
        bd.conexion.close();
        return dept;

    }

    /* Departamentos BUSCAR */
    public Departamento BuscarDep(String dnombre) throws SQLException {
        /* public ArrayList <Departamento> ListarDepUno() throws SQLException {*/

        String query = "";
        Basededatos bd = new Basededatos();

        ResultSet rs;

        query = "SELECT * FROM Departamentos WHERE dnombre = ?";

        PreparedStatement sentenciaP = bd.conectar().prepareStatement(query);
        sentenciaP.setString(1, dnombre);
        sentenciaP.execute();

        //ResultSet rs = sentenciaP.executeQuery(query);
        rs = sentenciaP.getResultSet();
        rs.next();

        Departamento dept = new Departamento(rs.getInt("dept_no"), rs.getString("dnombre"), rs.getString("loc"));

        sentenciaP.close();
        bd.conexion.close();
        return dept;

    }

    /* Departamentos CREAR */
 /* Departamentos BORRAR */
}
