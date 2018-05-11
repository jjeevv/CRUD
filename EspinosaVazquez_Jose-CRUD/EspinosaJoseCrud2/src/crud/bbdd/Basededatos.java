/*
 * 
 * Code created by: Jose Espinosa Vazquez
 * 
 */

 /* Paquete */
package crud.bbdd;

/* Imports */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jjeevv
 *
 */
public class Basededatos {

    private final String URL = "jdbc:mysql://localhost:3306/"; // Ubicación de la BD.
    private final String BD = "ejemplo"; // Nombre de la BD.
    private final String USER = "ejemplo";
    private final String PASSWORD = "ejemplo";

    public Connection conexion = null;

    @SuppressWarnings("finally")
    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL + BD, USER, PASSWORD);
            if (conexion != null) {
                System.out.println("¡Conexión Exitosa!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return conexion;
        }
    }

}
